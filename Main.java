import java.util.ArrayList;
import java.util.List;

class Task {
    private int taskId;
    private String taskName;
    private String description;

    public Task(int taskId, String taskName, String description) {
        this.taskId = taskId;
        this.taskName = taskName;
        this.description = description;
    }

    public int getTaskId() {
        return taskId;
    }

    public String getTaskName() {
        return taskName;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return "Task ID: " + taskId + ", Task Name: " + taskName + ", Description: " + description;
    }
}

class TaskManager {
    private List<Task> taskList;

    public TaskManager() {
        taskList = new ArrayList<>();
    }

    public void addTask(int taskId, String taskName, String description) {
        Task newTask = new Task(taskId, taskName, description);
        taskList.add(newTask);
        System.out.println("Task added successfully.");
    }

    public void deleteTask(int taskId) {
        for (int i = 0; i < taskList.size(); i++) {
            Task task = taskList.get(i);
            if (task.getTaskId() == taskId) {
                taskList.remove(i);
                System.out.println("Task deleted successfully.");
                return;
            }
        }
        System.out.println("Task with ID " + taskId + " not found.");
    }

    public void viewAllTasks() {
        if (taskList.isEmpty()) {
            System.out.println("No tasks found.");
        } else {
            System.out.println("Task List:");
            for (Task task : taskList) {
                System.out.println(task);
            }
        }
    }
}

public class TaskManagerApp {
    public static void main(String[] args) {
        TaskManager taskManager = new TaskManager();

        // Adding tasks
        taskManager.addTask(1, "Task 1", "Description of Task 1");
        taskManager.addTask(2, "Task 2", "Description of Task 2");

        // Deleting a task
        taskManager.deleteTask(1);

        // Adding another task
        taskManager.addTask(3, "Task 3", "Description of Task 3");

        // Viewing all tasks
        taskManager.viewAllTasks();
    }
}

