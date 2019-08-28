public class Task {
    protected String description;
    protected boolean isDone;
    protected char type;
    protected boolean changed;
    protected String date;

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
        return date;
    }

    @Override
    public String toString() {
        return "[" + getType() + "][" + getStatusIcon() + "] " + description;
    }
}