import java.util.*;
import java.io.*;
import java.text.*;

public class Ui {
    protected Scanner inputScanner;
    protected String input;

    public Ui() {
        inputScanner = new Scanner(System.in);
        welcome();
    }

    public String getInput() {
        input = inputScanner.nextLine();
        return input;
    }

    public void printArray(ArrayList<String> inputs) {
        System.out.println("\t____________________________________________________________");
        for (int i = 0; i < inputs.size(); i++) {
            System.out.println("\t" + inputs.get(i));
        }
        System.out.println("\t____________________________________________________________");
    }

    public void printTaskArray(String command, ArrayList<String> inputs) {
        System.out.println("\t____________________________________________________________");
        System.out.println("\t" + command);
        for (int i = 0; i < inputs.size(); i++) {
            System.out.println("\t" + inputs.get(i));
        }
        System.out.println("\t____________________________________________________________");
    }

    public void print(String input) {
        printArray(new ArrayList<String>(Arrays.asList(input)));
    }

    public void printTask(String command, String input) {
        printTaskArray(command, new ArrayList<String>(Arrays.asList(input)));
    }

    public void printAddedTask(String input, int noTasks) {
        System.out.println("\t____________________________________________________________");
        System.out.println("\tGot it. I've added this task:");
        System.out.println("\t  " + input);
        System.out.println("\tNow you have " + noTasks + " tasks in the list.");
        System.out.println("\t____________________________________________________________");
    }

    public void printRemovedTask(String input, int noTasks) {
        System.out.println("\t____________________________________________________________");
        System.out.println("\tNoted. I've removed this task:");
        System.out.println("\t  " + input);
        System.out.println("\tNow you have " + noTasks + " tasks in the list.");
        System.out.println("\t____________________________________________________________");
    }

    public void farewell() {
        print("Bye. Hope to see you again soon!");
    }

    public void welcome() {
        printArray(new ArrayList<String>(Arrays.asList("Hello! I'm Duke", "What can I do for you?")));
    }

}