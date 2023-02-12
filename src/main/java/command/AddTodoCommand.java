package command;

import dukeexception.DukeException;
import storage.Storage;
import storage.TaskList;
import task.Todo;
import userinteraction.Ui;

public class AddTodoCommand extends AddTaskCommand {
    public AddTodoCommand(String inputArr) {
        super(inputArr);
    }

    @Override
    public void process(TaskList taskList, Ui ui, Storage storage) throws DukeException {
        Todo todo = Todo.generate(this.getInputArr());
        taskList.addTask(todo);
        storage.saveData(taskList);
        ui.printAddTaskMsg(taskList, todo);
    }
}