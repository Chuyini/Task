package edu.uaslp.objetos.taskslist;

import edu.uaslp.objetos.taskslist.exception.TaskListException;

import java.time.LocalDateTime;

public class Task {
    private boolean completed;
    private String Description;
    private String Title;
    private LocalDateTime DueDate;
    protected Task previo;
    protected Task next;





    public Task(String name,String description,LocalDateTime deadline,boolean completed){
        this.Title=name;
        this.completed=completed;
        this.Description=description;
        this.DueDate=deadline;

    }
    public Task()
    {
        completed=false;
        Description=null;
        Title=null;


    }
    public void setTitle(String title)
    {
        this.Title=title;
    }

    public void setDescription(String Description)
    {
        this.Description=Description;
    }
    public String getDescription()
    {
        return Description;
    }
    public String getTitle()
    {
        return Title;
    }
    public void setDueDate(LocalDateTime dueDate)
    {
        if(LocalDateTime.now().isAfter(dueDate))
        {
            throw  new TaskListException();
        }else
        {
            this.DueDate=dueDate;
        }


    }

    public LocalDateTime getDueDate()
    {
        return DueDate;
    }
    public void setDone(boolean completed)
    {
        this.completed=completed;
    }


    public boolean isDone() {
        return completed;
    }
}
