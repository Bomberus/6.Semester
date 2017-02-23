import java.util.Date;

public class EventThread implements Runnable{
    private TimeService timeService;
    private boolean running = false;

    public EventThread(TimeService timeService){
        this.timeService = timeService;
    }

    public void stopThread(){
        this.running = false;
    }

    @Override
    public void run() {
        this.running = true;
        while (running) {
            Event nextEvent = this.timeService.getNextEvent();
                //Event nextEvent = new Event(new Date((new Date()).getTime()+ 1000), "Hallo du");
            if (nextEvent != null){
                Date now = new Date();
                try {
                    Thread.sleep((nextEvent.getDateTime().getTime() - now.getTime()));
                } catch (InterruptedException e) {
                    this.running  = false;
                    System.out.println("Thread unterbrochen, passe mich den neuen Gegebenheiten an...");
                }
                System.out.println("Sending : "+nextEvent.getDescription());
                this.timeService.executeEventListeners(nextEvent);
            }

        }
    }
}
