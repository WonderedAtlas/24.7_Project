package io;

import models.Statistics;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.logging.Logger;


public class XlsWriter {

    static Logger logger = Logger.getLogger(XlsWriter.class.getName());

    public static void createFile(List<Statistics> statistics, String filePath) {
        XSSFWorkbook workbook = new XSSFWorkbook();
        CellStyle style = workbook.createCellStyle();
        Font font = workbook.createFont();
        font.setFontName("Times New Roman");
        font.setFontHeightInPoints((short) 14);
        font.setBold(true);
        style.setFont(font);
        Sheet sheet = workbook.createSheet("Статистика");
        Row headerRow = sheet.createRow(0);
        Cell cell1 = headerRow.createCell(0);
        cell1.setCellValue("Профиль обучения");
        Cell cell2 = headerRow.createCell(1);
        cell2.setCellValue("Средний балл за экзамен");
        Cell cell3 = headerRow.createCell(2);
        cell3.setCellValue("Количество студентов по профилю");
        Cell cell4 = headerRow.createCell(3);
        cell4.setCellValue("Количество университетов по профилю");
        Cell cell5 = headerRow.createCell(4);
        cell5.setCellValue("Названия университетов");
        List<Cell> cellList = new ArrayList<>();
        Collections.addAll(cellList, cell1, cell2, cell3, cell4, cell5);
        for (Cell cell : cellList) {
            cell.setCellStyle(style);
        }


        int rowNum = 1;
        for (Statistics statistic : statistics) {
            Row row = sheet.createRow(rowNum++);
            for (int i = 0; i < 5; i++) {
                if (i == 0) {
                    Cell cell = row.createCell(i);
                    cell.setCellValue((statistic.getProfile().getProfileName()));
                }
                if (i == 1) {
                    Cell cell = row.createCell(i);
                    cell.setCellValue(statistic.getAvgExamScore());
                }
                if (i == 2) {
                    Cell cell = row.createCell(i);
                    cell.setCellValue(statistic.getNumberOfStudents());
                }
                if (i == 3) {
                    Cell cell = row.createCell(i);
                    cell.setCellValue(statistic.getNumberOfUniversities());
                }
                if (i == 4) {
                    Cell cell = row.createCell(i);
                    cell.setCellValue(statistic.getUniversityNames());
                }
            }
        }

        try (FileOutputStream fileOut = new FileOutputStream(filePath)) {

            workbook.write(fileOut);
            logger.info("Файл создан: " + filePath);

        } catch (FileNotFoundException e) {
            logger.severe("Не удаётся создать файл " + filePath + " " + e);
        } catch (IOException e) {
            logger.severe("Ошибка работы с файлом " + filePath + " " + e);
        }
        logger.info("Запись в excel-файл успешно завершена");

    }
}
