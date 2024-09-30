package stjean.testclasse;

import org.junit.Test;
import static org.junit.Assert.*;

import com.stjean.operation.OperationMathematique;

public class TestOperationMathematique {

	   private final OperationMathematique op = new OperationMathematique();

	    @Test
	    public void testEstPositif() {
	        assertTrue(op.estPositif(5));   // Test avec un nombre positif
	        assertFalse(op.estPositif(-3));  // Test avec un nombre négatif
	        assertFalse(op.estPositif(0));   // Test avec zéro
	    }

	    @Test
	    public void testFactoriel() {
	        assertEquals(1, op.factoriel(0));  // Factoriel de 0
	        assertEquals(1, op.factoriel(1));  // Factoriel de 1
	        assertEquals(120, op.factoriel(5)); // Factoriel de 5
	        assertEquals(720, op.factoriel(6)); // Factoriel de 6

	        // Test d'un nombre négatif
	        try {
	            op.factoriel(-1);
	            fail("Une exception devrait être lancée pour un nombre négatif");
	        } catch (StackOverflowError e) {
	            // Cela est attendu pour les appels récursifs avec des nombres négatifs
	        }
	    }
	    @Test
	    public void testMaxNumba() {
	        // Cas de test normal
	        double[] valeurs = {1.5, 2.5, 3.5, 0.5};
	        assertEquals(3.5, Statistiques.maxNumba(valeurs), 0.001);

	        // Cas avec un seul élément
	        double[] valeursUnElement = {7.5};
	        assertEquals(7.5, Statistiques.maxNumba(valeursUnElement), 0.001);

	        // Cas avec des nombres négatifs
	        double[] valeursNegatives = {-1.0, -2.0, -3.0};
	        assertEquals(-1.0, Statistiques.maxNumba(valeursNegatives), 0.001);

	        // Cas avec un tableau vide (devrait lancer une exception)
	        try {
	            Statistiques.maxNumba(new double[]{});
	            fail("Une exception devrait être lancée pour un tableau vide.");
	        } catch (IllegalArgumentException e) {
	            assertEquals("Le tableau ne doit pas être vide.", e.getMessage());
	        }

	        // Cas avec des valeurs nulles (devrait lancer une exception)
	        try {
	            Statistiques.maxNumba(null);
	            fail("Une exception devrait être lancée pour un tableau null.");
	        } catch (IllegalArgumentException e) {
	            assertEquals("Le tableau ne doit pas être vide.", e.getMessage());
	        }
	    }
}