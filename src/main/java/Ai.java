import java.util.*;
import java.io.*;
import java.text.*;

public class Ai {
    protected String command;
    protected int exitCode;

    public Ai() {
        exitCode = 0;
    }

    public int getExitCode() {
        return exitCode;
    }

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