package Chef;

import Server.BurgerServer;

import java.rmi.NotBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.Random;

public class ChefClientImp implements ChefClient {

    private BurgerServer server;
    private RecipeProvider recipe;

    public ChefClientImp() throws RemoteException, NotBoundException {

            UnicastRemoteObject.exportObject(this, 0);
            Registry registry = LocateRegistry.getRegistry("localhost", 1090);
            server = (BurgerServer) registry.lookup("BurgerServer");

        //TODO: is my workspace (Cause ERROR HERE)
        recipe = new RecipeReader("C:\\Users\\Chan\\Documents\\GitHub\\SDJ2\\Assignment2\\recipes.txt");


    }


    public void makeBurger() throws Exception {
        Random r = new Random();
        int n = r.nextInt(3) + 1;
        String id = String.valueOf(n);


        String name = recipe.getRecipeById(id).getName();
        System.out.println("Create a "+ name );
        Burger burger = new Burger(name);
        System.out.println("Working Cooking Creating.....");
        server.addBurger(burger);
        Thread.sleep(1000);
        System.out.println("  --------  ");
        Thread.sleep(1000);
        System.out.println("------------");
        Thread.sleep(1000);
        System.out.println("------------");
        Thread.sleep(1000);
        System.out.println("  --------  ");
        Thread.sleep(1000);
        System.out.println(burger.getName() +" created successfully! ");
    }



//    @Override
//    public void receiveMessage(String msg) {
//
//    }
}
