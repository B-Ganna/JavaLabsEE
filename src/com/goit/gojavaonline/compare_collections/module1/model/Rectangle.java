package com.goit.gojavaonline.compare_collections.module1.model;


public class Rectangle extends Base {
    protected double sideB;

    public Rectangle(double sideA, double sideB) {
        super(sideA);
        this.sideB = sideB;
    }

    @Override
    public double getPerim() {
        return 2 * (sideA + sideB);
    }

    @Override
    public double getSquare() {
        return sideA * sideB;
    }
}
