import java.util.Date;
import java.text.SimpleDateFormat;
import java.text.DateFormat;
import java.text.ParseException;

public class Event extends Task {
    public Event(String description, String at) throws ParseException {
        super(description);
        this.date = stringToDate(at);
        this.type = 'E';
    }

    public Event(String description, String at, boolean isDone) throws ParseException {
        super(description, isDone);
        this.date = stringToDate(at);
        this.type = 'E';
    }

    @Override
    public String toString() {
        return super.toString() + " (at: " + getDate() + ")";
    }
}