package edu.uaslp.objetos.taskslist;
import edu.uaslp.objetos.taskslist.Task;
import edu.uaslp.objetos.taskslist.exception.TaskNotFoundException;

public class TaskList implements List{
    private int size;
    private Task  head;
    private Task  tail;
    private int NextTask=0;

    public Task getNextTask()
    {
        Task aux=head;
        for(int cont=0;cont<=NextTask&&aux!=null;cont++,aux=aux.next);
        NextTask++;
        return aux;
    }

    public List<Task> getNextTasks()
    {

        TaskList list=new TaskList();
        List<Task> taskList=list;
        int cont;


        Task aux=tail;


        for(cont=size-1;cont>=0&&aux!=null;cont--)
        {
            if(aux.isDone()==false)
            {
                Task copia=new Task(aux.getTitle(), aux.getDescription(), aux.getDueDate(),false);
                taskList.add(copia);
            }
            aux=aux.previo;
        }
        return taskList;
    }
    public Task get(int i)
    {
        Task aux=new Task();
        aux=head;
        for(int cont=0;cont<i;cont++)
        {
            aux=aux.next;
        }
        findTask(aux);
        return aux;



    }
    public void add( Task element)
    {

        if(head==null)
        {

            head=element;
            tail=element;
            size++;


        }else
        {
            Task aux=head;
            for(int cont=0;cont<size-1;cont++)
            {
                aux=aux.next;
            }
            aux.next=element;
            element.previo=aux;
            tail=element;
            size++;
        }
    }



    public int getSize() {
        return size;
    }

    public void remove(Task tareilla)
    {
        Task aux=findTask(tareilla);
        if(aux!=null)
        {

            if(aux==head)
            {
                head=head.next;
                head.previo=null;
                size--;

            }else if(aux==tail)
            {
                tail=tail.previo;
                tail.next=null;
                size--;
            }else
            {
                aux.previo.next=aux.next;
                aux.next.previo=aux.previo;
                aux=null;
                size--;
            }



        }


    }
    public Task find(String title)
    {
        Task aux= head;
        for (int cont=0;cont<=size&&aux!=null;cont++)
        {
            if(aux.getTitle()==title)
            {
                return aux;
            }
            aux=aux.next;
        }
        throw new TaskNotFoundException();

    }
    public void markAsDone(String title) {
        Task taskFound = find(title);
        if (taskFound != null) {
            taskFound.setDone(true);

        }

    }
    public void markAsNotDone(String title) {
        Task taskFound = find(title);
        if (taskFound != null) {
            taskFound.setDone(false);

        }


    }




    private Task findTask(Task tarea)
    {
        Task aux= head;
        Task aux2=new Task();
        for (int cont=0;cont<=size&&aux!=null;cont++)
        {
            if(aux.getTitle()==tarea.getTitle())
            {
                aux2=aux;
            }
            aux=aux.next;
        }
        return aux2;

    }



}
