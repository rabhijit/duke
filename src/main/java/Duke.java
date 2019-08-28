import java.util.Scanner;
import java.util.ArrayList;

public class Duke {
    public static void main(String[] args) throws DukeException {
        System.out.println("\t____________________________________________________________");
        System.out.println("\tHello! I'm Duke");
        System.out.println("\tWhat can I do for you?");
        System.out.println("\t____________________________________________________________");

        ArrayList<Task> items = new ArrayList<Task>();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            try {
                String input = scanner.nextLine();
                String[] words = input.split(" ");
                if (input.equals("bye") && words.length == 1) {
                    System.out.println("\t____________________________________________________________");
                    System.out.println("\tBye. Hope to see you again soon!");
                    System.out.println("\t____________________________________________________________");
                    break;
                }
                else if (input.equals("list") && words.length == 1) {
                    System.out.println("\t____________________________________________________________");
                    System.out.println("\tHere are the tasks in your list:");
                    for (int i = 0; i < items.size(); i++) {
                        Task thisTask = items.get(i);
                        System.out.println("\t" + (i+1) + ". " + thisTask.toString());
                    }
                    System.out.println("\t____________________________________________________________");
                }
                else if (words[0].equals("done") && words.length <= 2) {
                    if (words.length == 1) {
                        throw new DukeException("Please specify the task number you want to mark as done.");
                    }
                    if (!(words[1].matches("^\\d*$"))) {
                        throw new DukeException("That's an invalid task number!");
                    }
                    int taskNumber = Integer.parseInt(words[1]) - 1;
                    if (taskNumber + 1 > items.size()) {
                        throw new DukeException("We don't have that many tasks!");
                    }
                    Task thisTask = items.get(taskNumber);
                    thisTask.markAsDone();
                    System.out.println("\t____________________________________________________________");
                    System.out.println("\tNice! I've marked this task as done:");
                    System.out.println("\t  " + thisTask.toString());
                    System.out.println("\t____________________________________________________________");
                }
                else if (words[0].equals("todo")) {
                    if (!(words.length > 1)) {
                        throw new DukeException("The description of a todo cannot be empty.");
                    }
                    input = input.replaceFirst("todo ", "");
                    Todo newTodo = new Todo(input);
                    items.add(newTodo);
                    System.out.println("\t____________________________________________________________");
                    System.out.println("\tGot it. I've added this task: ");
                    System.out.println("\t  " + newTodo.toString());
                    System.out.println("\tNow you have " + items.size() + " tasks in the list.");
                    System.out.println("\t____________________________________________________________");
                }
                else if (words[0].equals("deadline")) {
                    if (!(words.length > 1)) {
                        throw new DukeException("The description of a deadline cannot be empty.");
                    }
                    input = input.replaceFirst("deadline ", "");
                    int splitIndex = input.indexOf("/by");
                    if (splitIndex == -1) {
                        throw new DukeException("Please specify the deadline date/time using the '/by' command.");
                    }
                    String description = input.substring(0, splitIndex);
                    if (description.isEmpty()) {
                        throw new DukeException("The description of a deadline cannot be empty.");
                    }
                    String by = input.substring(splitIndex + 1);
                    by = by.replaceFirst("by ", "");
                    if (by.equals("by")) {
                        throw new DukeException("The deadline cannot be empty.");
                    }
                    Deadline newDeadline = new Deadline(description, by);
                    items.add(newDeadline);
                    System.out.println("\t____________________________________________________________");
                    System.out.println("\tGot it. I've added this task: ");
                    System.out.println("\t  " + newDeadline.toString());
                    System.out.println("\tNow you have " + items.size() + " tasks in the list.");
                    System.out.println("\t____________________________________________________________");
                }
                else if (words[0].equals("event")) {
                    if (!(words.length > 1)) {
                        throw new DukeException("The description of an event cannot be empty.");
                    }
                    input = input.replaceFirst("event ", "");
                    int splitIndex = input.indexOf("/at");
                    if (splitIndex == -1) {
                        throw new DukeException("Please specify the event date using the '/at' command.");
                    }
                    String description = input.substring(0, splitIndex);
                    if (description.isEmpty()) {
                        throw new DukeException("The description of an event cannot be empty.");
                    }
                    String at = input.substring(splitIndex + 1);
                    at = at.replaceFirst("at ", "");
                    if (at.equals("at")) {
                        throw new DukeException("The event date cannot be empty.");
                    }
                    Event newEvent = new Event(description, at);
                    items.add(newEvent);
                    System.out.println("\t____________________________________________________________");
                    System.out.println("\tGot it. I've added this task: ");
                    System.out.println("\t  " + newEvent.toString());
                    System.out.println("\tNow you have " + items.size() + " tasks in the list.");
                    System.out.println("\t____________________________________________________________");
                }
                else {
                    throw new DukeException("I'm sorry, but I don't know what that means :-(");
                }
            }
            catch(DukeException e) {
                e.showError();
            }
        }
    }
}
