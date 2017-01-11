package com.goit.gojavaonline.compare_collections.module1.model;


import static java.lang.Math.sqrt;

public class Triangle extends Base {
    private double sideB;
    private double sideC;

    public Triangle(double sideA, double sideB, double sideC) {
        super(sideA);
        this.sideB = sideB;
        this.sideC = sideC;
    }

    @Override
    public double getPerim() {
        return sideA + sideB + sideC;
    }

    @Override
    public double getSquare() {
        return sqrt((getPerim() / 2 - sideA) * (getPerim() / 2 - sideB) * (getPerim() / 2 - sideC));
    }
}
