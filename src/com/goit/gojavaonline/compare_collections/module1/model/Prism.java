package com.goit.gojavaonline.compare_collections.module1.model;


public class Prism extends Triangle implements Shape3D {
    private double height;
    final String NAME = "Prism";

    public Prism(double sideA, double sideB, double sideC, double height) {
        super(sideA, sideB, sideC);
        this.height = height;
    }

    @Override
    public double getVolume() {
        return (height * getSquare()) / 3;
    }

    @Override
    public double getSurface() {
        return (2 * getSquare()) + getPerim() * height;
    }
}
