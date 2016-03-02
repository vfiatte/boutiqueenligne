/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boutiqueenligne.service;

import boutiqueenligne.entity.Commande;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author admin
 */
public interface CommandeService extends CrudRepository<Commande, Long>{
//    public List<Commande> findByUtilisateurIdOrderbyDateDeCommandeAsc(long id);
//    public List<Commande> findByUtilisateurIdOrderbyDateDeCommandeDesc(long id);
//    public List<Commande> findByUtilisateurIdOrderbyPrixAsc(long id);
//    public List<Commande> findByUtilisateurIdOrderbyPrixDesc(long id);
//    public List<Commande> findByModeLivraisonIdOrderbyNom(long id);
//    public List<Commande> findByNom(String s);
//    public List<Commande> findByPrixTotalOrderByPrixTotalAsc(long id);
//    public List<Commande> findByPrixTotalOrderByPrixTotalDesc(long id);
    
    
}
