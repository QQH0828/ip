package task;

public abstract class Task {

    private final String description;

    private boolean isDone;

    public Task(String description, boolean isDone) {
        this.description = description;
        this.isDone = isDone;
    }

    public boolean isDone() {
        return isDone;
    }
    public String getMarkedString() {
        return isDone ? "1" : "0";
    }

    public String getDescription() {
        return description;
    }

    public void setDone(boolean done) {
        this.isDone = done;
    }

    public abstract String storeTaskString();
    public abstract String getTaskType();
}