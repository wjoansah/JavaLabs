package datastructures.queues;

import java.util.LinkedList;
import java.util.Queue;

public class TTaskScheduler {
    private Queue<String> taskQueue;

    public TTaskScheduler() {
        taskQueue = new LinkedList<>();
    }

    public void addTask(String task) {
        taskQueue.offer(task);
        System.out.println("Task added: " + task);
    }

    public void processNextTask() {
        if (taskQueue.isEmpty()) {
            System.out.println("No tasks in the queue.");
        } else {
            String task = taskQueue.poll();
            System.out.println("Task processed: " + task);
        }
    }

    public void displayQueue() {
        System.out.println("Current queue contents:");
        if (taskQueue.isEmpty()) {
            System.out.println("Queue is empty.");
        } else {
            for (String task : taskQueue) {
                System.out.println(task);
            }
        }
    }

    public static void main(String[] args) {
        var scheduler = new TTaskScheduler();

        scheduler.addTask("Task 1");
        scheduler.addTask("Task 2");
        scheduler.addTask("Task 3");

        scheduler.displayQueue();

        scheduler.processNextTask();
        scheduler.processNextTask();
        scheduler.processNextTask();
        scheduler.processNextTask(); // No tasks in the queue
    }
}
