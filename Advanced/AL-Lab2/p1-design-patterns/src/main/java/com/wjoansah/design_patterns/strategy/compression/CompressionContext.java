package com.wjoansah.design_patterns.strategy.compression;

import java.io.File;
import java.io.IOException;

public class CompressionContext {
    private CompressionStrategy strategy;

    // Setter for strategy
    public void setCompressionStrategy(CompressionStrategy strategy) {
        this.strategy = strategy;
    }

    // Method to compress a file using the selected strategy
    public void compressFile(File inputFile, File outputFile) throws IOException {
        if (strategy == null) {
            throw new IllegalStateException("Compression strategy not set");
        }
        strategy.compress(inputFile, outputFile);
    }
}
