package com.stjean.operation;

public class Utilisateur {
    private int id;
    private String nom;
    private int age;
    private String email;
    private String telephone;
    private String ville;
    private double soldePersonnel;

    public Utilisateur(int id, String nom, int age, String email, String telephone, String ville, double soldePersonnel) {
        this.id = id;
        this.nom = nom;
        this.age = age;
        this.email = email;
        this.telephone = telephone;
        this.ville = ville;
        this.soldePersonnel = soldePersonnel;
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public int getAge() {
        return age;
    }

    public String getEmail() {
        return email;
    }

    public String getTelephone() {
        return telephone;
    }

    public String getVille() {
        return ville;
    }

    public double getSoldePersonnel() {
        return soldePersonnel;
    }
    import java.util.ArrayList;

    public class SoldePersonnel {
        // Propriété statique pour stocker la liste des utilisateurs
        private static ArrayList<Utilisateur> users = new ArrayList<>();

        // Méthode pour ajouter un utilisateur
        public static void ajouter(Utilisateur user) throws EmailInvalidException {
            if (!validerEmail(user.getEmail())) {
                throw new EmailInvalidException("Email invalide : " + user.getEmail());
            }
            users.add(user);
        }

        // Méthode pour supprimer un utilisateur
        public static void supprimer(int id) throws SuppressionInvalidException {
            Utilisateur userToRemove = null;
            for (Utilisateur user : users) {
                if (user.getId() == id) {
                    userToRemove = user;
                    break;
                }
            }
            if (userToRemove == null) {
                throw new SuppressionInvalidException();
            }
            users.remove(userToRemove);
        }

        // Méthode pour lister les utilisateurs
        public static ArrayList<Utilisateur> lister() {
            return new ArrayList<>(users);
        }

        // Méthode pour afficher un utilisateur par ID
        public static Utilisateur afficher(int id) {
            for (Utilisateur user : users) {
                if (user.getId() == id) {
                    return user;
                }
            }
            return null; // Utilisateur non trouvé
        }

        // Méthode pour valider un email
        private static boolean validerEmail(String email) {
            String emailRegex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
            return email.matches(emailRegex);
        }
    }
}