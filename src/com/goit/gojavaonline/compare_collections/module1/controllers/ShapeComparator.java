package com.goit.gojavaonline.compare_collections.module1.controllers;


import com.goit.gojavaonline.compare_collections.module1.model.Shape3D;

import java.util.Comparator;

public class ShapeComparator implements Comparator<Shape3D> {
    @Override
    public int compare(Shape3D shape1, Shape3D shape2) {
        return Double.compare(shape1.getVolume(), shape2.getVolume());
    }
}
