package com.goit.gojavaonline.compare_collections.module1.controllers;


import java.io.IOException;

public class TimeCheckerApp {
    public static void main(String[] args) throws IOException {
        TimeCheckerAdvanced checkerAdvanced = new TimeCheckerAdvanced();
        checkerAdvanced.analyseCollections();
        CollectionPrintTable collectionPrintTable = new CollectionPrintTable();
        collectionPrintTable.writeTableToFile("TimeCheckersTable.txt");

    }
}
