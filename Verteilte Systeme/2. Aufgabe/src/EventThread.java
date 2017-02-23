import java.util.Date;

public class EventThread implements Runnable{
    private TimeService timeService;

    public EventThread(TimeService timeService){
        this.timeService = timeService;
    }

    @Override
    public void run() {
        while (true) {
            Event nextEvent = this.timeService.getNextEvent();
            Date now = new Date();
            try {
                if (nextEvent != null) {
                    Thread.sleep((nextEvent.getDateTime().getTime() - now.getTime()));
                    System.out.println("Sending : " + nextEvent.getDescription());
                    this.timeService.executeEventListeners(nextEvent);
                }
                else{
                    Thread.sleep(Long.MAX_VALUE);
                }
            } catch (InterruptedException e) {
                System.out.println("Thread unterbrochen, passe mich den neuen Gegebenheiten an...");
            }
        }
    }
}
