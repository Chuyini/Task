package edu.uaslp.objetos.taskslist;
import edu.uaslp.objetos.taskslist.TaskList;
import edu.uaslp.objetos.taskslist.exception.TaskNotFoundException;

public interface  List<T> {
    public List<Task> getNextTasks();
    public void add(Task element);
    public int getSize();
    public void remove(Task tareilla);
    public Task find(String title);
    public void markAsDone(String title);
    public void markAsNotDone(String title);

    Task get(int i);


    // private Task findTask();

}