/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boutiqueenligne.service;

import boutiqueenligne.entity.Article;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author admin
 */
public interface ArticleService extends CrudRepository<Article, Long>{
//        public List<Article> findByNom(Article a);
//    public List<Article> findByCategorieIdOrderByPrixAsc(long id);
//    public List<Article> findByCategorieId(long id);
//    public List<Article> findByNomOrderByStock(String nom);
//    public List<Article> findByNomOrderByPrixAsc(String nom);
    
}
