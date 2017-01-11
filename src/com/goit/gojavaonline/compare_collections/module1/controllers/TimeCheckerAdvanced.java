package com.goit.gojavaonline.compare_collections.module1.controllers;


import com.goit.gojavaonline.compare_collections.module1.model.Parallelepiped;
import com.goit.gojavaonline.compare_collections.module1.model.Prism;
import com.goit.gojavaonline.compare_collections.module1.model.Pyramid;
import com.goit.gojavaonline.compare_collections.module1.model.Shape3D;

import java.util.*;

public class TimeCheckerAdvanced {
    List<Shape3D> arrListCollection = new ArrayList<>();
    List<Shape3D> linkListCollection = new LinkedList<>();
    Set<Shape3D> hashSetCollection = new HashSet<>();
    Set<Shape3D> treeSetCollection = new TreeSet<>(new ShapeComparator());
    final int[] SIZE = {1000_000, 100_000, 10_000};
    Random random = new Random();
    final double LOW_BOUND_OF_SIDE = 1;
    final double HIGH_BOUND_OF_SIDE = 20;
    final int COUNT_OF_SHAPE = 2;
    final int ITERATIONS = 100;
    final int COUNT_CHARACTERISTICS = 22;//4*2 characteristics for Set & 7*2 - for List
    private double[][] resultData = new double[COUNT_CHARACTERISTICS][SIZE.length + 1];

    public double[][] getResultData() {
        return resultData;
    }

    // additional - last column for average value


    //create a random shape (prism, parallelepiped or pyramid)
    private Shape3D getShape() {
        int typeOfShape;
        Shape3D shape = null;
        typeOfShape = random.nextInt(COUNT_OF_SHAPE);
        switch (typeOfShape) {
            case 0:
                shape = getPrism();
                break;
            case 1:
                shape = getParallelepiped();
                break;
            case 2:
                shape = getPyramid();
                break;
        }

        return shape;
    }

    //put size for a shape in determined bounds
    private double getRandomDouble() {
        return random.nextDouble() * (HIGH_BOUND_OF_SIDE - LOW_BOUND_OF_SIDE) + LOW_BOUND_OF_SIDE;
    }

    //create a new prism
    private Prism getPrism() {
        double sideA;
        double sideB;
        double sideC;
        double height;
        do {
            sideA = getRandomDouble();
            sideB = getRandomDouble();
            sideC = getRandomDouble();
        } while (sideA >= (sideB + sideC) || (sideB >= (sideA + sideC)) || (sideC >= (sideB + sideC)));
        height = getRandomDouble();

        return new Prism(sideA, sideB, sideC, height);
    }

    //create a new parallelepiped
    private Parallelepiped getParallelepiped() {
        double sideA;
        double sideB;
        double height;

        sideA = getRandomDouble();
        sideB = getRandomDouble();
        height = getRandomDouble();

        return new Parallelepiped(sideA, sideB, height);
    }

    //create a new pyramid
    private Pyramid getPyramid() {
        double sideA;
        double sideB;
        double sideC;
        double height;
        do {
            sideA = getRandomDouble();
            sideB = getRandomDouble();
            sideC = getRandomDouble();
        } while (sideA >= (sideB + sideC) || (sideB >= (sideA + sideC)) || (sideC >= (sideB + sideC)));
        height = getRandomDouble();

        return new Pyramid(sideA, sideB, sideC, height);
    }

    private void createCollection(Collection<Shape3D> col, int colSize) {
        col.clear();
        for (int i = 0; i < colSize; i++) {
            col.add(getShape());
        }
    }

    private void createCollections(int colSize) {
        createCollection(arrListCollection, colSize);
        createCollection(linkListCollection, colSize);
        createCollection(treeSetCollection, colSize);
        createCollection(hashSetCollection, colSize);
    }

    private long analyseInsertElements(Set<Shape3D> set) {
        long time = 0;
        for (int i = 0; i < ITERATIONS; i++) {
            Shape3D shape = getShape();
            long startTime = System.nanoTime();
            set.add(shape);
            long finishTime = System.nanoTime();
            time += finishTime - startTime;
        }
        return time / ITERATIONS;

    }

    private long analyseInsertElements(List<Shape3D> list, int index) {
        long time = 0;
        for (int i = 0; i < ITERATIONS; i++) {
            Shape3D shape = getShape();
            long startTime = System.nanoTime();
            list.add(index, shape);
            long finishTime = System.nanoTime();
            time += finishTime - startTime;
        }
        return time / ITERATIONS;
    }

