import java.util.Scanner;

public class Duke {
    public static void main(String[] args) {
        System.out.println("\t____________________________________________________________");
        System.out.println("\tHello! I'm Duke");
        System.out.println("\tWhat can I do for you?");
        System.out.println("\t____________________________________________________________");

        Scanner scanner = new Scanner(System.in);
        while (true) {
            String input = scanner.nextLine();
            if (input.equals("bye")) {
                System.out.println("\t____________________________________________________________");
                System.out.println("\tBye. Hope to see you again soon!");
                System.out.println("\t____________________________________________________________");
                break;
            }
            else {
                System.out.println("\t____________________________________________________________");
                System.out.println("\t" + input);
                System.out.println("\t____________________________________________________________");
            }
        }
    }
}
