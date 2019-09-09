import org.junit.jupiter.api.Test;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ParserTest {
    protected ArrayList<String> testOutput = new ArrayList<String>();
    protected Parser parser;

    public ParserTest() {
        parser = new Parser();
    }

    @Test
    public void testDeadline() {
        try {
            testOutput.add("deadline");
            testOutput.add("cry");
            testOutput.add("23/01/2019 1800");
            assertEquals(testOutput, parser.parseInput("deadline cry /by 23/01/2019 1800"));
        }
        catch (DukeException e) {
            e.showError();
        }
    }

    @Test
    public void testEvent() {
        try {
            testOutput.add("event");
            testOutput.add("cry");
            testOutput.add("23/01/2019 1800");
            assertEquals(testOutput, parser.parseInput("event cry /at 23/01/2019 1800"));
        }
        catch (DukeException e) {
            e.showError();
        }
    }

    @Test
    public void testTodo() {
        try {
            testOutput.add("todo");
            testOutput.add("cry");
            assertEquals(testOutput, parser.parseInput("todo cry"));
        }
        catch (DukeException e) {
            e.showError();
        }
    }
}