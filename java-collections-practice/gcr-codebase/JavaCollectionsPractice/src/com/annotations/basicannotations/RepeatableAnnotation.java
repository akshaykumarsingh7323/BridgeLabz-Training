package com.annotations.basicannotations;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Repeatable;
import java.lang.reflect.Method;

public class RepeatableAnnotation {

    @Retention(RetentionPolicy.RUNTIME)
    @interface BugReports {
        BugReport[] value();
    }

    @Retention(RetentionPolicy.RUNTIME)
    @Repeatable(BugReports.class)
    @interface BugReport {
        String description();
    }

    static class Software {

        @BugReport(description = "NullPointerException issue")
        @BugReport(description = "Performance issue on large input")
        void process() {
            System.out.println("Processing...");
        }
    }

    public static void main(String[] args) throws Exception {

        Method method = Software.class.getDeclaredMethod("process");

        BugReport[] reports = method.getAnnotationsByType(BugReport.class);

        for (BugReport report : reports) {
            System.out.println("Bug: " + report.description());
        }
    }
}

