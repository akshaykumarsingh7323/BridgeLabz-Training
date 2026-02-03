package com.coderepocleaner;

import java.io.IOException;
import java.nio.file.*;
import java.util.List;
import java.util.stream.Collectors;

public class FileScanner {

    public static List<Path> scanJavaFiles(String rootDir) throws IOException {

        return Files.walk(Paths.get(rootDir))
                .filter(path -> path.toString().endsWith(".java"))
                .collect(Collectors.toList());
    }
}
