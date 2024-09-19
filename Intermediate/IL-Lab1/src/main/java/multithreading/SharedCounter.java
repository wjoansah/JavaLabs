package multithreading;


public class SharedCounter {
    private int count = 0;

    public void increment() {
        synchronized (this) {
            count += 1;
        }
    }

    public int getCount() {
        return count;
    }

    public static void main(String[] args) {
        var counter = new SharedCounter();

        var t1 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                counter.increment();
//                System.out.println("t1: " + counter.getCount());
            }
        });

        var t2 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                counter.increment();
//                System.out.println("t2: " + counter.getCount());
            }
        });


        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("final count value: " + counter.getCount());
    }
}

//public class SharedCounter implements Runnable {
//    private int count = 0;
//
//    public void increment() {
//        count += 1;
//    }
//
//    @Override
//    public void run() {
//        for (int i = 0; i < 10; i++) {
//            increment();
//        }
//    }
//
//    public static void main(String[] args) {
//        var sharedCounter = new SharedCounter();
//
//        var counterOne = new Thread(sharedCounter);
//        var counterTwo = new Thread(sharedCounter);
//
//        counterOne.start();
//        counterTwo.start();
//
//        try {
//            counterOne.join();
//            counterTwo.join();
//        } catch (InterruptedException e) {
//            System.out.println(e.getMessage());
//        }
//
//        System.out.println("final count value: " + sharedCounter.count);
//    }
//
//}
