public class Event extends Task {
    public Event(String description, String at) {
        super(description);
        this.date = at;
        this.type = 'E';
    }

    public Event(String description, String at, boolean isDone) {
        super(description, isDone);
        this.date = at;
        this.type = 'E';
    }

    @Override
    public String toString() {
        return super.toString() + " (at: " + date + ")";
    }
}