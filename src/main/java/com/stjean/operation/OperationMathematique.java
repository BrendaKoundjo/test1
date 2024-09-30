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

}
