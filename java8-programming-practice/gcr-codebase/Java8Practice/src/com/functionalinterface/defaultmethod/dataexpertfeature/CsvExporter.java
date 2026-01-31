package com.functionalinterface.defaultmethod.dataexpertfeature;

class CsvExporter implements DataExporter {

    @Override
    public void export() {
        System.out.println("Exporting data to CSV file");
    }
}
