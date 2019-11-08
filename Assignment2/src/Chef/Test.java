package Chef;

import java.util.Random;

public class Test {

    public String a  ;


    public static void main(String[] args) {
        RecipeProvider recipeProvider = new RecipeReader("C:\\Users\\Chan\\Documents\\GitHub\\SDJ2\\Assignment2\\recipes.txt") ;
        try {
            String b=recipeProvider.getRecipeById("2").createBurger().getName();
            System.out.println(b);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Random r = new Random();
        int n = r.nextInt(3);
        System.out.println(n);

    }
}
