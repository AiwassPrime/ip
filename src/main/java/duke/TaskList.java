package duke;

import java.util.ArrayList;

import duke.task.Task;

/**
 * ArrayList adapted to Duke.
 */
public class TaskList {

    private final ArrayList<Task> list;

    public TaskList() {
        this.list = new ArrayList<>();
    }

    public void addJob(Task t) {
        this.list.add(t);
    }

    public Task getJob(int index) {
        return this.list.get(index);
    }

    public int getSize() {
        return this.list.size();
    }

    /**
     * Replaces Task at index with newTask.
     *
     * @param index Target Task.
     * @param newTask New Task to add.
     */
    public void replaceJob(int index, Task newTask) {
        assert this.list.get(index) != null : "Index not handled correctly by done command.";
        this.list.remove(index);
        this.list.add(index, newTask);
    }

    /**
     * Deletes Task at index.
     *
     * @param index Target Task.
     */
    public void deleteJob(int index) {
        assert this.list.get(index) != null : "Index not handled correctly by delete command.";
        this.list.remove(index);
    }

    /**
     * Formats the list to its output format.
     *
     * @return String in correct format.
     */
    public String formatList() {
        StringBuilder resultStr = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            resultStr.append(i + 1).append(".").append(list.get(i).toString());
        }
        return resultStr.toString();
    }
}
