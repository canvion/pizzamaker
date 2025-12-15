package com.example.pizzamaker.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PizzaController {

    @GetMapping("/")
    public String showForm() {
        return "pizza";
    }

    @PostMapping("/create-pizza")
    public String createPizza(
            @RequestParam String size,
            @RequestParam String dough,
            @RequestParam(required = false) String[] ingredients,
            Model model) {

        model.addAttribute("pizzaCreated", true);
        model.addAttribute("size", size);
        model.addAttribute("dough", dough);

        String ingredientsList = (ingredients != null)
                ? String.join(", ", ingredients)
                : "Sense ingredients";
        model.addAttribute("ingredientsList", ingredientsList);

        return "pizza";
    }
}
