import comparators.UnitedComparator;
import comparators.studentComparators.IStudentComparator;
import comparators.universityComporators.IUniversityComparator;
import enums.EStudentMethodComporator;
import enums.EUniversityMethodComparator;
import models.Statistics;
import models.Student;
import models.University;

import java.io.IOException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        List<University> universities =
                xlsx.readXlsUniversities("src/main/resources/universityInfo.xlsx");
        IUniversityComparator universityComparator =
                UnitedComparator.getUniversityComparator(EUniversityMethodComparator.UniversityYearOfFoundationComparator);
        universities.sort(universityComparator);

        System.out.println("\nСериализация коллекции Universities:\n");
        String jsonUniversities = JsonUtil.universityListToJson(universities);
        System.out.println(jsonUniversities);
        System.out.println("\nДесериализация полученных строк в коллекции Universities:\n");
        List<University> universitiesListFromJson = JsonUtil.jsonToUniversityList(jsonUniversities);
        universitiesListFromJson.forEach(System.out::println);
        System.out.println("\nСравнение количества элементов в исходной и в десериализованной коллекциях:");
        System.out.println(universities.size() == universitiesListFromJson.size());
        System.out.println("\nСериализация/десериализация отдельных элементов коллекции Universities:\n");
        universities.forEach(university -> {
            String universityJson = JsonUtil.universityToJson(university);
            System.out.println(universityJson);
            University universityFromJson = JsonUtil.jsonToUniversity(universityJson);
            System.out.println(universityFromJson);
        });

        List<Student> students =
                xlsx.readXlsStudents("src/main/resources/universityInfo.xlsx");
        IStudentComparator studentComparator =
                UnitedComparator.getStudentComparator(EStudentMethodComporator.StudentCurrentCourseNumberComparator);
        students.sort(studentComparator);

        System.out.println("\nСериализация коллекции Students:\n");
        String jsonStudents = JsonUtil.studentListToJson(students);
        System.out.println(jsonStudents);
        System.out.println("\nДесериализация полученных строк в коллекции Students:\n");
        List<Student> studentsListFromJson = JsonUtil.jsonToStudentList(jsonStudents);
        studentsListFromJson.forEach(System.out::println);
        System.out.println("\nСравнение количества элементов в исходной и в десериализованной коллекциях:");
        System.out.println(students.size() == studentsListFromJson.size());
        System.out.println("\nСериализация/десериализация отдельных элементов коллекции Students:\n");
        students.forEach(student -> {
            String studentJason = JsonUtil.studentToJson(student);
            System.out.println(studentJason);
            Student studentFromJason = JsonUtil.jsonToStudent(studentJason);
            System.out.println(studentFromJason);
        });

        List<Statistics> statisticsList = StatisticsUtil.createStatistics(students, universities);
        XlsWriter.createFile(statisticsList, "statistics.xlsx");
    }
}
