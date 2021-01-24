package duke.command;

import duke.DukeException;
import duke.StringParser;
import duke.task.Task;
import duke.TaskList;

/**
 * Command type delete.
 */
public class DeleteCommand extends Command {
    private final String command;

    /**
     * Delete command builder.
     *
     * @param command Input string.
     */
    public DeleteCommand(String command) {
        this.command = command;
    }

    /**
     * Execute and print a delete command.
     *
     * @param list Passes TaskList in case of reading and writing to the list.
     * @param length For printer to call newLiner, make Duke looks nice.
     * @throws DukeException When encounter an error in command argument.
     */
    @Override
    public void executeAndPrint(TaskList list, int length) throws DukeException {
        int index;
        index = Integer.parseInt(command.substring(7)) - 1;
        if (index < list.getSize() && index >= 0) {
            Task currTask = list.getJob(index);
            list.deleteJob(index);
            System.out.print("This task is deleted: \n"
                    + StringParser.newLiner(currTask.toString(), length)
                    + "Now you have " + list.getSize()
                    + (list.getSize() == 1 ? " task in the list\n" : " tasks in the list\n"));
        } else {
            System.out.print("No such task in the list\n");
        }
    }

    @Override
    public boolean isExit() {
        return false;
    }

    @Override
    public String toString() {
        return "Test usage: this is a DELETE command";
    }
}
