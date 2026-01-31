package com.functionalinterface.defaultmethod.dataexpertfeature;

class PdfExporter implements DataExporter {

    @Override
    public void export() {
        System.out.println("Exporting data to PDF file");
    }
}
