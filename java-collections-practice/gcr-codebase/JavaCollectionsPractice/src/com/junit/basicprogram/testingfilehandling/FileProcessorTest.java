package com.junit.basicprogram.testingfilehandling;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileProcessorTest {

    FileProcessor processor = new FileProcessor();
    String filename = "testfile.txt";

    @AfterEach
    void cleanUp() throws IOException {
        Files.deleteIfExists(Path.of(filename));
    }

    @Test
    void testWriteAndReadFile() throws IOException {
        String content = "Hello JUnit File Test";

        processor.writeToFile(filename, content);
        String result = processor.readFromFile(filename);

        assertEquals(content, result);
    }

    @Test
    void testFileExistsAfterWrite() throws IOException {
        processor.writeToFile(filename, "Test Content");

        assertTrue(Files.exists(Path.of(filename)));
    }

    @Test
    void testReadFileDoesNotExist() {
        assertThrows(IOException.class, () -> {
            processor.readFromFile("nofile.txt");
        });
    }
}
