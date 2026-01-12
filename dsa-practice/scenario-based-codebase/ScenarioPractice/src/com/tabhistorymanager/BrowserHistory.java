package com.tabhistorymanager;

import java.util.Stack;

public class BrowserHistory {

    private WebPage currentPage;
    private Stack<WebPage> closedTabs;

    public BrowserHistory() {
        closedTabs = new Stack<>();
    }
    	
    public void visitPage(String url) {
        WebPage newPage = new WebPage(url);

        if (currentPage != null) {
            currentPage.next = newPage;
            newPage.previous = currentPage;
        }
        currentPage = newPage;

        System.out.println("Visited: " + url);
    }

    public void goBack() {
        if (currentPage != null && currentPage.previous != null) {
            currentPage = currentPage.previous;
            System.out.println("Back to: " + currentPage.url);
        } else {
            System.out.println("No previous page");
        }
    }

    public void goForward() {
        if (currentPage != null && currentPage.next != null) {
            currentPage = currentPage.next;
            System.out.println("Forward to: " + currentPage.url);
        } else {
            System.out.println("No next page");
        }
    }

    public void closeCurrentTab() {
        if (currentPage != null) {
            closedTabs.push(currentPage);
            System.out.println("Closed tab: " + currentPage.url);
            currentPage = currentPage.previous;
        }
    }

    public void restoreClosedTab() {
        if (!closedTabs.isEmpty()) {
            currentPage = closedTabs.pop();
            System.out.println("Restored tab: " + currentPage.url);
        } else {
            System.out.println("No closed tabs to restore");
        }
    }
}
