/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boutiqueenligne.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author admin
 */
@Service
public class DataBaseService {
    @Autowired
    ArticleService articleService;
    
    @Autowired
    CategorieService categorieService;
    
    @Autowired
    CodePromoService codePromoService;
    
    @Autowired
    CommandeService commandeService;
    
    @Autowired
    ModeLivraisonService modeLivraisonService;
    
    @Autowired
    SousCommandeService sousCommandeService;
    
    @Autowired
    UtilisateurService utilisateurService;
    
    public void deleteAll(){
        sousCommandeService.deleteAll();
        commandeService.deleteAll();
        utilisateurService.deleteAll();
        modeLivraisonService.deleteAll();
        articleService.deleteAll();
        categorieService.deleteAll();
        codePromoService.deleteAll();
    }
}
