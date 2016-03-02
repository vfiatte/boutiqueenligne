/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boutiqueenligne.service;

import boutiqueenligne.entity.CodePromo;
import boutiqueenligne.entity.Commande;
import boutiqueenligne.enumeration.TypeCode;
import boutiqueenligne.exception.CodeInvalideException1;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author admin
 */
@Service
public class CalculPrixTotalAvecPromoService {

    @Autowired
    CommandeService commandeService;

    @Autowired
    CodePromoService codePromoService;

    public void generationCodePromo(int valeur, TypeCode TypeCode) {
        CodePromo code = new CodePromo();
        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        String codeg = "";
        for (int x = 0; x < 5; x++) {
            int i = (int) Math.floor(Math.random() * 36);
            codeg += chars.charAt(i);
        }
        code.setCode(codeg);
        code.setType(TypeCode);
        code.setValeur(valeur);
        codePromoService.save(code);
    }

    public void calculPrixTotal(Commande c, CodePromo cp) throws CodeInvalideException1 {
        double prixT = commandeService.findOne(c.getId()).getPrixTotale();

        if (codePromoService.findByCode(cp.getCode()) == null){
            throw new CodeInvalideException1();
        }

        if (cp.getType() == TypeCode.REMISE) {
            prixT = prixT - cp.getValeur();
            c.setPrixTotale(prixT);
            commandeService.save(c);
            if (cp.getValeur() > c.getPrixTotale()) {
                prixT = 0;
                c.setPrixTotale(prixT);
                commandeService.save(c);
            }
        }
        if (cp.getType() == TypeCode.POURCENTAGE) {
            double r = prixT / 100 * cp.getValeur();
            prixT = prixT - r;
            c.setPrixTotale(prixT);
            commandeService.save(c);

        }

    }
}
