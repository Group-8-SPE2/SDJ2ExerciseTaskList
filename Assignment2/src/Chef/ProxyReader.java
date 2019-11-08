package chef;

public class ProxyReader implements RecipeProvider {
   
   private RecipeReader rr;
   private Recipe currentRecipe;
   
   public ProxyReader(String filename) {
      this.rr = new RecipeReader(filename);
   }
   
   /**
    * Loads a recipe from file with a given ID, if there's a recipe with the same
    * ID in the cache, the recipe is retrieved from the cache instead
    */
   @Override
   public synchronized Recipe getRecipeById(String id) throws Exception {
      if(currentRecipe != null) {
         if(currentRecipe.getId().equals(id)) {
            //This line is for testing purposes only
            //System.out.println("Retrieving the recipe from the cache...");
            return currentRecipe;
         }
      }
      currentRecipe = rr.getRecipeById(id);
      return currentRecipe;
   }
   
   /**
    * Loads a recipe from file with a given name, if there's a recipe with the same
    * name in the cache, the recipe is retrieved from the cache instead
    */
   @Override
   public synchronized Recipe getRecipeByName(String name) throws Exception {
      if(currentRecipe != null) {
         if(currentRecipe.getName().equals(name)) {
            //This line is for testing purposes only
            //System.out.println("Retrieving the recipe from the cache...");
            return currentRecipe;
         }
      }
      currentRecipe = rr.getRecipeByName(name);
      return currentRecipe;
   }

   @Override
   public synchronized void updateRecipe(Recipe recipe) throws Exception {
     rr.updateRecipe(recipe); 
   }
}