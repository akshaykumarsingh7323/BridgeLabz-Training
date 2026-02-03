package com.coderepocleaner;

import java.io.File;
import java.nio.file.Files;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FileAnalyzer {

    // Regex rules
    private static final String INVALID_METHOD_REGEX =
            "\\b[A-Z][a-zA-Z0-9]*\\s*\\(";

    private static final String IMPORT_REGEX =
            "import\\s+([\\w\\.]+);";

    public FileType analyze(File file) throws Exception {

        String content = Files.readString(file.toPath());

        boolean invalidMethod = false;
        boolean unusedImport = false;

        Matcher methodMatcher =
                Pattern.compile(INVALID_METHOD_REGEX).matcher(content);

        if (methodMatcher.find()) {
            invalidMethod = true;
        }

        Matcher importMatcher =
                Pattern.compile(IMPORT_REGEX).matcher(content);

        while (importMatcher.find()) {
            String fullImport = importMatcher.group(1);
            String className =
                    fullImport.substring(fullImport.lastIndexOf('.') + 1);

            if (!content.contains(className)) {
                unusedImport = true;
            }
        }

        if (invalidMethod) return FileType.ERROR;
        if (unusedImport) return FileType.WARNING;
        return FileType.VALID;
    }
}

