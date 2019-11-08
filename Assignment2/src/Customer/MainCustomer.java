package Customer;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class MainCustomer {


    public static void main(String[] args) {
        try {
            CustomerClientImp cc = new CustomerClientImp();

            cc = new CustomerClientImp();
            while (true) {
                Thread.sleep(5000);
                System.out.println("--------");
                cc.getBurger();
            }
        }catch (NullPointerException e)
        {
            System.out.println("Sorry, Chef not here , no burger for you");
        }
        catch (RemoteException | NotBoundException | InterruptedException e) {
            e.printStackTrace();
        }


    }
}
