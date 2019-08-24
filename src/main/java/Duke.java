import java.util.Scanner;
import java.util.ArrayList;

public class Duke {
    public static void main(String[] args) {
        System.out.println("\t____________________________________________________________");
        System.out.println("\tHello! I'm Duke");
        System.out.println("\tWhat can I do for you?");
        System.out.println("\t____________________________________________________________");

        ArrayList<String> items = new ArrayList<String>();
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
                for (int i = 0; i < items.size(); i++) {
                    System.out.println("\t" + (i+1) + ". " + items.get(i));
                }
                System.out.println("\t____________________________________________________________");
            }
            else {
                System.out.println("\t____________________________________________________________");
                System.out.println("\t" + "added: " + input);
                System.out.println("\t____________________________________________________________");
                items.add(input);
            }
        }
    }
}
