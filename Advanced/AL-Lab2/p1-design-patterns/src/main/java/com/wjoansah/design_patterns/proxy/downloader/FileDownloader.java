package com.wjoansah.design_patterns.proxy.downloader;

import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;

public class FileDownloader implements FileDownload {
    @Override
    public void downloadFile(String fileUrl, String destinationPath) {
        try (BufferedInputStream in = new BufferedInputStream(new URL(fileUrl).openStream());
             FileOutputStream fileOutputStream = new FileOutputStream(destinationPath)) {

            byte[] dataBuffer = new byte[1024];
            int bytesRead;
            long downloaded = 0;

            while ((bytesRead = in.read(dataBuffer, 0, 1024)) != -1) {
                fileOutputStream.write(dataBuffer, 0, bytesRead);
                downloaded += bytesRead;
            }

            System.out.println("Download complete!");
        } catch (IOException e) {
            System.out.println("An error occurred during file download: " + e.getMessage());
        }
    }
}
