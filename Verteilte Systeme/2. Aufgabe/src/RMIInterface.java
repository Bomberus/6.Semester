import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Date;

public interface RMIInterface extends Remote{
    Date getDateAndTime() throws RemoteException;

    void addEvent(Event event) throws RemoteException;

    ArrayList<Event> getAllEvents() throws RemoteException;

    Event getNextEvent() throws RemoteException;

    ArrayList<Event> getFutureEvents() throws RemoteException;

    void addEventListener(RMIEventListener eventListener) throws RemoteException;

    void removeEventListener(RMIEventListener eventListener) throws RemoteException;

    void executeEventListeners(Event event) throws RemoteException;

}
