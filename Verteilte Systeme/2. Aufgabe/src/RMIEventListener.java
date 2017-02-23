import java.rmi.Remote;
import java.rmi.RemoteException;

public interface RMIEventListener extends Remote {
    void handleEvent(Event event) throws RemoteException;


}
