/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boutiqueenligne.test;

import boutiqueenligne.entity.Utilisateur;
import boutiqueenligne.service.UtilisateurService;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import boutiqueenligne.spring.SpringConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
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
    UtilisateurService utilisateurService;
    
    
    @Test
    public void doNadaOK(){
        Utilisateur u = new Utilisateur();
        u.setEmail("fezf");
        u.setMdp("fzerg");
        utilisateurService.save(u);
    }
    
}
