public class AddDeadlineCommand extends AddTaskCommand{
    public AddDeadlineCommand(String inputArr) {
        super(inputArr);
    }

    @Override
    public void process(TaskList taskList, Ui ui, Storage storage) throws DukeException {
        Deadline deadline = Deadline.generate(this.getInputArr());
        taskList.addTask(deadline);
        storage.saveData(taskList);
        ui.printAddTaskMsg(taskList, deadline);
    }
}
