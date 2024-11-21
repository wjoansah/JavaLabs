package com.wjoansah.nio;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.HashSet;
import java.util.Set;

public class NIOSample {

    public static void writeFileChannel(ByteBuffer byteBuffer) throws IOException {
        Set<StandardOpenOption> options = new HashSet<>();
        options.add(StandardOpenOption.CREATE);
        options.add(StandardOpenOption.APPEND);
        Path path = Paths.get("C:\\Users\\WonderfulOwusu-ansah\\JavaLabs\\Advanced\\AL-Lab1\\data-1.txt");
        FileChannel fileChannel = FileChannel.open(path, options);
        fileChannel.write(byteBuffer);
        fileChannel.close();
    }

    public static void main(String[] args) throws IOException {
        final String pathString = "C:\\Users\\WonderfulOwusu-ansah\\JavaLabs\\Advanced\\AL-Lab1\\data.txt";

        try (FileChannel channel = FileChannel.open(Paths.get(pathString), StandardOpenOption.READ)) {
            ByteBuffer buffer = ByteBuffer.allocate(1024);

            int bytesRead;
            do {
                bytesRead = channel.read(buffer);
                if (bytesRead > 0) {
                    System.out.println(new String(buffer.array(), 0, bytesRead));
                    buffer.clear();
                }

            } while (bytesRead > 0);
        }
    }
}
