/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boutiqueenligne.service;

import org.springframework.stereotype.Service;

/**
 *
 * @author admin
 */
@Service
public class ConfigService {
    private String emailAdmin = "admin@boutique.com";
    private String emailInscriptionMessage = "Votre inscription a bien été prise en compte, merci de cliquer sur le lien suivant pour la valider";
    private String emailInscriptionTitre = "Validation de votre inscription";

    public String getEmailAdmin() {
        return emailAdmin;
    }

    public void setEmailAdmin(String emailAdmin) {
        this.emailAdmin = emailAdmin;
    }

    public String getEmailInscriptionMessage() {
        return emailInscriptionMessage;
    }

    public void setEmailInscriptionMessage(String emailInscriptionMessage) {
        this.emailInscriptionMessage = emailInscriptionMessage;
    }

    public String getEmailInscriptionTitre() {
        return emailInscriptionTitre;
    }

    public void setEmailInscriptionTitre(String emailInscriptionTitre) {
        this.emailInscriptionTitre = emailInscriptionTitre;
    }
    
    
            
}
