import java.util.Arrays;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Scanner;


/**
 *
 * @author Bunyawat Naunnak
 */

public class Intersection {
    public static void main(String... args) throws Exception {

        /**
         * This is the main method
         * which is very important for
         * execution for a java program.
         */

        List <String> ingredients = new ArrayList<String>();
        String input;
        System.out.print("Input ingredients : ");
        Scanner scanner = new Scanner(System.in);
        input = scanner.nextLine();
        if(!input.equals("q")) {
            ingredients.add(input);
            System.out.println("Ingredients :"+ingredients);
        }
        while(!(input.equals("q"))){
            System.out.print("Input ingredients : ");
            input = scanner.nextLine();
            if(!input.equals("q")) {
                ingredients.add(input);
            }
        }

        System.out.println(ingredients);

        Food tomyumkung = new Food("TomYumKung");
        tomyumkung.setMenuCalories(20.5f);
        tomyumkung.setIngredients(new ArrayList<String>(Arrays.asList(
                new String [] {"กุ้ง", "พริก", "มะนาว", "สมุนไพร"})));


        Food kfc = new Food("KFC");
        kfc.setMenuCalories(12.5f);
        kfc.setIngredients(new ArrayList<String>(Arrays.asList(
                new String [] {"ไก่", "พริก", "แป้ง"})));

        Food ramen = new Food("Ramen");
        ramen.setMenuCalories(25.0f);
        ramen.setIngredients(new ArrayList<String>(Arrays.asList(
                new String [] {"ไก่", "พริก", "แป้ง", "สมุนไพร"})));

        Food massaman = new Food("Massaman");
        massaman.setMenuCalories(45.6f);
        massaman.setIngredients(new ArrayList<String>(Arrays.asList(
                new String [] {"ไก่", "พริก", "สมุนไพร"})));

        final List <Food> FOOD_LISTS = new ArrayList<Food>(Arrays.asList(
                new Food [] {ramen, kfc, tomyumkung, massaman}));

        List<Food> result = new Intersection().searchFood(ingredients, FOOD_LISTS);
        List<Food> food = new Intersection().getAllFood(FOOD_LISTS, "ไก่");
        for(int i = 0; i < food.size(); i++){
            System.out.println("Food : "+food.get(i).getMenuName());
        }
        System.out.print("Cal ? : ");
        input = scanner.nextLine();
        if(!input.equals("n")){
            float cals = Float.parseFloat(input);
            System.out.println("Cals is : "+cals);
            List<Food> output_food = new ArrayList<Food>();
            for(int i = 0; i < result.size(); i++){
                if(cals == result.get(i).getMenuCalories()){
                    System.out.println(result.get(i).getMenuCalories());
                    output_food.add(result.get(i));
                }
            }
            System.out.println("Result is : "+output_food.get(0).getMenuName());
        }
    }

    /**
     * This is the union method
     */
    public <T> List<T> union(List<T> list1, List<T> list2) {
        Set<T> set = new HashSet<T>();

        set.addAll(list1);
        set.addAll(list2);

        return new ArrayList<T>(set);
    }

    public List<Food> getAllFood(List<Food> foodlist, String ingredient) {
        List<Food> result = new ArrayList<Food>();

        for (int i = 0; i < foodlist.size(); i++ ) {
            for (int j = 0; j < foodlist.get(i).getIngredients().size(); j++) {
                if(ingredient == foodlist.get(i).getIngredients().get(j)) {
                    result.add(foodlist.get(i));
                }
            }
        }

        return result;
    }

    public List<List<Food>> intersection_food(List<String> ingredients , List<Food> foodlist) {
        List<List<Food>> all_list = new ArrayList<List<Food>>();
        List<List<Food>> output;
        for (int i = 0; i < ingredients.size(); i++) {
            List<Food> food = getAllFood(foodlist, ingredients.get(i));
            all_list.add(food);
        }
        output = intersection_loop(all_list);
        return output;
    }


    public <T> List<T> intersection(List<T> list1, List<T> list2) {
        List<T> list = new ArrayList<T>();

        for (T t : list1) {
            if(list2.contains(t)) {
                list.add(t);
            }
        }
        return list;
    }

    public List<List<Food>> intersection_loop(List<List<Food>> all_list){
        List<List<Food>> output = new ArrayList<List<Food>>();
        for (int i = 0; i < all_list.size(); i++) {
            if(i != all_list.size() - 1) {
                List<Food> list_a = all_list.get(i);
                List<Food> list_b = all_list.get(i+1);
                output.add(intersection(list_a, list_b));
            }
        }

        if(output.size() != 1) {
            output = intersection_loop(output);
        }

        return output;
    }

    public List<Food> searchFood(List<String> ingredients, List<Food> foodlist){
        List<Food> output = new ArrayList<Food>();
        for(int i = 0; i < foodlist.size(); i++) {
            if(ingredients.equals(foodlist.get(i).getIngredients()) == true) {
                output.add(foodlist.get(i));
            }
        }
        return output;
    }

    public List<List<Food>> searchFood2(List<String> ingredients, List<Food> foodList){
        List<List<Food>> output = new ArrayList<List<Food>>();
        for(int i = 0; i < ingredients.size(); i++){
            List<Food> food = getAllFood(foodList, ingredients.get(i));
            output.add(food);
        }
        return output;
    }

}