    private long analyseGetElements(List<Shape3D> list, int index) {
        long time = 0;
        for (int i = 0; i < ITERATIONS; i++) {
            long startTime = System.nanoTime();
            Shape3D shape = list.get(index);
            long finishTime = System.nanoTime();
            time += finishTime - startTime;
        }
        return time / ITERATIONS;
    }

    private long analyseRemoveElementsByIndex(List<Shape3D> list, int index) {
        long time = 0;
        for (int i = 0; i < ITERATIONS; i++) {
            long startTime = System.nanoTime();
            list.remove(index);
            long finishTime = System.nanoTime();
            time += finishTime - startTime;
        }
        return time / ITERATIONS;
    }

    private long analyseRemoveElementsByValue(Set<Shape3D> set) {
        long time = 0;
        for (int i = 0; i < ITERATIONS; i++) {
            long startTime = System.nanoTime();
            set.remove(getShape());
            long finishTime = System.nanoTime();
            time += finishTime - startTime;
        }
        return time / ITERATIONS;
    }

    private long analyseContainsElements(Collection<Shape3D> col) {
        long time = 0;
        for (int i = 0; i < ITERATIONS; i++) {
            long startTime = System.nanoTime();
            col.contains(getShape());
            long finishTime = System.nanoTime();
            time += finishTime - startTime;
        }
        return time / ITERATIONS;
    }

    private long analysePopulateElements(Collection<Shape3D> col) {
        long time = 0;
        long startTime = System.nanoTime();
        for (int i = 0; i < ITERATIONS; i++) {
            col.add(getShape());
        }
        long finishTime = System.nanoTime();
        time += finishTime - startTime;
        return time;
    }

    private long analyseAddListIterator(List<Shape3D> list) {
        long time = 0;
        for (int i = 0; i < ITERATIONS; i++) {
            long startTime = System.nanoTime();
            Iterator<Shape3D> listIterator = list.listIterator();
            long finishTime = System.nanoTime();
            time += finishTime - startTime;
        }
        return time / ITERATIONS;
    }

    private long analyseRemoveListIterator(List<Shape3D> list) {
        long time = 0;
        for (int i = 0; i < ITERATIONS; i++) {
            Iterator<Shape3D> listIterator = list.listIterator();
            long startTime = System.nanoTime();
            listIterator.next();
            listIterator.remove();
            long finishTime = System.nanoTime();
            time += finishTime - startTime;
        }
        return time / ITERATIONS;
    }

    public void analyseCollections() {
        for (int i = 0; i < SIZE.length; i++) {
            createCollections(SIZE[i]);
            resultData[0][i] = analyseInsertElements(treeSetCollection);
            resultData[1][i] = analyseInsertElements(hashSetCollection);
            int index = random.nextInt(SIZE[i] - 1);
            resultData[2][i] = analyseInsertElements(arrListCollection, index);
            resultData[3][i] = analyseInsertElements(linkListCollection, index);
            resultData[4][i] = analyseGetElements(arrListCollection, index);
            resultData[5][i] = analyseGetElements(linkListCollection, index);
            resultData[6][i] = analyseRemoveElementsByIndex(arrListCollection, index);
            resultData[7][i] = analyseRemoveElementsByIndex(linkListCollection, index);
            resultData[8][i] = analyseRemoveElementsByValue(treeSetCollection);
            resultData[9][i] = analyseRemoveElementsByValue(hashSetCollection);
            resultData[10][i] = analyseContainsElements(arrListCollection);
            resultData[11][i] = analyseContainsElements(linkListCollection);
            resultData[12][i] = analyseContainsElements(treeSetCollection);
            resultData[13][i] = analyseContainsElements(hashSetCollection);
            resultData[14][i] = analysePopulateElements(arrListCollection);
            resultData[15][i] = analysePopulateElements(linkListCollection);
            resultData[16][i] = analysePopulateElements(treeSetCollection);
            resultData[17][i] = analysePopulateElements(hashSetCollection);
            resultData[18][i] = analyseAddListIterator(arrListCollection);
            resultData[19][i] = analyseAddListIterator(linkListCollection);
            resultData[20][i] = analyseRemoveListIterator(arrListCollection);
            resultData[21][i] = analyseRemoveListIterator(linkListCollection);
        }
        for (int i = 0; i < resultData.length; i++) {
            resultData[i][3] = (resultData[i][0] + resultData[i][0] + resultData[i][2]) / SIZE.length;
        }

    }
}
