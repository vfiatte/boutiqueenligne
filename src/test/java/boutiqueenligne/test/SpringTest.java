/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boutiqueenligne.test;

import boutiqueenligne.entity.Article;
import boutiqueenligne.entity.Commande;
import boutiqueenligne.entity.SousCommande;
import boutiqueenligne.entity.Utilisateur;
import boutiqueenligne.enumeration.TypeCode;
import boutiqueenligne.enumeration.TypeUtilisateur;
import boutiqueenligne.service.ArticleService;
import boutiqueenligne.service.CalculPrixTotalAvecPromoService;
import boutiqueenligne.service.CodePromoService;
import boutiqueenligne.service.CommandeService;
import boutiqueenligne.service.PaiementService;
import boutiqueenligne.service.DataBaseService;
import boutiqueenligne.service.UtilisateurService;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import boutiqueenligne.spring.SpringConfig;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 *
 * @author ETY
 */

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes=SpringConfig.class)
public class SpringTest {
    
    @PersistenceContext
    private EntityManager em;
    
    @Autowired
    CalculPrixTotalAvecPromoService cpt;
    
    @Autowired
    UtilisateurService utilisateurService;
    
    @Autowired
    CommandeService commandeService;
    
    @Autowired 
    CodePromoService codePromoService;
    
    @Autowired
    ArticleService articleService;
    
    @Autowired
    PaiementService commandeServiceImpl;
    
    @Autowired
    DataBaseService dataBaseService;
    
    @Autowired
    PaiementService paiementService;
    
    @Before
    public void init(){       
        
//    Commande c = new Commande();
//    c.setPrixTotale(500);
//    c.setId(1L);
//    cpt.generationCodePromo(20, TypeCode.POURCENTAGE);
//    commandeService.save(c);
    
    Utilisateur u = new Utilisateur();
    u.setEmail("valentin.fiatte@gmail.com");
    u.setMdp("mdp");
    u.setNom("FIATTE");
    u.setPrenom("Valentin");
    u.setTelephone("0676204126");
    u.setVille("Bordeaux");
    u.setCodePostal("33000");
    u.setTypeUtil(TypeUtilisateur.ADMIN);
    utilisateurService.save(u);
    
    Article a = new Article();
    a.setNom("Ordinateur");
    a.setPrix(1000);
    a.setStock(4);
    a.setId(1L);
    
    
    Article a1 = new Article();
    a1.setNom("Telephone");
    a1.setPrix(600);
    a1.setStock(8);
    a1.setId(2L);
    
    articleService.save(a);
    articleService.save(a1);
            
//    SousCommande sc = new SousCommande();
//    a.get
    
            
    }
 
    @Test
    public void doNadaOK(){
//          cpt.calculPrixTotal(commandeService.findOne(1L), codePromoService.findOne(1L));
//          commandeService.save(commandeService.findOne(1L));
//          System.out.println(commandeService.findOne(1L).getPrixTotale());
//        Commande c =commandeService.findOne(1L);
//        CodePromo cp = codePromoService.findOne(1L);
//        cpt.calculPrixTotal(c, cp);
//        commandeService.save(c);
//        cpt.generationCodePromo(20, TypeCode.REMISE);
//        Commande c = new Commande();
        
       paiementService.initCommande(articleService.findOne(1L), 2);
       paiementService.commandePayee(commandeService.findOne(3L));
              
    }
    
}
