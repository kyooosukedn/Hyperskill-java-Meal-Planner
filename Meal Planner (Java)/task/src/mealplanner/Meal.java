package mealplanner;

public class Meal {
    String category;
    String name;
    String[] ingredients;
    public Meal(String category, String name, String[] ingredients) {
        this.category = category;
        this.name = name;
        this.ingredients = ingredients;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String[] getIngredients() {
        return ingredients;
    }

    public void setIngredients(String[] ingredients) {
        this.ingredients = ingredients;
    }
}
