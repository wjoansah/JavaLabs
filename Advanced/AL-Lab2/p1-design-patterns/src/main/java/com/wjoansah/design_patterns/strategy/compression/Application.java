package com.wjoansah.design_patterns.strategy.compression;

import java.io.File;

public class Application {
    public static void main(String[] args) {

        File inputFile = new File("path/to/input.txt");
        File zipOutputFile = new File("path/to/output.zip");
        File gzipOutputFile = new File("path/to/output.gz");

        CompressionContext context = new CompressionContext();

        try {
            // Use ZIP compression
            context.setCompressionStrategy(new ZipCompressionStrategy());
            context.compressFile(inputFile, zipOutputFile);
            System.out.println("File compressed using ZIP strategy.");

            // Use GZIP compression
            context.setCompressionStrategy(new GZipCompressionStrategy());
            context.compressFile(inputFile, gzipOutputFile);
            System.out.println("File compressed using GZIP strategy.");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
