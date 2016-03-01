/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boutiqueenligne.entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 *
 * @author admin
 */
@Entity
public class SousCommande implements Serializable {

    @ManyToOne
    @JoinColumn(name = "COMMANDE_ID")
    private Commande commande;
    
    @ManyToOne
    @JoinColumn(name = "ARTICLE_ID")
    private Article article;
    
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    private long quantité;

    public SousCommande() {
    }
    
    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public long getQuantité() {
        return quantité;
    }

    public void setQuantité(long quantité) {
        this.quantité = quantité;
    }
    
    

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SousCommande)) {
            return false;
        }
        SousCommande other = (SousCommande) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "streaming.entity.SousCommande[ id=" + id + " ]";
    }
    
}
