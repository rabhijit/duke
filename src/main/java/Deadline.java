public class Deadline extends Task {
    public Deadline(String description, String by) {
        super(description);
        this.date = by;
        this.type = 'D';
    }

    public Deadline(String description, String by, boolean isDone) {
        super(description, isDone);
        this.date = by;
        this.type = 'D';
    }

    @Override
    public String toString() {
        return super.toString() + " (by: " + date + ")";
    }
}