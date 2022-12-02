import java.math.BigDecimal

enum class PizzaPrice(val price: BigDecimal) {
    Margherita(BigDecimal("2")),
    Cheese(BigDecimal("2.5")),
    Salami(BigDecimal("3"));

    companion object {
        fun getPrice(pizzaType: String): BigDecimal {
            return values().first { it.name == pizzaType }.price
        }
    }
}

enum class IngredientPrice(val price: BigDecimal) {
    Cheese(BigDecimal("0.15")),
    Salami(BigDecimal("0.25")),
    Pepper(BigDecimal("0.1")),
    Mushrooms(BigDecimal("0.2")),
    Vegetables(BigDecimal("0.2")),
    Olives(BigDecimal("0.25"));

    companion object {
        fun getPrice(ingredientName: String): BigDecimal {
            return values().first { it.name == ingredientName }.price
        }
    }
}
