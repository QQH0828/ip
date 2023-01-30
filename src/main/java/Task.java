public class Task {
    protected String description;
    protected boolean isDone;

    public Task(String description) {
        this.description = description;
        this.isDone = false;
    }

    public String getStatusIcon() {
        return (isDone ? "X" : " ");
    }

    public void mark() {
        this.isDone = true;
        System.out.println("\t Nice! I've marked this task as done:\n"
                + "\t\t [X] " + this.description);
    }

    public void unmark() {
        this.isDone = false;
        System.out.println("\t OK, I've marked this task as not done yet:\n"
                + "\t\t [ ] " + this.description);
    }

    public void showTask() {
        System.out.println(" [" + getStatusIcon() + "] " + this.description);
    }
}
