package com.stjean.operation;

import java.util.Collections;
import java.util.List;

public class OperationMathematique {
	public static boolean estPositif(int a){
        if(a>0){
            return true;
        }else {
            return false;
        }
    }
	public static int factoriel(int a){
        if(a==0 || a==1){
            return 1;
        }
        return a * factoriel(a-1);
    }
	public static List<Integer> trier(List<Integer> listes) {
        Collections.sort(listes, Collections.reverseOrder()); // Tri décroissant
        return listes; // Retourner la liste triée
    }
	 // Méthode pour retourner le plus grand nombre d'un tableau
    public static double maxNumba(double[] valeurs) {
        if (valeurs == null || valeurs.length == 0) {
            throw new IllegalArgumentException("Le tableau ne doit pas être vide.");
        }
        
        double max = valeurs[0];
        for (double valeur : valeurs) {
            if (valeur > max) {
                max = valeur;
            }
        }
        return max;
    }

}
