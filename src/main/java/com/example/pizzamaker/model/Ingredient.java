package com.example.pizzamaker.model;

public class Ingredient {
    private String nom;
    private double preu;
    private String categoria;

    // Constructor
    public Ingredient(String nom, double preu, String categoria) {
        this.nom = nom;
        this.preu = preu;
        this.categoria = categoria;
    }

    // Getters y Setters
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public double getPreu() {
        return preu;
    }

    public void setPreu(double preu) {
        this.preu = preu;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    @Override
    public String toString() {
        return nom + " (" + preu + "€)";
    }
}
