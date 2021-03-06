package duke.command;

import duke.DukeException;
import duke.PlaceList;
import duke.TaskList;
import duke.task.Task;

/**
 * Command type delete.
 */
public class DeleteCommand extends Command {

    private static final int LENGTH_DELETE = "delete ".length();

    private static final String ERROR_INCORRECT_FORMAT = "Invalid Argument: Input must to be integer";
    private static final String MESSAGE_OBJECT_NOT_FOUND = "No such task in the list";

    private final String command;

    /**
     * Constructs a delete command.
     *
     * @param command Input string.
     */
    public DeleteCommand(String command) {
        this.command = command;
    }

    /**
     * Execute and print a delete command.
     *
     * @param listT Passes TaskList in case of reading and writing to the list.
     * @param listP Passes PlaceList in case of reading and writing to the list.
     * @throws DukeException When encounter an error in command argument.
     */
    @Override
    public String executeAndPrint(TaskList listT, PlaceList listP) throws DukeException {
        int index;
        try {
            index = Integer.parseInt(command.substring(LENGTH_DELETE)) - 1;
        } catch (NumberFormatException e) {
            throw new DukeException(ERROR_INCORRECT_FORMAT);
        }
        if (index < listT.getSize() && index >= 0) {
            Task currTask = listT.getJob(index);
            listT.deleteJob(index);
            return "This task is deleted: \n"
                    + currTask.toString()
                    + "Now you have " + listT.getSize()
                    + (listT.getSize() == 1
                            ? " task in the list." + System.lineSeparator()
                            : " tasks in the list." + System.lineSeparator());
        } else {
            return MESSAGE_OBJECT_NOT_FOUND + System.lineSeparator();
        }
    }

    @Override
    public String toString() {
        return "Test usage: this is a DELETE command.";
    }
}
