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
}