import java.util.*;
import java.io.*;
import java.text.*;

public class Parser {
    // cleans up user input and passes to AI
    public Parser() {
        ;
    }

    protected void checkParsableDate(String date) throws DukeException {
        try {
            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HHmm");
            Date dateValue = formatter.parse(date);
        }
        catch (ParseException e) {
            throw new DukeException("Please specify the date using the following format: dd/MM/yyyy HHmm");
        }
    }

    public ArrayList<String> parseInput(String input) throws DukeException {
        ArrayList<String> commands = new ArrayList<String>();
        String[] words = input.split(" ");
        if (input.equals("bye") && words.length == 1) {
            commands.add("close");
        }
        else if (input.equals("list") && words.length == 1) {
            commands.add("list");
        }
        else if (words[0].equals("done") && words.length <= 2) {
            commands.add("done");
            if (words.length == 1) {
                throw new DukeException("Please specify the task number you want to mark as done.");
            }
            if (!(words[1].matches("[1-9][0-9]*"))) {
                throw new DukeException("That's an invalid task number!");
            }
            commands.add(words[1]);
        }
        else if (words[0].equals("delete") && words.length <= 2) {
            commands.add("delete");
            if (words.length == 1) {
                throw new DukeException("Please specify the task number you want to mark as done.");
            }
            if (!(words[1].matches("[1-9][0-9]*"))) {
                throw new DukeException("That's an invalid task number!");
            }
            commands.add(words[1]);
        }
        else if (words[0].equals("find")) {
            commands.add("find");
            if (words.length == 1) {
                throw new DukeException("Tell me what you want me to find.");
            }
            String query = "";
            for (int i = 1; i < words.length; i++) {
                query += words[i];
                if (i != words.length - 1) {
                    query += " ";
                }
            }
            query = query.toLowerCase();
            commands.add(query);
        }
        else if (words[0].equals("todo")) {
            commands.add("todo");
            if (!(words.length > 1)) {
                throw new DukeException("The description of a todo cannot be empty.");
            }
            input = input.replaceFirst("todo ", "");
            commands.add(input);
        }
        else if (words[0].equals("deadline")) {
            commands.add("deadline");
            if (!(words.length > 1)) {
                throw new DukeException("The description of a deadline cannot be empty.");
            }
            input = input.replaceFirst("deadline ", "");
            int splitIndex = input.indexOf("/by");
            if (splitIndex == -1) {
                throw new DukeException("Please specify the deadline date/time using the '/by' command.");
            }
            else if (splitIndex == 0) {
                throw new DukeException("The description of a deadline cannot be empty.");
            }
            String description = input.substring(0, splitIndex - 1);
            if (description.isEmpty()) {
                throw new DukeException("The description of a deadline cannot be empty.");
            }
            commands.add(description);
            String by = input.substring(splitIndex + 1);
            by = by.replaceFirst("by ", "");
            if (by.equals("by")) {
                throw new DukeException("The deadline cannot be empty.");
            }
            checkParsableDate(by);
            commands.add(by);
        }
        else if (words[0].equals("event")) {
            commands.add("event");
            if (!(words.length > 1)) {
                throw new DukeException("The description of an event cannot be empty.");
            }
            input = input.replaceFirst("event ", "");
            int splitIndex = input.indexOf("/at");
            if (splitIndex == -1) {
                throw new DukeException("Please specify the event date using the '/at' command.");
            }
            else if (splitIndex == 0) {
                throw new DukeException("The description of an event cannot be empty.");
            }
            String description = input.substring(0, splitIndex - 1);
            if (description.isEmpty()) {
                throw new DukeException("The description of an event cannot be empty.");
            }
            commands.add(description);
            String at = input.substring(splitIndex + 1);
            at = at.replaceFirst("at ", "");
            if (at.equals("at")) {
                throw new DukeException("The event date cannot be empty.");
            }
            checkParsableDate(at);
            commands.add(at);
        }
        else {
            throw new DukeException("I'm sorry, but I don't know what that means :-(");
        }
        return commands;
    }
}