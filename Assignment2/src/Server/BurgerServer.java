package Server;

import Chef.Burger;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface BurgerServer extends Remote {
    void addBurger(Burger burger)throws RemoteException;;
    void shutDown()throws RemoteException;;
    Burger retrieveBurger()throws RemoteException;;
    void removeBurger() throws RemoteException;
}
