/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boutiqueenligne.service;

import boutiqueenligne.entity.Article;
import boutiqueenligne.entity.Commande;
import boutiqueenligne.entity.SousCommande;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author admin
 */
@Service
public class PaiementService{

    @Autowired
    ArticleService articleService;
    
    @Autowired
    SousCommandeService sousCommandeService;
    
    @Autowired
    CommandeService commandeService;
    
    public void initCommande(Article a, int i){
        Commande c = new Commande();
        SousCommande sc = new SousCommande();
        double prixT = c.getPrixTotale();
        double prix = a.getPrix();
        c.setPrixTotale(prixT + prix*i);
        sc.setQuantité(i++);
        a.getSousCommandes().add(sc);
        sc.setArticle(a);
        sousCommandeService.save(sc);
        c.getSousCommandes().add(sc);
        sc.setCommande(c);
        commandeService.save(c);
        sousCommandeService.save(sc);
        
    }
    
    public void commandePayee(Commande c){
        
       
        List<SousCommande> commande = c.getSousCommandes();
        for (SousCommande com : commande){
            Article a = com.getArticle();
            long stock = a.getStock() - com.getQuantité();
            a.setStock(stock);
        
        c.setPaye(true);
        c.setPrixTotale(0);
       
        commandeService.save(c);
        articleService.save(a);
        }
    }
    
    
    
   
    
}
