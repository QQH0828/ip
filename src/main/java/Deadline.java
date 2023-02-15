public class Deadline extends Task {
    private String dateTime;
    private Deadline(String description, boolean isDone, String dateTime) {
        super(description, isDone);
        this.dateTime = dateTime;
    }
    public static Deadline generate(String input) throws DukeException {
        if (input.trim().equals("deadline")) {
            throw new DukeException("\t ☹ OOPS!!! The description of a deadline cannot be empty.\n");
        }
        String[] inputLine = input.split(" ", 2);
        if (inputLine.length < 2) {
            throw new DukeException("\t ☹ OOPS!!! The description of a deadline cannot be empty.\n");
        }
        String[] descriptions = inputLine[1].split(" /by ", 2);
        if (descriptions.length < 2) {
            throw new DukeException("\t ☹ OOPS!!! The date time of a deadline cannot be empty.\n");
        }
        return new Deadline(descriptions[0], false, DateTime.dateFormatter(descriptions[1]));
    }
    public static Deadline generateTask(String[] taskLine) {
        boolean check = taskLine[1].equals("1");
        return new Deadline(taskLine[2], check, taskLine[3]);
    }
    public String getDateTime() {
        return dateTime;
    }
    @Override
    public String getTaskType() {
        return "D";
    }
    @Override
    public String storeTaskString() {
        return this.getTaskType() + " | " + this.getMarkedString() + " | " + this.getDescription() + " | " + this.getDateTime();
    }
    @Override
    public String toString() {
        String str = this.getDescription();
        boolean checked = this.isDone();
        String dateTime = this.getDateTime();
        if (checked) {
            return "[D][X] " + str + " (by: " + dateTime + ")";
        } else {
            return "[D][ ] " + str + " (by: " + dateTime + ")";
        }
    }
}