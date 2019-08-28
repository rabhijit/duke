import java.util.Scanner;
import java.util.ArrayList;

public class Duke {
    public static void main(String[] args) {
        System.out.println("\t____________________________________________________________");
        System.out.println("\tHello! I'm Duke");
        System.out.println("\tWhat can I do for you?");
        System.out.println("\t____________________________________________________________");

        ArrayList<Task> items = new ArrayList<Task>();
        Scanner scanner = new Scanner(System.in);
        while (true) {
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
            else if (input.contains("done") && words.length == 2 && words[1].matches("^\\d*$")) {
                int taskNumber = Integer.parseInt(words[1]) - 1;
                Task thisTask = items.get(taskNumber);
                thisTask.markAsDone();
                System.out.println("\t____________________________________________________________");
                System.out.println("\tNice! I've marked this task as done:");
                System.out.println("\t  " + thisTask.toString());
                System.out.println("\t____________________________________________________________");
            }
            else if (words.length > 1 && words[0].equals("todo")) {
                input = input.replaceFirst("todo", "");
                Todo newTodo = new Todo(input);
                items.add(newTodo);
                System.out.println("\t____________________________________________________________");
                System.out.println("\tGot it. I've added this task: ");
                System.out.println("\t  " + newTodo.toString());
                System.out.println("\tNow you have " + items.size() + " tasks in the list.");
                System.out.println("\t____________________________________________________________");
            }
            else if (words.length > 1 && words[0].equals("deadline")) {
                input = input.replaceFirst("deadline", "");
                int splitIndex = input.indexOf("/");
                String description = input.substring(0, splitIndex);
                String by = input.substring(splitIndex + 1);
                by = by.replaceFirst("by ", "");
                Deadline newDeadline = new Deadline(description, by);
                items.add(newDeadline);
                System.out.println("\t____________________________________________________________");
                System.out.println("\tGot it. I've added this task: ");
                System.out.println("\t  " + newDeadline.toString());
                System.out.println("\tNow you have " + items.size() + " tasks in the list.");
                System.out.println("\t____________________________________________________________");
            }
            else if (words.length > 1 && words[0].equals("event")) {
                input = input.replaceFirst("event", "");
                int splitIndex = input.indexOf("/");
                String description = input.substring(0, splitIndex);
                String at = input.substring(splitIndex + 1);
                at = at.replaceFirst("at ", "");
                Event newEvent = new Event(description, at);
                items.add(newEvent);
                System.out.println("\t____________________________________________________________");
                System.out.println("\tGot it. I've added this task: ");
                System.out.println("\t  " + newEvent.toString());
                System.out.println("\tNow you have " + items.size() + " tasks in the list.");
                System.out.println("\t____________________________________________________________");
            }
            /*
            else {
                System.out.println("\t____________________________________________________________");
                System.out.println("\t" + "added: " + input);
                System.out.println("\t____________________________________________________________");
                Task newTask = new Task(input);
                items.add(newTask);
            }
            */
        }
    }
}
