import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Todolist todo = new Todolist();
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            String input = sc.nextLine().replace("(",",").replace(")",",").replace("\"", "");
            String[] myarray = input.split(",");
            if(myarray.length>2){
                int id = Integer.parseInt(myarray[1]);
                if(myarray[0].equals("add_task")){
                    Task t = new Task(id,myarray[2],myarray[3],myarray[4],myarray[5]);
                    todo.add_task(t);
                }
                else if(myarray[0].equals("update_task")){
                    todo.update_task(myarray[2],myarray[3],myarray[6],myarray[7]);
                }
            }
            else if(myarray[0].equals("remove_task")){
                todo.remove_task(Integer.parseInt(myarray[1]));
            }
            else if(myarray[0].equals("get_all_tasks")){
                todo.get_all_tasks();
            }
            else if(myarray[0].equals("get_pending_tasks")){
                todo.get_pending_tasks();
            }
            else if(myarray[0].equals("get_completed_tasks")){
                todo.get_completed_tasks();
            }
            else if(myarray[0].equals("sort_tasks")){
                todo.sort_tasks(myarray[1]);
            }
            else if(myarray[0].equals("search_tasks")){
                todo.search_tasks(myarray[1]);
            }
            else if(myarray[0].equals("mark_completed")){
                Task t = new Task(0, input, input, input, input);
                todo.mark_completed(Integer.parseInt(myarray[1]));
            }
        }

    }
}
class Task{
    int task_id;
    String title;
    String description;
    String due_date;
    String priority;
    String is_completed;

    public Task(int task_id,String title,String description,String due_date,String priority){
        this.task_id=task_id;
        this.title=title;
        this.description=description;
        this.due_date=due_date;
        this.priority=priority;
    }


    public void get_task_details(){
    }
    public String getDueDate() {
        return due_date;
    }

    public int getPriority() {
        switch (priority.toLowerCase()) {
            case "high":
                return 1;
            case "medium":
                return 2;
            case "low":
                return 3;
            default:
                return 4;
        }
    }

    public String toString(){
        return this.task_id+". ["+this.is_completed+"] "+this.title+" - Due: "+this.due_date+", Priority: "+this.priority;
    }
}

class Todolist{
    ArrayList<Task> tasks;

    public Todolist(){
        this.tasks = new ArrayList<>();
    }

    public void add_task(Task task){
        task.is_completed = "Pending";
        tasks.add(task);
    }

    public void remove_task(int task_id){
        tasks.removeIf(i -> i.task_id==task_id);
    }
    public void get_all_tasks(){
        System.out.println("All Tasks:");
        for(Task i:tasks){
            System.out.println(i);
        }
        System.out.println("\n");
    }
    public void get_pending_tasks(){
        System.out.println("Pending Tasks:");
        for (Task t : tasks) {
            if(t.is_completed.equals("Pending")){
                System.out.println(t);
            }
        }
        System.out.println("\n");
    }
    public void get_completed_tasks(){
        System.out.println("Completed Tasks:");
        for (Task t : tasks) {
            if(t.is_completed.equals("Completed")){
                System.out.println(t);
            }
        }
        System.out.println("\n");
    }

    public void sort_tasks(String by){
        if (by.equals("due_date")) {
            tasks.sort(Comparator.comparing(Task::getDueDate));
        } else if (by.equals("priority")) {
            tasks.sort(Comparator.comparingInt(Task::getPriority));
        } else {
            System.out.println("Invalid sort key. Use 'due_date' or 'priority'.");
        }
    }
    public void search_tasks(String s){
        System.out.println("Search Results for: "+s);
        for(Task t:tasks){
            String i = t.toString();
            if(i.contains(s)){
                System.out.println(t);;
            }
        }
    }
    public void mark_completed(int n){
        for(Task t:tasks){
            if(t.task_id==n){
                t.is_completed="Completed";
                // System.out.println(t);
            }
        }
    }
    public void update_task(String t,String de,String dd,String p){
        for(Task k:tasks){
            if (k.title.equals(t)) {
                if(!k.description.equals(de)){
                    k.description=de;
                }
                if(!k.due_date.equals(dd)){
                    k.due_date=dd;
                }
                if(!k.priority.equals(p)){
                    k.priority = p;
                }
            }

        }
    }

}