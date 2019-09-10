import java.util.*;
import java.io.*;
import java.text.*;

/**
 * This class continuously takes in a parsed input from the parser, and executes an action
 * based on what the parsed input is. Stops taking in input when 'bye' is entered
 * as an input.
 */

public class Ai {
    protected String command;
    protected int exitCode;

    /**
     * Constructor for Ai that sets the exit code to 0, allowing the class
     * to repeatedly take in input
     */
    public Ai() {
        exitCode = 0;
    }

    /**
     * Returns the exit code. Is called in the Duke class.
     * @return exitCode the exit code for the Ai class
     */
    public int getExitCode() {
        return exitCode;
    }

    /**
     * This function takes in a parsed array of commands from the parser, and depending on
     * what the array of commands are, executes the necessary functions for Duke.
     * @param commands the parsed array of commands in String form, as parsed by the parser.
     * @param ui takes in an instance of the Ui class to print output to the CLI if needed.
     * @param storage takes in an instance of the Storage class to save Task data if Duke is closed.
     * @param tasks takes in the TaskList containing the Tasks to search for and save tasks if required.
     * @throws ParseException if any input is un-parsable
     * @throws IOException if there is an error in reading input or printing output
     * @throws DukeException if the input has no meaning or does not follow our format
     */
    public void execute(ArrayList<String> commands, Ui ui, Storage storage, TaskList tasks) throws ParseException, IOException, DukeException {
        command = commands.get(0);
        if (command.equals("close")) {
            storage.saveToFile(tasks.getAllItems());
            ui.farewell();
            exitCode = 1;
        }
        else if (command.equals("list")) {
            ui.printTaskArray("Here are the tasks in your list", tasks.generateList());
        }
        else if (command.equals("done")) {
            int taskNo = Integer.parseInt(commands.get(1)) - 1;
            if (taskNo + 1 > tasks.getNumberOfItems()) {
                throw new DukeException("We don't have that many tasks!");
            }
            tasks.markItemAsDone(taskNo);
            ui.printTask("Nice! I've marked this task as done:", tasks.getItemToPrint(taskNo));
        }
        else if (command.equals("delete")) {
            int taskNo = Integer.parseInt(commands.get(1)) - 1;
            if (taskNo + 1 > tasks.getNumberOfItems()) {
                throw new DukeException("We don't have that many tasks!");
            }
            Task thisTask = tasks.getItem(taskNo);
            tasks.deleteItem(taskNo);
            ui.printRemovedTask(thisTask.toString(), tasks.getNumberOfItems());
        }
        else if (command.equals("find")) {
            ui.printTaskArray("Here are the matching tasks in your list:", tasks.searchItems(commands.get(1)));
        }
        else if (command.equals("todo")) {
            Todo newTodo = new Todo(commands.get(1));
            tasks.addItem(newTodo);
            ui.printAddedTask(newTodo.toString(), tasks.getNumberOfItems());
        }
        else if (command.equals("deadline")) {
            Deadline newDeadline = new Deadline(commands.get(1), commands.get(2));
            tasks.addItem(newDeadline);
            ui.printAddedTask(newDeadline.toString(), tasks.getNumberOfItems());
        }
        else if (command.equals("event")) {
            Event newEvent = new Event(commands.get(1), commands.get(2));
            tasks.addItem(newEvent);
            ui.printAddedTask(newEvent.toString(), tasks.getNumberOfItems());
        }
    }
}