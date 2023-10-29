package edu.hw2;

public class Task2 {
    public static void main(String[] args) {
        Rectangle rectangle = new Rectangle();
        rectangle.setWidth(20).setHeight(10);
        System.out.println("Rectangle Area: " + rectangle.area());

        Square square = new Square();
        square.setSide(20);
        System.out.println("Square Area: " + square.area());
    }
}

class Rectangle {
    private int width;
    private int height;

    public Rectangle() {
        this.width = 0;
        this.height = 0;
    }

    public Rectangle(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public double area() {
        return width * height;
    }

    public Rectangle setWidth(int width) {
        this.width = width;
        return this;
    }

    public Rectangle setHeight(int height) {
        this.height = height;
        return this;
    }
}

final class Square extends Rectangle {
    public Square() {
    }

    public Square setSide(int side) {
        super.setWidth(side);
        super.setHeight(side);
        return this;
    }

    @Override
    public Square setWidth(int width) {
        return this;
    }

    @Override
    public Square setHeight(int height) {
        return this;
    }
}
