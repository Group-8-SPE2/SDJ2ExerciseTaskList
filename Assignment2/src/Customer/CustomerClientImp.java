package Customer;

import Server.BurgerServer;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class CustomerClientImp implements CustomerClient {

    private BurgerServer server;

    public CustomerClientImp() throws RemoteException, NotBoundException {
        UnicastRemoteObject.exportObject(this, 0);
        Registry registry = LocateRegistry.getRegistry("localhost", 1090);
        server = (BurgerServer) registry.lookup("BurgerServer");
    }

    public void getBurger() throws RemoteException {
//        server.retrieveBurger();
        System.out.println("take a "+server.retrieveBurger().getName());
        server.removeBurger();
    }
}
