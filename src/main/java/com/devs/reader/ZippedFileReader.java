package com.devs.reader;

import net.lingala.zip4j.ZipFile;
import net.lingala.zip4j.model.FileHeader;

import java.io.IOException;
import java.io.InputStream;

public class ZippedFileReader implements CompressedFileReader {
    @Override
    public InputStream getInputStream(String filePath, char[] password) throws IOException {
        ZipFile zipFile = new ZipFile("file.zip", "pass123".toCharArray());
        FileHeader fileHeader = zipFile.getFileHeader("data.csv");
        return zipFile.getInputStream(fileHeader);
    }
}
