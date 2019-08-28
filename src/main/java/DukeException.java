public class DukeException extends Exception {
    protected String oops = "☹ OOPS!!! ";
    protected String errorMsg;

    public DukeException(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public void showError() {
        System.out.println("\t____________________________________________________________");
        System.out.println("\t" + oops + errorMsg);
        System.out.println("\t____________________________________________________________");
    }
}