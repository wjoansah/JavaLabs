package com.wjoansah.nio;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.HashSet;
import java.util.Set;

public class NioFileCopier {
    public static void copy(Path src, Path dest) throws IOException {
        if (!src.toFile().exists()) {
            throw new FileNotFoundException(src + " does not exist");
        }

        Set<StandardOpenOption> options = new HashSet<>();
        options.add(StandardOpenOption.CREATE);
        options.add(StandardOpenOption.WRITE);

        try (FileChannel inputStream = FileChannel.open(src); FileChannel outputStream = FileChannel.open(dest, options)) {

            ByteBuffer buffer = ByteBuffer.allocate(1024);
            long totalBytes = inputStream.size();
            long bytesCopied = 0;
            double progress;

            while (inputStream.read(buffer) > 0) {
                buffer.flip();
                int bytesWritten = outputStream.write(buffer);
                bytesCopied += bytesWritten;
                buffer.clear();

                progress = (double) bytesCopied / totalBytes * 100;
                System.out.printf("Progress: %.2f%%%n ", progress);
            }
        }

        System.out.println("Files copied successfully");
    }

    public static void main(String[] args) {
        Path srcPath = Paths.get("data.txt");
        Path destPath = Paths.get("output.txt");

        try {
            NioFileCopier.copy(srcPath, destPath);
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }
}
