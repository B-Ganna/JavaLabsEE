package com.goit.gojavaonline.compare_collections.module1.model;

import static java.lang.Math.pow;

public class Pyramid extends Triangle implements Shape3D {
    private double height;
    final String NAME = "Pyramid";

    public Pyramid(double sideA, double sideB, double sideC, double height) {
        super(sideA, sideB, sideC);
        this.height = height;
    }

    @Override
    public double getVolume() {
        return (pow(sideA, 2) * height) / 3;
    }

    @Override
    public double getSurface() {
        return getSquare() * 4 + pow(sideA, 2);
    }
}
