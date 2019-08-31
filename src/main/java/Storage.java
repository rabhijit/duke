import java.util.*;
import java.io.*;
import java.text.*;

public class Storage {
    // converts the .txt file to a list of tasks
    protected ArrayList<Task> items = new ArrayList<Task>();
    protected File file;

    public Storage(String filename) throws FileNotFoundException, ParseException {
        file = new File(filename);
        readFromFile();
    }

    public void readFromFile() throws FileNotFoundException, ParseException {
        Scanner fileScanner = new Scanner(file);
        while (fileScanner.hasNextLine()) {
            String[] line = fileScanner.nextLine().split("`");
            boolean isDone = (Integer.parseInt(line[2]) == 1);
            if (line[0].equals("T")) {
                Todo newTodo = new Todo(line[1], isDone);
                items.add(newTodo);
            }
            else if (line[0].equals("D")) {
                Deadline newDeadline = new Deadline(line[1], line[3], isDone);
                items.add(newDeadline);
            }
            else if (line[0].equals("E")) {
                Event newEvent = new Event(line[1], line[3], isDone);
                items.add(newEvent);
            }
        }
        // take in TaskList and save to it directly?
    }

    public void saveToFile(ArrayList<Task> tasks) throws ParseException, IOException {
        BufferedWriter fileWriter = new BufferedWriter(new FileWriter(file, false));
        for (int i = 0; i < tasks.size(); i++) {
            Task thisTask = tasks.get(i);
            String line = thisTask.getType() + "`" + thisTask.getDescription() + "`";
            line += (thisTask.getDoneStatus() == true ? 1 : 0);
            if (thisTask.getType() == 'D' || thisTask.getType() == 'E') {
                line += "`";
                line += thisTask.getDateToSave();
            }
            fileWriter.write(line);
            fileWriter.newLine();
        }
        fileWriter.close();
    }

    public ArrayList<Task> getItems() {
        return items;
    }
}