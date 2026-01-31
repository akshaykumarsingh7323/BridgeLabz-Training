package com.functionalinterface.defaultmethod.dataexpertfeature;

interface DataExporter {

    void export();   

    default void exportToJSON() {
        System.out.println("Exporting data in JSON format (default)");
    }
}
