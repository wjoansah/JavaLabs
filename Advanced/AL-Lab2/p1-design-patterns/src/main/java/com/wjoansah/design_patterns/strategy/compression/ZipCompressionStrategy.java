package com.wjoansah.design_patterns.strategy.compression;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class ZipCompressionStrategy implements CompressionStrategy {
    @Override
    public void compress(File inputFile, File outputFile) throws IOException {
        try (FileOutputStream fos = new FileOutputStream(outputFile);
             ZipOutputStream zipOut = new ZipOutputStream(fos);
             FileInputStream fis = new FileInputStream(inputFile)) {

            ZipEntry zipEntry = new ZipEntry(inputFile.getName());
            zipOut.putNextEntry(zipEntry);

            byte[] buffer = new byte[1024];
            int length;
            while ((length = fis.read(buffer)) >= 0) {
                zipOut.write(buffer, 0, length);
            }
            zipOut.closeEntry();
        }
    }
}
