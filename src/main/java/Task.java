import java.util.Date;
import java.text.SimpleDateFormat;
import java.text.DateFormat;
import java.text.ParseException;

public class Task {
    protected String description;
    protected boolean isDone;
    protected char type;
    protected boolean changed;
    protected Date date;

    public Task(String description) {
        this.description = description;
        this.isDone = false;
    }

    public Task(String description, boolean isDone) {
        this.description = description;
        this.isDone = isDone;
    }

    public String getDescription() {
        return description;
    }

    public String getStatusIcon() {
        return (isDone ? "\u2713" : "\u2718");
    }

    public void markAsDone() {
        isDone = true;
    }

    public char getType() {
        return type;
    }

    public boolean getDoneStatus() {
        return isDone;
    }

    public String getDate() {
        DateFormat dayFormat = new SimpleDateFormat("d");
        int day = Integer.parseInt(dayFormat.format(date));
        String suffix = day == 1 ? "st" : (day == 2 ? "nd" : (day == 3 ? "rd" : "th"));
        String stringDate = (new SimpleDateFormat("EEEEE, ")).format(date) + (dayFormat.format(date)) + suffix + " of " + (new SimpleDateFormat("MMMMM yyyy, hh:mm aaa")).format(date);
        return stringDate;
    }

    public String getDateToSave() {
        DateFormat format = new SimpleDateFormat("dd/MM/yyyy HHmm");
        String stringDate = format.format(date);
        return stringDate;
    }

    @Override
    public String toString() {
        return "[" + getType() + "][" + getStatusIcon() + "] " + description;
    }

    public Date stringToDate(String stringDate) throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HHmm");
        Date dateValue = formatter.parse(stringDate);
        return dateValue;
    }
}