package multithreading;

public class DeadlockSim {

    private final Object resource1 = new Object();
    private final Object resource2 = new Object();

    public void thread1() {
        synchronized (resource1) {
            System.out.println("Thread 1: acquired resource 1");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }

        synchronized (resource2) {
            System.out.println("Thread 1: is waiting for resource 2 [deadlock]");
        }
    }


    public void thread1_improved() {
        synchronized (resource1) {
            System.out.println("Thread 1: acquired resource 1");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }

        synchronized (resource2) {
            System.out.println("Thread 1: is waiting for resource 2");
        }
    }

    public void thread2() {
        synchronized (resource2) {
            System.out.println("Thread 2: acquired resource 2");
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }


        synchronized (resource1) {
            System.out.println("Thread 2: is waiting for resource 1");
        }
    }

    public void thread2_improved() {
        synchronized (resource1) {
            System.out.println("Thread 2: acquired resource 1");
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }

        synchronized (resource2) {
            System.out.println("Thread 2: is waiting for resource 2");
        }
    }

    public static void main(String[] args) {
        var sim = new DeadlockSim();

        new Thread(sim::thread1).start();
        new Thread(sim::thread2).start();
    }
}
