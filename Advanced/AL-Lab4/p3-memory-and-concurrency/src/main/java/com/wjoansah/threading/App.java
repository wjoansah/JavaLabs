package com.wjoansah.threading;

import java.util.Arrays;
import java.util.List;

public class App {
    public static void main(String[] args) {
        List<String> files = Arrays.asList("file1.txt", "file2.txt", "file3.txt");

        System.out.println("[info] Starting downloads...");

        for (String file : files) {
            Thread downloadThread = new Thread(new FileDownloader(file));
            downloadThread.start();
        }

        System.out.println("[info] All download thread started");
    }
}
