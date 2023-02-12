package command;

import dukeexception.DukeException;
import storage.Storage;
import storage.TaskList;
import userinteraction.Ui;

abstract class AddTaskCommand extends Command {

    public AddTaskCommand(String inputArr) {
        super(inputArr);
    }

    @Override
    public void process(TaskList taskList, Ui ui, Storage storage) throws DukeException {

    }

    @Override
    public boolean isExit() {
        return false;
    }
}