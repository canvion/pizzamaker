package com.example.pizzamaker.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Pizza {
    private String id;
    private List<Ingredient> ingredients;
    private double preuTotal;
    private int tempsPrep;
    private LocalDateTime dataCreacio;

    // Constructor
    public Pizza() {
        this.ingredients = new ArrayList<>();
        this.dataCreacio = LocalDateTime.now();
        this.id = generateId();
    }

    private String generateId() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd-HHmmss");
        return "PIZZA-" + dataCreacio.format(formatter);
    }

    // Calcular precio total
    public void calcularPreuTotal() {
        this.preuTotal = ingredients.stream()
                .mapToDouble(Ingredient::getPreu)
                .sum();

        // descuento si > 12€
        if (this.preuTotal > 12) {
            this.preuTotal = this.preuTotal * 0.9; // 10% descuento
        }
    }

    // Calcular tiempo de preparación: base 5 min + 1 min por ingrediente extra
    public void calcularTempsPrep() {
        this.tempsPrep = 5 + ingredients.size();
    }

    // Agregar ingrediente
    public void afegirIngredient(Ingredient ingredient) {
        this.ingredients.add(ingredient);
    }

    // Getters y Setters
    public String getId() {
        return id;
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    public double getPreuTotal() {
        return preuTotal;
    }

    public int getTempsPrep() {
        return tempsPrep;
    }

    public LocalDateTime getDataCreacio() {
        return dataCreacio;
    }

    // Obtener lista de nombres de ingredientes
    public String getIngredientsNoms() {
        return ingredients.stream()
                .map(Ingredient::getNom)
                .reduce((a, b) -> a + ", " + b)
                .orElse("Sense ingredients");
    }
}
