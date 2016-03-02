/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boutiqueenligne.service;

import boutiqueenligne.entity.Mail;
import boutiqueenligne.entity.Utilisateur;
import boutiqueenligne.enumeration.TypeUtilisateur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author admin
 */
@Service
public class InscriptionConnexionService {

    @Autowired
    UtilisateurService utilisateurService;

    @Autowired
    MailService mailService;

    @Autowired
    ConfigService configService;

    public void inscription(Utilisateur u, Mail m) {

        utilisateurService.save(u);
        mailService.mailEnvoyé(configService.getEmailAdmin(), u.getEmail(), configService.getEmailInscriptionTitre(), configService.getEmailInscriptionTitre());
        System.out.println("Utilisateur créé et mail d'inscription envoyé");
    }

    public void validationInscription(Utilisateur u) {
        mailService.click();
        u.setTypeUtil(TypeUtilisateur.UTILISATEUR);
        System.out.println("Utilisateur validé");
        utilisateurService.save(u);
    }

    public void login(String email, String mdp){

        Utilisateur u = new Utilisateur();

        utilisateurService.findOne(u.getId()).getEmail();

        if (utilisateurService.findOne(u.getId()).getMdp() == mdp) {
            System.out.println("Connexion OK");
        } else {
            System.out.println("Mot de passe incorect");

        }
    }

}


