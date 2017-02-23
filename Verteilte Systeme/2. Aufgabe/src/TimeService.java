import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;

public class TimeService implements RMIInterface{

    private ArrayList<Event> events;
    private ArrayList<RMIEventListener> eventListeners;

    private Thread thread;
    private Runnable r;

    private TimeService() throws RemoteException{
        super();
        this.events = new ArrayList<>();
        this.eventListeners = new ArrayList<>();

        this.r = new EventThread(this);
        this.thread = new Thread(this.r);
        this.thread.start();
    }

    public static void main(String args[]) throws Exception {
        System.out.println("RMI server started");

        //Instantiate RmiServer
        TimeService obj = new TimeService();

        try { //special exception handler for registry creation

            RMIInterface stub = (RMIInterface) UnicastRemoteObject.exportObject(obj,0);
            Registry reg;
            try {
                reg = LocateRegistry.createRegistry(7575);
                System.out.println("java RMI registry created.");

            } catch(Exception e) {
                System.out.println("Using existing registry");
                reg = LocateRegistry.getRegistry();
            }
            reg.rebind("RMIServer", stub);

        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Date getDateAndTime() throws RemoteException {
        return new Date();
    }

    @Override
    public void addEvent(Event event){
        this.thread.interrupt();
        this.events.add(event);
        Collections.sort(events);
        System.out.println("Got Event : "+ event.getDescription());
    }

    @Override
    public ArrayList<Event> getAllEvents(){
        return this.events;
    }

    @Override
    public Event getNextEvent(){
        Date now = new Date();
        for(int i = 0; i < this.events.size(); i++) {
            Event event = this.events.get(i);
            if (event.getDateTime().after(now)) {
                return event;
            }
        }
        return null;
    }

    @Override
    public ArrayList<Event> getFutureEvents(){
        Date now = new Date();
        ArrayList<Event> futureEvents = new ArrayList<>();

        for(int i = 0; i < this.events.size(); i++) {
            Event event = this.events.get(i);
            if (event.getDateTime().after(now)){
                futureEvents.add(event);
            }
        }

        return futureEvents;
    }

    @Override
    public void addEventListener(RMIEventListener eventListener){
        this.eventListeners.add(eventListener);
    }

    @Override
    public void removeEventListener(RMIEventListener eventListener){
        this.eventListeners.remove(eventListener);
    }

    @Override
    public void executeEventListeners(Event event){
        for (RMIEventListener listener: this.eventListeners) {
            try {
                listener.handleEvent(event);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }
}
