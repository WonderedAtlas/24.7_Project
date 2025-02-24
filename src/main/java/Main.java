import comparators.UnitedComparator;
import comparators.studentComparators.IStudentComparator;
import comparators.universityComporators.IUniversityComparator;
import enums.EStudentMethodComporator;
import enums.EUniversityMethodComparator;
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
        universities.stream()
                .sorted(universityComparator)
                .forEach(System.out::println);

        List<Student> students =
                xlsx.readXlsStudents("src/main/resources/universityInfo.xlsx");
        IStudentComparator studentComparator =
                UnitedComparator.getStudentComparator(EStudentMethodComporator.StudentCurrentCourseNumberComparator);
        students.stream()
                .sorted(studentComparator)
                .forEach(System.out::println);
    }
}