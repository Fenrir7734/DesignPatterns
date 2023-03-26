package com.fenrir.example02.generator.strategy;

import com.fenrir.example02.generator.model.DataModel;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.OutputStream;

class PdfGeneratorStrategy implements GeneratorStrategy {

    @Override
    public void generate(DataModel model, OutputStream outputStream) throws Exception {
        Document document = new Document();
        try {
            PdfWriter.getInstance(document, outputStream);
            document.open();

            writeDocumentContent(model, document);
        } finally {
            document.close();
        }
    }

    private void writeDocumentContent(DataModel model, Document document) throws DocumentException {
        Font headerFont = FontFactory.getFont(FontFactory.COURIER, 16, BaseColor.BLACK);
        Chunk chunk = new Chunk(model.getHeader(), headerFont);
        document.add(chunk);
    }

    @Override
    public String extension() {
        return "pdf";
    }
}
