import java.util.*;

public class Food {
    private String menuName;
    private float menuCalories;
    private List<String> ingredients = new ArrayList<String>();

    public Food(String menuName) {
        this.menuName = menuName;
    }

    public Food(String menuName, List<String> ingrediants) {
        this.menuName = menuName;
        this.ingredients = ingrediants;
    }


    public Food(String menuName, List<String> ingrediants, float menuCalories) {
        this.menuName = menuName;
        this.ingredients = ingrediants;
        this.menuCalories = menuCalories;
    }


    public void addIngredient(String ingrediant) {
        this.ingredients.add(ingrediant);
    }


    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    public String getMenuName() {
        return menuName;
    }

    public void setIngredients(List<String> ingredients) {
        this.ingredients = ingredients;
    }

    public List<String> getIngredients(){
        return ingredients;
    }

    public void setMenuCalories(float menuCalories) {
        this.menuCalories = menuCalories;
    }

    public float getMenuCalories() {
        return this.menuCalories;
    }
}
