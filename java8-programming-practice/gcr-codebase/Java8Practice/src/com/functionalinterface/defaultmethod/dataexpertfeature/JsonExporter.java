package com.functionalinterface.defaultmethod.dataexpertfeature;

class JsonExporter implements DataExporter {

    @Override
    public void export() {
        System.out.println("Exporting data to JSON file");
    }

    @Override
    public void exportToJSON() {
        System.out.println("Exporting data using advanced JSON formatter");
    }
}

