import java.util.*;
import java.io.*;
import java.text.*;

public class Duke {
    private Storage storage;
    private TaskList tasks;
    private Ui ui;
    private Parser parser;
    private Ai ai;

    public Duke(String filePath) throws FileNotFoundException, ParseException {
        storage = new Storage(filePath);
        tasks = new TaskList(storage.getItems());
        parser = new Parser();
        ai = new Ai();
        ui = new Ui();
    }

    public void run() throws ParseException, IOException {
        while (ai.getExitCode() != 1) {
            try {
                ai.execute(parser.parseInput(ui.getInput()), ui, storage, tasks);
            }
            catch (DukeException e) {
                e.showError();
            }
        }
    }

    public static void main(String[] args) throws FileNotFoundException, ParseException, IOException, DukeException {
        new Duke("data/duke.txt").run();
    }

}
