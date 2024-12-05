package com.wjoansah.threading;

public class FileDownloader implements Runnable {
    private String filename;

    public FileDownloader(String file) {
        this.filename = file;
    }

    @Override
    public void run() {
        try {
            System.out.println("[info] Downloading " + filename + "...");

            Thread.sleep((long) (Math.random() * 5000) + 1000); // Random delay between 1-6 seconds
            System.out.println("[info] Finished downloading " + filename);
        } catch (InterruptedException e) {
            System.err.println("[error] Download interrupted for " + filename);
        }
    }
}
