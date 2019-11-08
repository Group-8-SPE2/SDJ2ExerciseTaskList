package Server;

import collection.BlockingQueue;
import collection.BlockingQueueImp;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Queue;

public class MainServer {


    public static void main(String[] args) {
        try {

            BurgerServer server = new BurgerServerImp();
            Registry registry = LocateRegistry.createRegistry(1090);
            registry.bind("BurgerServer", server);
            System.out.println("Server started");
            //-----
            while (true) {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println(((BurgerServerImp) server).qSize()+ "  Burgers left");

            }
            //------------------
        } catch (RemoteException | AlreadyBoundException e) {
            e.printStackTrace();
        }
    }

}
