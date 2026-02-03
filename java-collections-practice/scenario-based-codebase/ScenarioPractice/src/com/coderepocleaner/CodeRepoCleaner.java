package com.coderepocleaner;

import java.nio.file.Path;
import java.util.List;
import java.util.Map;
import java.io.File;

public class CodeRepoCleaner {

    public static void main(String[] args) {

        String rootDir = "D:/JavaRepo";   // input folder

        try {
            List<Path> javaFiles =
                    FileScanner.scanJavaFiles(rootDir);

            FileAnalyzer analyzer = new FileAnalyzer();

            Map<FileType, List<File>> categorizedFiles =
                    FileOrganizer.categorizeFiles(javaFiles, analyzer);

            FileOrganizer.moveFiles(categorizedFiles, rootDir);

            categorizedFiles.forEach((k, v) ->
                    System.out.println(k + " files: " + v.size())
            );

        } catch (Exception e) {
            System.out.println("No Such File!");
        }
    }
}
