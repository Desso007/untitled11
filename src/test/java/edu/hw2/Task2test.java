package edu.hw2;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class Task2test {
    @Test
    public void testRectangleArea() {
        Rectangle rectangle = new Rectangle();
        rectangle = rectangle.setWidth(20).setHeight(10);
        assertEquals(rectangle.area(), 200.0, 0.01);
    }

    @Test
    public void testSquareArea() {
        Rectangle square = new Square();
        square = square.setWidth(20).setHeight(20);
        assertEquals(square.area(), 400.0, 0.01);
    }
}

