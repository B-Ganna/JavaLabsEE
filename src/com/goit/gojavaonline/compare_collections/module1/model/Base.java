package com.goit.gojavaonline.compare_collections.module1.model;


public abstract class Base {
    protected double sideA; // одна из сторон - основание

    public Base(double sideA) {
        this.sideA = sideA;
    }

    public abstract double getPerim();
    public abstract double getSquare();


    public void setSideA(double sideA) {
        this.sideA = sideA;
    }
}
