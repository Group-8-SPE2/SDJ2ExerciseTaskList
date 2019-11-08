package chef;

public class ProxyTest {

   public static void main(String[] args) throws Exception {
      ProxyReader pr = new ProxyReader("recipes.txt");
      try {
         System.out.println(pr.getRecipeById("1"));
         System.out.println(pr.getRecipeById("2"));
         System.out.println(pr.getRecipeById("2"));
         System.out.println(pr.getRecipeById("3"));
      }
      catch (Exception e){
         System.out.println("System failed horribly.");
         
      }
      
      try {
         Recipe c = pr.getRecipeById("3");
         Recipe b = pr.getRecipeById("2");
         Recipe a = pr.getRecipeById("1");
         
         Burger bC = c.createBurger();
         Burger bB = b.createBurger();
         Burger bA = a.createBurger();
         
         System.out.println(bC);
         System.out.println(bB);
         System.out.println(bA);
         
      }
      catch (Exception e){
         System.out.println("System failed horribly.");
         
      }
      
      try {
         System.out.println(pr.getRecipeByName("Hamburger"));
         System.out.println(pr.getRecipeByName("Cheese burger"));
         System.out.println(pr.getRecipeByName("Veggie burger"));
         System.out.println(pr.getRecipeByName("Veggie burger"));
      }
      catch (Exception e){
         System.out.println("System failed horribly.");
         
      }
   }

}
