package advanced_algorithms;

import java.util.PriorityQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TaskScheduler {
    protected final PriorityQueue<Task> tasks = new PriorityQueue<>();

    public void addTask(Task task) {
        tasks.add(task);
    }

    public Task getNextTask() {
        return tasks.poll();
    }

    public static class Task implements Runnable, Comparable<Task> {
        private final byte priority;
        private String name;

        public Task(byte priority, String name) {
            this.priority = priority;
            this.name = name;
        }

        public Task(String name) {
            this.priority = (byte) Math.floor(Math.random() * Byte.MAX_VALUE);
            this.name = name;
        }

        public byte getPriority() {
            return priority;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public int compareTo(Task o) {
            return Byte.compare(priority, o.priority);
        }

        @Override
        public void run() {
            System.out.println("Processing task: " + name + " priority: " + priority);
            try {
                var timeToWait = (int) Math.floor(Math.random() * 1000);
                System.out.println("[" + name + "] " + "Waiting for " + timeToWait + "ms");
                Thread.sleep(timeToWait);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Finished processing image: " + name);

        }
    }


    public static void main(String[] args) {

        var taskCount = 10;
        var scheduler = new TaskScheduler();

        try (ExecutorService executorService = Executors.newFixedThreadPool(1)) {
            for (int i = 0; i < taskCount; i++) {
                var task = new Task("task_" + i);
                scheduler.addTask(task);
            }

            while (!scheduler.tasks.isEmpty()) {
                executorService.submit((scheduler.getNextTask()));
            }

            executorService.shutdown();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
