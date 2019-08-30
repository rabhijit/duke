import java.util.Date;
import java.text.SimpleDateFormat;
import java.text.DateFormat;
import java.text.ParseException;

public class Deadline extends Task {
    public Deadline(String description, String by) throws ParseException {
        super(description);
        this.date = stringToDate(by);
        this.type = 'D';
    }

    public Deadline(String description, String by, boolean isDone) throws ParseException {
        super(description, isDone);
        this.date = stringToDate(by);
        this.type = 'D';
    }

    @Override
    public String toString() {
        return super.toString() + " (by: " + getDate() + ")";
    }
}