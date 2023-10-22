package edu.hw2;

public class Task1 {
    public static void main(String[] args) {
        var two = new Constant(2);
        var four = new Constant(4);
        var negOne = new Negate(new Constant(1));
        var sumTwoFour = new Addition(two, four);
        var mult = new Multiplication(sumTwoFour, negOne);
        var exp = new Exponent(mult, 2);
        var res = new Addition(exp, new Constant(1));

        System.out.println(res + " = " + res.evaluate());
    }
}

sealed interface Expr {
    double evaluate();
}

record Constant(double value) implements Expr {
    @Override
    public double evaluate() {
        return value;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }
}

record Negate(Expr expression) implements Expr {
    @Override
    public double evaluate() {
        return -expression.evaluate();
    }

    @Override
    public String toString() {
        return "(-" + expression + ")";
    }
}

record Exponent(Expr base, int exponent) implements Expr {
    @Override
    public double evaluate() {
        return Math.pow(base.evaluate(), exponent);
    }

    @Override
    public String toString() {
        return "(" + base + "^" + exponent + ")";
    }
}

record Addition(Expr left, Expr right) implements Expr {
    @Override
    public double evaluate() {
        return left.evaluate() + right.evaluate();
    }

    @Override
    public String toString() {
        return "(" + left + " + " + right + ")";
    }
}

record Multiplication(Expr left, Expr right) implements Expr {
    @Override
    public double evaluate() {
        return left.evaluate() * right.evaluate();
    }

    @Override
    public String toString() {
        return "(" + left + " * " + right + ")";
    }
}
