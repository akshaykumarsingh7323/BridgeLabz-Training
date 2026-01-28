package com.bagnball;

import java.util.ArrayList;
import java.util.List;

public class Bag implements Storable {

    private String bagId;
    private String color;
    private int capacity;

    private List<Ball> balls;

    public Bag(String bagId, String color, int capacity) {
        this.bagId = bagId;
        this.color = color;
        this.capacity = capacity;
        this.balls = new ArrayList<>();
    }

    public String getBagId() {
        return bagId;
    }

    public int getBallCount() {
        return balls.size();
    }

    public void addBall(Ball ball) {
        if (balls.size() >= capacity) {
            System.out.println("Bag is full! Cannot add ball.");
            return;
        }
        balls.add(ball);
        System.out.println("Ball added to bag " + bagId);
    }

    public void removeBall(String ballId) {
        for (Ball b : balls) {
            if (b.getId().equals(ballId)) {
                balls.remove(b);
                System.out.println("Ball removed from bag");
                return;
            }
        }
        System.out.println("Ball not found");
    }

    public void displayBalls() {
        if (balls.isEmpty()) {
            System.out.println("Bag is empty");
            return;
        }
        for (Ball b : balls) {
            b.displayInfo();
        }
    }

    @Override
    public void displayInfo() {
        System.out.println("Bag ID: " + bagId +
                ", Color: " + color +
                ", Capacity: " + capacity +
                ", Balls: " + balls.size());
    }
}
