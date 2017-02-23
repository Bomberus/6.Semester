import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Date;

public class ClientModel extends UnicastRemoteObject implements RMIEventListener, Runnable{
    private RMIInterface server;
    private ArrayList<Event> loggedEvents = new ArrayList<>();
    private Date serverTime;
    private boolean running = false;
    private Thread clockThread;
    private UIListener listener;

    protected ClientModel(String host, Integer port, UIListener listener) throws Exception{
        connect(host,port);
        this.listener = listener;
    }

    public ArrayList<Event> getLoggedEvents() {
        return loggedEvents;
    }

    public Date getServerTime() {
        return serverTime;
    }

    public void connect(String host, Integer port) throws Exception{
        System.out.println("Client starting");

        // Now, find the server, and register with it
        System.out.println("Finding server");

        Registry registry = LocateRegistry.getRegistry(host,port);
        this.server = (RMIInterface) registry.lookup("RMIServer");

        // This should cause the server to call us back.
        System.out.println("Connecting to server");
        this.server.addEventListener(this);

        System.out.println("Client program ready.");

        System.out.println("Starting Clock Service");

        this.running = true;
        //this.loggedEvents.add(new Event(new Date(), "Test"));
        //this.listener.retrieveEvents();
        this.clockThread = new Thread(this);
        this.clockThread.start();
    }

    public void close() throws Exception{
        this.running = false;
        System.out.println("Stopp Clockservice");

        System.out.println("Waiting for clock Thread to stop...");
        while(this.clockThread.isAlive()){
            Thread.sleep(100);
        }
        System.out.println("Closing connection");
        server.removeEventListener(this);
        System.out.println("Yippie Yah Yei Schweinebacke!");
    }

    public void addEvent(Event event) throws Exception{
        server.addEvent(event);
    }

    public ArrayList<Event> getFutureEvents() throws Exception{
        return server.getFutureEvents();
    }

    @Override
    public void handleEvent(Event event) throws RemoteException {
        this.loggedEvents.add(event);
        try {
            listener.retrieveEvents();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        while (this.running){
            try {
                this.serverTime = this.server.getDateAndTime();
                this.listener.shouldRefreshUI();
                Thread.sleep(2000);

            } catch (Exception e) {
                System.out.println("Couldn't retrieve time");
            }
        }
    }
}
