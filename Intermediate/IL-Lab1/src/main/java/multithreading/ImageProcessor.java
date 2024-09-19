package multithreading;

import java.util.concurrent.Executors;

public class ImageProcessor {

    public static class ImageProcessingTask implements Runnable {
        private final String imageFilename;

        public ImageProcessingTask(String imageFilename) {
            this.imageFilename = imageFilename;
        }

        @Override
        public void run() {
            // Simulate image processing
            System.out.println("Processing image: " + imageFilename);
            try {
                var timeToWait = (int) Math.floor(Math.random() * 3000);
                System.out.println("[" + imageFilename + "] " + "Waiting for " + timeToWait + "ms");
                Thread.sleep(timeToWait);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Finished processing image: " + imageFilename);
        }
    }

    public static void main(String[] args) {

        var imageCount = 5;

        try (var executorService = Executors.newFixedThreadPool(2);) {
            for (int i = 0; i < imageCount; i++) {
                var task = new ImageProcessingTask("image_" + i);
                executorService.submit(task);
            }
            executorService.shutdown();
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
