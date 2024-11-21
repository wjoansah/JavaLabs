package com.wjoansah.design_patterns.proxy.downloader;

public class DownloadProxy implements FileDownload {
    private final FileDownload fileDownloader;
    private final String authorizedUserToken;

    public DownloadProxy(FileDownload fileDownloader, String authorizedUserToken) {
        this.fileDownloader = fileDownloader;
        this.authorizedUserToken = authorizedUserToken;
    }

    @Override
    public void downloadFile(String fileUrl, String destinationPath) {
        // Authorization check
        if (!isUserAuthorized()) {
            System.out.println("Unauthorized access. Download denied.");
            return;
        }

        // Start download with progress reporting
        System.out.println("Authorization successful. Starting download...");
        fileDownloader.downloadFile(fileUrl, destinationPath);
    }

    private boolean isUserAuthorized() {
        // Simulate an authorization check
        return "AUTH_TOKEN".equals(authorizedUserToken);
    }
}
