package com.coderepocleaner;

import java.io.File;
import java.nio.file.*;
import java.util.*;

public class FileOrganizer {

    public static Map<FileType, List<File>> categorizeFiles(
            List<Path> paths, FileAnalyzer analyzer) throws Exception {

        Map<FileType, List<File>> map = new HashMap<>();

        for (Path path : paths) {
            File file = path.toFile();
            FileType type = analyzer.analyze(file);

            map.computeIfAbsent(type, k -> new ArrayList<>())
               .add(file);
        }
        return map;
    }

    public static void moveFiles(
            Map<FileType, List<File>> map, String baseDir) throws Exception {

        for (FileType type : map.keySet()) {

            Path targetDir =
                    Paths.get(baseDir, type.name());

            Files.createDirectories(targetDir);

            for (File file : map.get(type)) {
                Files.move(
                        file.toPath(),
                        targetDir.resolve(file.getName()),
                        StandardCopyOption.REPLACE_EXISTING
                );
            }
        }
    }
}
