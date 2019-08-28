public class Task {
    protected String description;
    protected boolean isDone;
    protected char type;

    public Task(String description) {
        this.description = description;
        this.isDone = false;
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

    @Override
    public String toString() {
        return "[" + getType() + "][" + getStatusIcon() + "] " + description;
    }
}