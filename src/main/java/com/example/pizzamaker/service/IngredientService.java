package com.example.pizzamaker.service;

import com.example.pizzamaker.model.Ingredient;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class IngredientService {

    private Map<String, List<Ingredient>> ingredientsPorCategoria;

    public IngredientService() {
        inicialitzarIngredients();
    }

    private void inicialitzarIngredients() {
        ingredientsPorCategoria = new LinkedHashMap<>();

        List<Ingredient> bases = Arrays.asList(
                new Ingredient("Clàssica", 3.0, "Base"),
                new Ingredient("Integral", 3.5, "Base"),
                new Ingredient("Sense Gluten", 4.0, "Base")
        );


        List<Ingredient> salses = Arrays.asList(
                new Ingredient("Tomàquet", 0.5, "Salsa"),
                new Ingredient("Pesto", 1.0, "Salsa"),
                new Ingredient("Barbacoa", 0.8, "Salsa")
        );

        List<Ingredient> formatges = Arrays.asList(
                new Ingredient("Mozzarella", 1.5, "Formatge"),
                new Ingredient("Cheddar", 1.8, "Formatge"),
                new Ingredient("Gorgonzola", 2.0, "Formatge")
        );

        List<Ingredient> proteines = Arrays.asList(
                new Ingredient("Pepperoni", 2.5, "Proteïna"),
                new Ingredient("Pollastre", 2.2, "Proteïna"),
                new Ingredient("Cuixot", 2.8, "Proteïna"),
                new Ingredient("Veganes", 2.0, "Proteïna")
        );

        List<Ingredient> vegetals = Arrays.asList(
                new Ingredient("Pebres", 0.8, "Vegetal"),
                new Ingredient("Ceba", 0.6, "Vegetal"),
                new Ingredient("Xampinyons", 1.2, "Vegetal"),
                new Ingredient("Olives", 0.9, "Vegetal")
        );

        List<Ingredient> extras = Arrays.asList(
                new Ingredient("Moraduix", 0.5, "Extra"),
                new Ingredient("All en pols", 0.3, "Extra"),
                new Ingredient("Pinyons", 1.5, "Extra")
        );

        ingredientsPorCategoria.put("Base", bases);
        ingredientsPorCategoria.put("Salsa", salses);
        ingredientsPorCategoria.put("Formatge", formatges);
        ingredientsPorCategoria.put("Proteïna", proteines);
        ingredientsPorCategoria.put("Vegetal", vegetals);
        ingredientsPorCategoria.put("Extra", extras);
    }

    //Obtener todos los ingredientes por categoría
    public Map<String, List<Ingredient>> getIngredientsPorCategoria() {
        return ingredientsPorCategoria;
    }

    public List<Ingredient> getAllIngredients() {
        List<Ingredient> todos = new ArrayList<>();
        ingredientsPorCategoria.values().forEach(todos::addAll);
        return todos;
    }

    // Buscar ingrediente por nombre
    public Ingredient getIngredientByNom(String nom) {
        return getAllIngredients().stream()
                .filter(i -> i.getNom().equals(nom))
                .findFirst()
                .orElse(null);
    }
}
