package com.regex.extractionproblem;

import java.util.regex.*;

public class ExtractLink {
    public static void main(String[] args) {
        String text = "Visit https://www.google.com and http://example.org for more info.";

        Pattern p = Pattern.compile("https?://[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}");
        Matcher m = p.matcher(text);

        while (m.find()) {
            System.out.println(m.group());
        }
    }
}

