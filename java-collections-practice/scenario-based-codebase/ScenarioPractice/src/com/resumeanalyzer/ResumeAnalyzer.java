package com.resumeanalyzer;

import java.io.*;
import java.util.*;
import java.util.regex.*;

public class ResumeAnalyzer {

    private static final Pattern EMAIL_PATTERN =
            Pattern.compile("[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}");

    private static final Pattern PHONE_PATTERN =
            Pattern.compile("\\b\\d{10}\\b");

    private static final Pattern KEYWORD_PATTERN =
            Pattern.compile("\\b(Java|Python|Spring)\\b", Pattern.CASE_INSENSITIVE);

    public static Map<String, ResumeData> analyzeFolder(String folderPath) {

        Map<String, ResumeData> resumeMap = new HashMap<>();

        File folder = new File(folderPath);
        File[] files = folder.listFiles();

        if (files == null) return resumeMap;

        for (File file : files) {
            try {
                if (!file.getName().endsWith(".txt")) {
                    throw new UnsupportedOperationException("Invalid resume format");
                }

                String content = readFile(file);

                String email = extract(EMAIL_PATTERN, content);
                String phone = extract(PHONE_PATTERN, content);

                if (email == null)
                    throw new IllegalArgumentException("Email not found");

                int keywordCount = countKeywords(content);

                resumeMap.put(email,
                        new ResumeData(email, phone, keywordCount));

            } catch (Exception e) {
                System.out.println("Skipping " + file.getName()
                        + " → " + e.getMessage());
            }
        }
        return resumeMap;
    }

    private static String readFile(File file) throws IOException {
        StringBuilder sb = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null)
                sb.append(line).append(" ");
        }
        return sb.toString();
    }

    private static String extract(Pattern pattern, String content) {
        Matcher matcher = pattern.matcher(content);
        return matcher.find() ? matcher.group() : null;
    }

    private static int countKeywords(String content) {
        Matcher matcher = KEYWORD_PATTERN.matcher(content);
        int count = 0;
        while (matcher.find())
            count++;
        return count;
    }

    public static List<ResumeData> sortByKeywordCount(
            Map<String, ResumeData> map) {

        List<ResumeData> list = new ArrayList<>(map.values());

        list.sort((a, b) -> Integer.compare(
                b.keywordCount, a.keywordCount));

        return list;
    }
}
