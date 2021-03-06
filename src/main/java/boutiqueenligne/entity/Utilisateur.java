/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boutiqueenligne.entity;

import boutiqueenligne.enumeration.TypeUtilisateur;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 *
 * @author admin
 */
@Entity
public class Utilisateur implements Serializable {

    @OneToMany(mappedBy = "utilisateur")
    private List<Commande> commandesPassees = new ArrayList<Commande>();

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @Column(unique = true, length = 32)
    private String email;
    @Column(length = 32)
    private String mdp;
    @Column(length = 128)
    private String adresse;
    @Column(length = 6)
    private String codePostal;
    @Column(length = 13)
    private String telephone;
    @Column(length = 32)
    private String nom;
    @Column(length = 32)
    private String prenom;
    @Column(length = 32)
    private String ville;
    
    private TypeUtilisateur typeUtil;

    public Utilisateur() {
    }

    public List<Commande> getCommandesPassees() {
        return commandesPassees;
    }

    public void setCommandesPassees(List<Commande> commandesPassees) {
        this.commandesPassees = commandesPassees;
    }
    
    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public TypeUtilisateur getTypeUtil() {
        return typeUtil;
    }

    public void setTypeUtil(TypeUtilisateur typeUtil) {
        this.typeUtil = typeUtil;
    }
    
    

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMdp() {
        return mdp;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getCodePostal() {
        return codePostal;
    }

    public void setCodePostal(String codePostal) {
        this.codePostal = codePostal;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
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
        if (!(object instanceof Utilisateur)) {
            return false;
        }
        Utilisateur other = (Utilisateur) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "streaming.entity.Utilisateur[ id=" + id + " ]";
    }
    
}
