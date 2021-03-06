package duke.command;

import duke.DukeException;
import duke.PlaceList;
import duke.TaskList;

/**
 * Command type exit.
 */
public class ExitCommand extends Command {

    /**
     * Execute and print a exit command.
     *
     * @param listT Passes TaskList in case of reading and writing to the list.
     * @param listP Passes PlaceList in case of reading and writing to the list.
     * @throws DukeException When encounter an error in command argument.
     */
    @Override
    public String executeAndPrint(TaskList listT, PlaceList listP) throws DukeException {
        return "";
    }

    @Override
    public String toString() {
        return "Test usage: this is an EXIT command.";
    }
}
