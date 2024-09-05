package froggy;

/**
 * Adds a deadline to the task list.
 */
public class AddDeadlineCommand extends Command {

    private final String input;

    /**
     * Constructor that takes in raw input as String.
     *
     * @param input raw input
     */
    public AddDeadlineCommand(String input){
        this.input = input;
    }

    @Override
    public void execute(TaskList taskList, Ui ui, Storage storage) {
        int index = input.toLowerCase().indexOf("/by ");
        if (index != -1) {
            String desc = input.substring(9, index - 1);
            String by = input.substring(index + 4);
            Deadline current = new Deadline(desc, by);
            taskList.add(current, storage);
            System.out.println("Added this task:");
            System.out.println(current.toString());
            ui.showLine();
        }
    }

    @Override
    public boolean isExit() {
        return false;
    }
}
