package com.resumeanalyzer;

import java.util.*;

public class UseResume {

    public static void main(String[] args) {

        String folderPath = "resumes"; 

        Map<String, ResumeData> resumeMap =
                ResumeAnalyzer.analyzeFolder(folderPath);

        List<ResumeData> sortedCandidates =
                ResumeAnalyzer.sortByKeywordCount(resumeMap);

        System.out.println("\nCandidates Sorted by Skill Match:");
        sortedCandidates.forEach(System.out::println);
    }
}
