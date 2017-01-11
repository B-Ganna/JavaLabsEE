package com.goit.gojavaonline.compare_collections.module1.controllers;


import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Formatter;

public class CollectionPrintTable {


    public void writeTableToFile(String fileName) throws IOException {
        PrintWriter writer = new PrintWriter(new FileWriter(fileName));
        TimeCheckerAdvanced checkerAdvanced = new TimeCheckerAdvanced();
        checkerAdvanced.analyseCollections();
        double[][] dataResult = checkerAdvanced.getResultData();
        System.out.println(getColumns());
        writer.println(getColumns());
        System.out.println(getCollection("ArrayList", dataResult[2][3], dataResult[4][3], dataResult[6][3], dataResult[10][3], dataResult[14][3], dataResult[18][3], dataResult[20][3]));
        writer.println(getCollection("ArrayList", dataResult[2][3], dataResult[4][3], dataResult[6][3], dataResult[10][3], dataResult[14][3], dataResult[18][3], dataResult[20][3]));
        System.out.println(getCollection("LinkedList", dataResult[3][3], dataResult[5][3], dataResult[7][3], dataResult[11][3], dataResult[15][3], dataResult[19][3], dataResult[21][3]));
        writer.println(getCollection("LinkedList", dataResult[3][3], dataResult[5][3], dataResult[7][3], dataResult[11][3], dataResult[15][3], dataResult[19][3], dataResult[21][3]));
        System.out.println(getCollection("TreeSet", dataResult[0][3], -1.0, dataResult[8][3], dataResult[12][3], dataResult[16][3], -1.0, -1.0));
        writer.println(getCollection("TreeSet", dataResult[0][3], -1.0, dataResult[8][3], dataResult[12][3], dataResult[16][3], -1.0, -1.0));
        System.out.println(getCollection("HashSet", dataResult[1][3], -1.0, dataResult[9][3], dataResult[13][3], dataResult[17][3], -1.0, -1.0));
        writer.println(getCollection("HashSet", dataResult[1][3], -1.0, dataResult[9][3], dataResult[13][3], dataResult[17][3], -1.0, -1.0));
        writer.close();
    }


    private String getCollection(String nameCollection, double add, double get, double remove, double contains, double populate, double iteratorAdd, double iteratorRemove) {
        Formatter collectionFormatter = new Formatter();
        collectionFormatter.format("%25.20s", nameCollection);
        collectionFormatter.format("%20.0f", add);
        collectionFormatter.format("%20.0f", get);
        collectionFormatter.format("%20.0f", remove);
        collectionFormatter.format("%20.0f", contains);
        collectionFormatter.format("%20.0f", populate);
        collectionFormatter.format("%20.0f", iteratorAdd);
        collectionFormatter.format("%20.0f", iteratorRemove);

        return collectionFormatter.toString();
    }

    private String getColumns() {
        Formatter columns = new Formatter();
        columns.format("%25.20s", "Type of collection");
        columns.format("%20.15s", "add");
        columns.format("%20.15s", "get");
        columns.format("%20.15s", "remove");
        columns.format("%20.15s", "contains");
        columns.format("%20.15s", "populate");
        columns.format("%20.15s", "iterator.add");
        columns.format("%20.15s", "iterator.remove");
        return columns.toString();
    }

}
