package com.smartsurvayanalizer;


public class Feedback<T> {

    private T type;          
    private String message;
    private Integer rating; 

    public Feedback(T type, String message, Integer rating) {
        this.type = type;
        this.message = message;
        this.rating = rating;
    }

    public Integer getRating() {
        return rating;
    }

    public String getMessage() {
        return message;
    }

    public T getType() {
        return type;
    }

    @Override
    public String toString() {
        return "[" + type + "] " + message + " (Rating: " + rating + ")";
    }
}
