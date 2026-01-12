package com.tabhistorymanager;

public class WebPage {
    String url;
    WebPage previous;
    WebPage next;

    public WebPage(String url) {
        this.url = url;
        this.previous = null;
        this.next = null;
    }
}
