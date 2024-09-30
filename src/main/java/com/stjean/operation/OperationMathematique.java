package com.stjean.operation;

import java.util.Arrays;

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
	public static int[] trier(int[] listes) {
        // Créer une copie du tableau d'origine pour le trier
        int[] copie = Arrays.copyOf(listes, listes.length);
        Arrays.sort(copie); // Tri par défaut (croissant)
        
        // Inverser le tableau pour obtenir l'ordre décroissant
        for (int i = 0; i < copie.length / 2; i++) {
            int temp = copie[i];
            copie[i] = copie[copie.length - 1 - i];
            copie[copie.length - 1 - i] = temp;
        }
        
        return copie; // Retourner le tableau trié
    }

    public static void main(String[] args) {
        int[] liste = {5, 2, 8, 3, 1};
        int[] listeTriee = trier(liste);
        
        System.out.println(Arrays.toString(listeTriee)); // Afficher le tableau trié
    }
}
