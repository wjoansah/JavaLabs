package com.wjoansah.design_patterns.strategy.compression;

import java.io.File;
import java.io.IOException;

public interface CompressionStrategy {
    void compress(File inputFile, File outputFile) throws IOException;
}
