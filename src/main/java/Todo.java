public class Todo extends Task {
    public Todo(String description) {
        super(description);
        this.type = 'T';
    }

    public Todo(String description, boolean isDone) {
        super(description, isDone);
        this.type = 'T';
    }
}