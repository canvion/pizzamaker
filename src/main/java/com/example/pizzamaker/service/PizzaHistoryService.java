package com.example.pizzamaker.service;

import com.example.pizzamaker.model.Pizza;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PizzaHistoryService {

    private List<Pizza> historial = new ArrayList<>();
    private static final int MAX_HISTORIAL = 5;

    // Agregar pizza al historial
    public void afegirPizza(Pizza pizza) {
        historial.add(0, pizza); // Agregar al inicio

        if (historial.size() > MAX_HISTORIAL) {
            historial.remove(historial.size() - 1);
        }
    }

    // Obtener historial
    public List<Pizza> getHistorial() {
        return new ArrayList<>(historial);
    }

    // Limpiar historial
    public void clearHistorial() {
        historial.clear();
    }
}
