import java.io.Serializable;
import java.util.Date;

public class Event implements Serializable, Comparable<Event>{
    private Date time;
    private String description;

    public Event(Date time, String description) {
        this.time = time;
        this.description = description;
    }

    public Date getDateTime() {
        return time;
    }

    public String getDescription(){
        return description;
    }

    @Override
    public String toString() {
        return this.time.toString() + " : " + this.description;
    }

    @Override
    public int compareTo(Event o) {
        return getDateTime().compareTo(o.getDateTime());
    }
}
