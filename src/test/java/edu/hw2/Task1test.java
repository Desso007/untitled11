package edu.hw2;

import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class Task1test {

    @Test
    public void testConstant() {
        Expr constant = new Constant(5);
        assertEquals(5, constant.evaluate(), 0.01);
    }

    @Test
    public void testNegate() {
        Expr expression = new Negate(new Constant(3));
        assertEquals(-3, expression.evaluate(), 0.01);
    }

    @Test
    public void testExponent() {
        Expr expression = new Exponent(new Constant(2), 3);
        assertEquals(8, expression.evaluate(), 0.01);
    }

    @Test
    public void testAddition() {
        Expr expression = new Addition(new Constant(3), new Constant(7));
        assertEquals(10, expression.evaluate(), 0.01);
    }

    @Test
    public void testMultiplication() {
        Expr expression = new Multiplication(new Constant(4), new Constant(6));
        assertEquals(24, expression.evaluate(), 0.01);
    }

}
