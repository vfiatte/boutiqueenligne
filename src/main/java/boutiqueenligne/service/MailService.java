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
public class MailService {
    
    public void mailEnvoyé(String Emeteur, String Dest, String Titre, String Message) {
        System.out.println("Mail Inscription envoyé");
    }

    public void click() {
        System.out.println("L'inscription est validée");
    }
    
}
