package io;

import enums.StudyProfile;
import models.Student;
import models.University;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Logger;

public class XlsReader {

    private static final Logger logger = Logger.getLogger(XlsReader.class.getName());


    private XlsReader() {
    }

    public static List<Student> readXlsStudents(String filePath) {

        List<Student> students = new ArrayList<>();

        try (FileInputStream inputStream = new FileInputStream(filePath); XSSFWorkbook workbook = new XSSFWorkbook(inputStream)) {
            logger.info("Начало чтения из excel-файла");

            XSSFSheet sheet = workbook.getSheet("Студенты");
            Iterator<Row> rows = sheet.iterator();
            rows.next();

            while (rows.hasNext()) {
                Row currentRow = rows.next();
                Student student = new Student();
                students.add(student);
                student.setUniversityId(currentRow.getCell(0).getStringCellValue());
                student.setFullName(currentRow.getCell(1).getStringCellValue());
                student.setCurrentCourseNumber((int) currentRow.getCell(2).getNumericCellValue());
                student.setAvgExamScore((float) currentRow.getCell(3).getNumericCellValue());
            }

        } catch (FileNotFoundException e) {
            logger.severe("Файл " + filePath + " не найден " + e);
        } catch (IOException e) {
            logger.severe("Ошибка работы с файлом " + e);
        }
        logger.info("Чтение excel-файла успешно завершено");
        return students;
    }


    public static List<University> readXlsUniversities(String filePath) {

        List<University> universities = new ArrayList<>();

        try (FileInputStream inputStream = new FileInputStream(filePath); XSSFWorkbook workbook = new XSSFWorkbook(inputStream)) {
            logger.info("Начало чтения из excel-файла");
            XSSFSheet sheet = workbook.getSheet("Университеты");
            Iterator<Row> rows = sheet.iterator();
            rows.next();

            while (rows.hasNext()) {
                Row currentRow = rows.next();
                University university = new University();
                universities.add(university);
                university.setId(currentRow.getCell(0).getStringCellValue());
                university.setFullName(currentRow.getCell(1).getStringCellValue());
                university.setShortName(currentRow.getCell(2).getStringCellValue());
                university.setYearOfFoundation((int) currentRow.getCell(3).getNumericCellValue());
                university.setMainProfile(StudyProfile.valueOf(
                        StudyProfile.class, currentRow.getCell(4).getStringCellValue()));
            }

        } catch (FileNotFoundException e) {
            logger.severe("Файл " + filePath + " не найден " + e);
        } catch (IOException e) {
            logger.severe("Ошибка работы с файлом " + e);
        }
        logger.info("Чтение excel-файла успешно завершено");
        return universities;
    }
}


