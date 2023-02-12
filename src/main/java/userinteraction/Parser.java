package userinteraction;

import command.*;

public class Parser {

    private static final Ui ui = new Ui();

    public static Command parse(String input) {
        if (input.equals("bye")) {
            ui.printLine();
            return new ExitCommand(input);
        } else if (input.equals("list")) {
            ui.printLine();
            return new ListCommand(input);
        } else if (input.startsWith("mark")) {
            ui.printLine();
            return new MarkTaskCommand(input, true);
        } else if (input.startsWith("unmark")) {
            ui.printLine();
            return new MarkTaskCommand(input, false);
        } else if (input.startsWith("todo")) {
            ui.printLine();
            return new AddTodoCommand(input);
        } else if (input.startsWith("deadline")) {
            ui.printLine();
            return new AddDeadlineCommand(input);
        } else if (input.startsWith("event")) {
            ui.printLine();
            return new AddEventCommand(input);
        } else if (input.startsWith("delete")) {
            ui.printLine();
            return new DeleteTaskCommand(input);
        } else {
            ui.printLine();
            System.out.println("\t ☹ OOPS!!! I'm sorry, but I don't know what that means.\n");
        }
        return null;
    }
}

    /**
    private enum CommandNames {
        LIST, MARK, UNMARK, TODO, DEADLINE, EVENT, DELETE, BYE
    }
    public static command.Command parse(String input) {
        //String[] inputArr = input.split(" ", 2);
        try {
            CommandNames commandNames = CommandNames.valueOf(inputArr[0].toUpperCase());
            switch (commandNames) {
                case LIST:
                    return new command.ListCommand(inputArr);
                case MARK:
                    return new command.MarkTaskCommand(inputArr, true);
                case UNMARK:
                    return new command.MarkTaskCommand(inputArr, false);
                case TODO:
                    return new command.AddTodoCommand(inputArr);
                case EVENT:
                    return new command.AddEventCommand(inputArr);
                case DEADLINE:
                    return new command.AddDeadlineCommand(inputArr);
                case DELETE:
                    return new command.DeleteTaskCommand(inputArr);
                case BYE:
                    return new command.ExitCommand(inputArr);
                default:
                    throw new dukeexception.DukeException("Unknown format");
            }
        } catch (dukeexception.DukeException e) {
            System.out.println(e.getMessage());
        } catch(NumberFormatException e) {
            System.out.println("Please provide numbers");
        } catch(IllegalArgumentException e) {
            System.out.println("Invalid command.Command");
        } catch (Exception e) {
            System.out.println("Unknown error");
        }
        return null;
    }
     **/
