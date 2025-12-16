# Pizza Maker - Spring Boot

Proyecto de ejemplo desarrollado con Spring Boot y Thymeleaf para la asignatura DWES. La aplicación permite diseñar pizzas personalizadas de forma visual e interactiva.

## Funcionalidades

- Selector de ingredientes organizados por categorías:
    - Bases: Clàssica, Integral, Sense Gluten
    - Salses: Tomàquet, Pesto, Barbacoa
    - Formatges: Mozzarella, Cheddar, Gorgonzola
    - Proteïnes: Pepperoni, Pollastre, Cuixot, Veganes
    - Vegetals: Pebres, Ceba, Xampinyons, Olives
    - Extras: Moraduix, All en pols, Pinyons
- Cálculo automático del precio total según los ingredientes seleccionados
- Aplicación de un 10% de descuento si el preu total supera 12€
- Cálculo del temps de preparació:
    - Base de 5 minuts
    - +1 minut per ingredient afegit
- Generación de un ID de comanda único con formato `PIZZA-YYYYMMDD-HHMMSS`
- Historial de las últimas 5 pizzes creades en memòria

## Estructura principal

- `controller/`
    - `PizzaController` con las rutas:
        - `GET /` formulario inicial
        - `POST /create` creación de la pizza y rebut
        - `GET /history` historial recent
- `model/`
    - `Ingredient` (nom, preu, categoria)
    - `Pizza` (id, llista d’ingredients, preuTotal, tempsPrep)
- `service/`
    - `IngredientService` inicializa y gestiona los ingredients disponibles
    - `PizzaHistoryService` gestiona l’historial de pizzes
- `templates/`
    - `index.html` selector d’ingredients i vista prèvia bàsica
    - `receipt.html` rebut detallat de la pizza
    - `history.html` mini-historial de pizzes
- `static/css/`
    - `style.css` amb l’estil blau i blanc de l’aplicació

## Tecnologies utilitzades

- Java
- Spring Boot (Web, Thymeleaf, DevTools)
- Maven
- Thymeleaf
- HTML5 i CSS3

## Com executar el projecte

1. Clonar el repositori:
    - `git clone https://github.com/USUARIO/pizzamaker.git`
2. Obrir el projecte amb IntelliJ IDEA.
3. Assegurar-se que Maven descarrega totes les dependències.
4. Executar la classe `PizzamakerApplication`.
5. Obrir el navegador a:
    - `http://localhost:8080`
