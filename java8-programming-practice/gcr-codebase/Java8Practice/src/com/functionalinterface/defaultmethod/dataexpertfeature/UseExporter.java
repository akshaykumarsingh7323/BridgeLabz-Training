package com.functionalinterface.defaultmethod.dataexpertfeature;

public class UseExporter {

    public static void main(String[] args) {

        DataExporter csv = new CsvExporter();
        DataExporter pdf = new PdfExporter();
        DataExporter json = new JsonExporter();

        csv.export();
        csv.exportToJSON(); 

        pdf.export();
        pdf.exportToJSON();  

        json.export();
        json.exportToJSON(); 
    }
}
