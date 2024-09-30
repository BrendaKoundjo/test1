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
}
