package com.devs.reader;

import net.lingala.zip4j.exception.ZipException;

import java.io.IOException;
import java.io.InputStream;

public interface CompressedFileReader {

    InputStream getInputStream(final String filePath, final char[] password) throws IOException;
}
