package command;

import dukeexception.DukeException;
import storage.Storage;
import storage.TaskList;
import userinteraction.Ui;

/**
 * Command class for listing tasks.
 */
public class HelpCommand extends Command {

    /**
     * Class constructor.
     *
     * @param input String from a user input.
     */
    public HelpCommand(String input) {
        super(input);
    }

    /**
     * Lists all available commands.
     *
     * @param taskList Stores all tasks.
     * @param ui       The Ui to be used for printing messages.
     * @param storage  Saves all tasks in a file
     * @throws DukeException Checks the validation of input.
     */
    @Override
    public String process(TaskList taskList, Ui ui, Storage storage) throws DukeException {
        return ui.printHelpMsg(storage);
    }

    @Override
    public boolean isExit() {
        return false;
    }
}