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

    public void initCommande(Article a, int i) throws StockInsufisantException {
        Commande c = new Commande();
        SousCommande sc = new SousCommande();
        double prixT = c.getPrixTotale();
        double prix = a.getPrix();
        if (i <= a.getStock()) {
            c.setPrixTotale(prixT + prix * i);
            sc.setQuantité(i++);
            a.getSousCommandes().add(sc);
            sc.setArticle(a);

            sousCommandeService.save(sc);

            c.getSousCommandes().add(sc);
            sc.setCommande(c);

            commandeService.save(c);
            sousCommandeService.save(sc);
            
            
        } else {
            System.out.println("Stock Insuffisant");
            throw new StockInsufisantException();
            

        }

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
