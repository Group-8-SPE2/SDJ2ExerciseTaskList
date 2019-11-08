package Server;

import Chef.Burger;
import collection.BlockingQueue;
import collection.BlockingQueueImp;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class BurgerServerImp implements BurgerServer {

    private BlockingQueue queue;

    public BurgerServerImp() throws RemoteException {
        UnicastRemoteObject.exportObject(this, 0);
        queue = new BlockingQueueImp();
    }

    @Override
    public void addBurger(Burger burger) {
        queue.enqueue(burger);
    }

    @Override
    public void shutDown() {
        //TODO: just test
        System.out.println("hello");
    }

    @Override
    public Burger retrieveBurger() {
        Burger burger;
        if (!queue.isEmpty()) {
            while (true) {
                burger = queue.first();
                System.out.println("a costumer take a "  +  queue.first().getName());
                return burger;
            }
        } else
            System.out.println("Queue is empty");
            return null;

    }

    @Override
    public void removeBurger() throws RemoteException {
        if (!queue.isEmpty()) {
            queue.dequeue();
        }
    }

    public int qSize(){
        return queue.size();
    }
}
