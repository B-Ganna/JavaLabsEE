package com.goit.gojavaonline.compare_collections.module1.model;


public class Parallelepiped extends Rectangle implements Shape3D {
    private double height;
    final String NAME = "Parallelepiped";

    public Parallelepiped(double sideA, double sideB, double height) {
        super(sideA, sideB);
        this.height = height;
    }

    @Override
    public double getVolume() {
        return sideA * sideB * height;
    }

    @Override
    public double getSurface() {
        return (2 * sideA * sideB) + (2 * sideA * height) + (2 * sideB * height);
    }

    @Override
    public double getPerim() {
        return super.getPerim();
    }

    @Override
    public double getSquare() {
        return super.getSquare();
    }
}
