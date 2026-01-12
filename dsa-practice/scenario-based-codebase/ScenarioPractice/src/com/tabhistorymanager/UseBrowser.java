package com.tabhistorymanager;

public class UseBrowser{
    public static void main(String[] args) {

        BrowserHistory history = new BrowserHistory();

        history.visitPage("google.com");
        history.visitPage("youtube.com");
        history.visitPage("github.com");

        history.goBack();
        history.goForward();

        history.closeCurrentTab();
        history.restoreClosedTab();
    }
}
