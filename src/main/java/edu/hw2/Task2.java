package edu.hw2;

public class Task2 {
    public static void main(String[] args) {
        Rectangle rectangle = new Rectangle();
        rectangle.setWidth(20).setHeight(10);
        System.out.println(rectangle.area());

        Square square = new Square();
        square.setSide(20);
        System.out.println(square.area());
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

class Square {
    private int side;

    public Square() {
        this.side = 0;
    }

    public Square(int side) {
        this.side = side;
    }

    public int getSide() {
        return side;
    }

    public double area() {
        return side * side;
    }

    public Square setSide(int side) {
        this.side = side;
        return this;
    }
}
