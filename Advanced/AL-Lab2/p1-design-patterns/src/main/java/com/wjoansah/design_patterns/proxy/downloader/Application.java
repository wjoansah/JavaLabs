package com.wjoansah.design_patterns.proxy.downloader;

public class Application {
    public static void main(String[] args) {
        FileDownload fileDownloader = new FileDownloader();

        // Replace "AUTH_TOKEN" with the correct token for testing authorization
        FileDownload proxy = new DownloadProxy(fileDownloader, "AUTH_TOKEN");

        String fileUrl = "https://example.com/file.zip";  // Example URL
        String destinationPath = "downloaded_file.zip";   // Destination path

        // Initiate download through the proxy
        proxy.downloadFile(fileUrl, destinationPath);
    }
}
