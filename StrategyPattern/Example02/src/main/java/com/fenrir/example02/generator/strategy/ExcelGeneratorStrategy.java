package com.fenrir.example02.generator.strategy;

import com.fenrir.example02.generator.model.DataModel;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.OutputStream;

class ExcelGeneratorStrategy implements GeneratorStrategy {

    @Override
    public void generate(DataModel model, OutputStream outputStream) throws Exception {
        try (Workbook workbook = new XSSFWorkbook()) {
            writeDocumentContent(workbook, model);
            workbook.write(outputStream);
        }
    }

    private void writeDocumentContent(Workbook workbook, DataModel model) {
        Sheet sheet = workbook.createSheet(model.getHeader());
        sheet.createRow(0).createCell(0).setCellValue(model.getHeader());
    }

    @Override
    public String extension() {
        return "xlsx";
    }
}
