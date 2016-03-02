/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boutiqueenligne.service;

import boutiqueenligne.entity.Article;
import boutiqueenligne.entity.Commande;
import boutiqueenligne.entity.SousCommande;
import boutiqueenligne.exception.StockInsufisantException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author admin
 */
@Service
public class PaiementService {

    @Autowired
    ArticleService articleService;

    @Autowired
    SousCommandeService sousCommandeService;

    @Autowired
    CommandeService commandeService;

    @Autowired
    MailService mailService;

    @Autowired
    ConfigService configService;

    public void initSousCommande(Article a, int quantite) throws StockInsufisantException {
        SousCommande sc = new SousCommande();

        if (quantite <= a.getStock()) {
            for (int i = 0; i <= quantite; i++) {
                a.getSousCommandes().add(sc);
                sc.setArticle(a);
                sc.setQuantité(quantite);
                sousCommandeService.save(sc);
            }
        } else {
            System.out.println("Stock Insuffisant");
            throw new StockInsufisantException();
        }

    }

    public void initCommande() {
        Commande c = new Commande();
        double prixT = c.getPrixTotale();

        List<SousCommande> commande = c.getSousCommandes();

        for (SousCommande sc : commande) {
            Article a = sc.getArticle();
            double prix = a.getPrix() * sc.getQuantité();
            prixT = prixT + prix;
            c.setPrixTotale(prixT);
            commandeService.save(c);
            sousCommandeService.save(sc);
//            c.getSousCommandes().add(sc);
//            sc.setCommande(c);
        }
        commandeService.save(c);

    }

    public void commandePayee(Commande c) {

        List<SousCommande> commande = c.getSousCommandes();
        for (SousCommande com : commande) {
            Article a = com.getArticle();
            long stock = a.getStock() - com.getQuantité();
            a.setStock(stock);

            c.setPaye(true);
            c.setPrixTotale(0);
            a.setNbVente(com.getQuantité());

            commandeService.save(c);
            articleService.save(a);
//            mailService.mailEnvoyé(configService.getEmailAdmin(), c.getUtilisateur().getEmail(), configService.getEmailConfirmationdeCommandeTitre(), configService.getEmailConfirmationDeCommande());

        }
    }

    public void commandeLivrée(Commande c) {
        c.setLivre(true);
        commandeService.save(c);
    }
}
