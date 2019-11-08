package Chef;

public class MainChef {

    public static void main(String[] args) {
        try {
            ChefClientImp cci = new ChefClientImp();
            while (true) {
                cci.makeBurger();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
