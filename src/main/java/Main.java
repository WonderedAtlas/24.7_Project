import comparators.UnitedComparator;
import comparators.studentComparators.IStudentComparator;
import comparators.universityComporators.IUniversityComparator;
import enums.EStudentMethodComporator;
import enums.EUniversityMethodComparator;
import io.JsonWriter;
import io.XlsReader;
import io.XlsWriter;
import io.XmlWriter;
import models.FullInfo;
import models.Statistics;
import models.Student;
import models.University;
import util.StatisticsUtil;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public class Main {
    public static void main(String[] args){


        Logger logger = Logger.getLogger(Main.class.getName());

        try {
            LogManager.getLogManager().readConfiguration(
                    Main.class.getResourceAsStream("/logging.properties"));
        } catch (IOException e) {
            System.err.println("Could not setup logger configuration: " + e.toString());
        }

        logger.log(Level.INFO, "Начало работы программы");


        List<University> universities =
                XlsReader.readXlsUniversities("src/main/resources/universityInfo.xlsx");
        IUniversityComparator universityComparator =
                UnitedComparator.getUniversityComparator(EUniversityMethodComparator.UniversityYearOfFoundationComparator);
        universities.sort(universityComparator);


        List<Student> students =
                io.XlsReader.readXlsStudents("src/main/resources/universityInfo.xlsx");
        IStudentComparator studentComparator =
                UnitedComparator.getStudentComparator(EStudentMethodComporator.StudentCurrentCourseNumberComparator);
        students.sort(studentComparator);

        List<Statistics> statisticsList = StatisticsUtil.createStatistics(students, universities);
        XlsWriter.createFile(statisticsList, "statistics.xlsx");

        FullInfo fullInfo = new FullInfo()
                .setStudentList(students)
                .setUniversityList(universities)
                .setStatisticsList(statisticsList)
                .setProcessDate(new Date());

        XmlWriter.generateXmlReq(fullInfo);
        JsonWriter.writeJsonReq(fullInfo);

        logger.info("Программа завершена");
    }
}
