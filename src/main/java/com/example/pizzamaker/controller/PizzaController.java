package com.example.pizzamaker.controller;

import com.example.pizzamaker.model.Ingredient;
import com.example.pizzamaker.model.Pizza;
import com.example.pizzamaker.service.IngredientService;
import com.example.pizzamaker.service.PizzaHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class PizzaController {

    @Autowired
    private IngredientService ingredientService;

    @Autowired
    private PizzaHistoryService historyService;

    // Formulario inicial con selector de ingredientes
    @GetMapping("/")
    public String showForm(Model model) {
        model.addAttribute("ingredientsPorCategoria",
                ingredientService.getIngredientsPorCategoria());
        return "index";
    }

    //Procesar ingredientes y crear pizza
    @PostMapping("/create")
    public String createPizza(
            @RequestParam(required = false) List<String> ingredients,
            Model model) {

        // Crear nueva pizza
        Pizza pizza = new Pizza();

        // Agregar ingredientes seleccionados
        if (ingredients != null && !ingredients.isEmpty()) {
            for (String nomIngredient : ingredients) {
                Ingredient ingredient = ingredientService.getIngredientByNom(nomIngredient);
                if (ingredient != null) {
                    pizza.afegirIngredient(ingredient);
                }
            }
        }

        // Calcular precio y tiempo
        pizza.calcularPreuTotal();
        pizza.calcularTempsPrep();

        // Guardar en historial
        historyService.afegirPizza(pizza);

        // Pasar datos a la vista
        model.addAttribute("pizza", pizza);

        return "receipt";
    }

    // Mostrar historial de pizzas
    @GetMapping("/history")
    public String showHistory(Model model) {
        model.addAttribute("historial", historyService.getHistorial());
        return "history";
    }
}
