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
	    @Test
	    public void testAnalyserSoldeGeneral() {
	        try {
	            Utilisateur user1 = new Utilisateur(1, "John Doe", 30, "john.doe@example.com", "0123456789", "Paris", 500.0);
	            Utilisateur user2 = new Utilisateur(2, "Jane Doe", 25, "jane.doe@example.com", "0123456789", "Lyon", -600.0);
	            SoldePersonnel.ajouter(user1);
	            SoldePersonnel.ajouter(user2);
	            SoldePersonnel.analyserSoldeGeneral();
	            fail("Une exception NegativeGeneralBalanceException devrait être lancée.");
	        } catch (NegativeGeneralBalanceException e) {
	            assertEquals("Le solde général est négatif : -100.0", e.getMessage());
	        } catch (EmailInvalidException e) {
	            fail("L'exception ne devrait pas être lancée pour des emails valides.");
	        }
	    }

	    @Test
	    public void testUtilisateurLePlusRiche() {
	        Utilisateur user1 = new Utilisateur(3, "Alice", 28, "alice@example.com", "0123456789", "Marseille", 700.0);
	        Utilisateur user2 = new Utilisateur(4, "Bob", 35, "bob@example.com", "0123456789", "Nice", 1200.0);
	        try {
	            SoldePersonnel.ajouter(user1);
	            SoldePersonnel.ajouter(user2);
	            Utilisateur richestUser = SoldePersonnel.utilisateurLePlusRiche();
	            assertNotNull(richestUser);
	            assertEquals("Bob", richestUser.getNom());
	        } catch (EmailInvalidException e) {
	            fail("L'exception ne devrait pas être lancée pour des emails valides.");
	        }
	    }
}