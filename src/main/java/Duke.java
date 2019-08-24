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
            if (input.equals("bye")) {
                System.out.println("\t____________________________________________________________");
                System.out.println("\tBye. Hope to see you again soon!");
                System.out.println("\t____________________________________________________________");
                break;
            }
            else if (input.equals("list")) {
                System.out.println("\t____________________________________________________________");
                System.out.println("\tHere are the tasks in your list:");
                for (int i = 0; i < items.size(); i++) {
                    Task thisTask = items.get(i);
                    System.out.println("\t" + (i+1) + ". [" + thisTask.getStatusIcon() + "] " + thisTask.getDescription());
                }
                System.out.println("\t____________________________________________________________");
            }
            else {
                String[] words = input.split(" ");
                if (input.contains("done") && words.length == 2 && words[1].matches("-?\\d+(\\.\\d+)?")) {
                    int taskNumber = Integer.parseInt(words[1]) - 1;
                    Task thisTask = items.get(taskNumber);
                    thisTask.markAsDone();
                    System.out.println("\t____________________________________________________________");
                    System.out.println("\tNice! I've marked this task as done:");
                    System.out.println("\t\t[" + thisTask.getStatusIcon() + "] " + thisTask.getDescription());
                }
                else {
                    System.out.println("\t____________________________________________________________");
                    System.out.println("\t" + "added: " + input);
                    System.out.println("\t____________________________________________________________");
                    Task newTask = new Task(input);
                    items.add(newTask);
                }
            }
        }
    }
}
