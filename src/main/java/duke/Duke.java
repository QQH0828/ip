package duke;

import command.Command;
import dukeexception.DukeException;
import storage.Storage;
import storage.TaskList;
import userinteraction.Parser;
import userinteraction.Ui;

public class Duke {
    private final static String FILE_PATH = ".\\src\\data\\duke.txt";

    private final Ui ui;
    private final Storage storage;
    private final TaskList taskList;
    public Duke() {
        ui = new Ui();
        storage = new Storage(FILE_PATH);
        taskList = storage.readData();
    }

    public void run() {
        ui.printWelcomeMsg();
        ui.printLine();
        boolean isBye = false;
        while (!isBye) {
            try {
                String input = ui.readCommand();
                Command command = Parser.parse(input);
                if (command != null) {
                    command.process(taskList, ui, storage);
                    isBye = command.isExit();
                }
            } catch (DukeException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public Ui getUi() {
        return ui;
    }

    public static void main(String[] args) {
        Duke duke = new Duke();
        duke.run();
    }

}
