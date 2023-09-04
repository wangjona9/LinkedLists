class Main {
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

    public void setTaskId(int taskId) {
        this.taskId = taskId;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Task ID: " + taskId + ", Task Name: " + taskName + ", Description: " + description;
    }
}

class Node {
    Task task;
    Node next;

    public Node(Task task) {
        this.task = task;
        this.next = null;
    }
}

class TaskManager {
    private Node head;

    public TaskManager() {
        head = null;
    }

    public void addTask(int taskId, String taskName, String description) {
        Task newTask = new Task(taskId, taskName, description);
        Node newNode = new Node(newTask);
        newNode.next = head;
        head = newNode;
        System.out.println("Task added successfully.");
    }

    public void deleteTask(int taskId) {
        if (head == null) {
            System.out.println("Task list is empty.");
            return;
        }

        if (head.task.getTaskId() == taskId) {
            head = head.next;
            System.out.println("Task deleted successfully.");
            return;
        }

        Node current = head;
        while (current.next != null) {
            if (current.next.task.getTaskId() == taskId) {
                current.next = current.next.next;
                System.out.println("Task deleted successfully.");
                return;
            }
            current = current.next;
        }
        System.out.println("Task with ID " + taskId + " not found.");
    }

    public void viewAllTasks() {
        if (head == null) {
            System.out.println("No tasks found.");
        } else {
            System.out.println("Task List:");
            Node current = head;
            while (current != null) {
                System.out.println(current.task);
                current = current.next;
            }
        }
    }

        public static void main(String[] args) {
            TaskManager taskManager = new TaskManager();
    
            // Adding tasks
            taskManager.addTask(1, "Task 1", "Description 1");
            taskManager.addTask(2, "Task 2", "Description 2");
            taskManager.addTask(3, "Task 3", "Description 3");
    
            // Viewing all tasks
            taskManager.viewAllTasks();
    
            // Deleting a task
            taskManager.deleteTask(2);
    
            // Viewing all tasks after deletion
            taskManager.viewAllTasks();
        }
    }
    

