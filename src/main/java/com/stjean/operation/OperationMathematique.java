package com.stjean.operation;

public class OperationMathematique {
	public boolean estPositif(int a){
        if(a>0){
            return true;
        }else {
            return false;
        }
    }
	public int factoriel(int a){
        if(a==0 || a==1){
            return 1;
        }
        return a * factoriel(a-1);
    }

}
