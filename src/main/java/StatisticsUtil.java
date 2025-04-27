import enums.StudyProfile;
import models.Statistics;
import models.Student;
import models.University;
import org.apache.commons.lang3.StringUtils;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.OptionalDouble;
import java.util.Set;
import java.util.stream.Collectors;

public class StatisticsUtil {

    public static List<Statistics> createStatistics(List<Student> students, List<University> universities) {
        List<Statistics> statisticsList = new ArrayList<>();
        Set<StudyProfile> profiles = universities.stream()
                .map(University::getMainProfile)
                .collect(Collectors.toSet());

        profiles.forEach(profile -> { //Для каждого элемента коллекции profiles
            Statistics statistics = new Statistics(); //создаём новый объект класса Statistics
            statisticsList.add(statistics); //добавляем этот элемент в statisticsList
            statistics.setProfile(profile); //назначаем элементу profile

            List<String> profileUniversityIds = universities.stream()
                    .filter(university -> university.getMainProfile().equals(profile)) //Фильтруем список университетов, где профиль обучения соответствует profiles
                    .map(University::getId)
                    .collect(Collectors.toList());

            statistics.setNumberOfUniversities(profileUniversityIds.size()); //каждому элементу statistics задаём количество универститетов

            statistics.setUniversityNames(StringUtils.EMPTY);//каждому элементу statistics задаём пустые имена университетов

            universities.stream()
                    .filter(university -> profileUniversityIds.contains(university.getId()))
                    .map(University::getFullName)
                    .forEach(fullNameUniversity -> statistics.setUniversityNames(
                            statistics.getUniversityNames() + fullNameUniversity + "; ")); // каждому элементу задаём полное имя унивеситета

            List<Student> profileStudents = students.stream()
                    .filter(student -> profileUniversityIds.contains(student.getUniversityId()))
                    .collect(Collectors.toList());
            statistics.setNumberOfStudents(profileStudents.size());
            OptionalDouble avgExamScore = profileStudents.stream()
                    .mapToDouble(Student::getAvgExamScore)
                    .average();
            statistics.setAvgExamScore(0);
            avgExamScore.ifPresent(value -> statistics.setAvgExamScore(
                    (float) BigDecimal.valueOf(value).setScale(2, RoundingMode.HALF_UP).doubleValue()));
        });

        return statisticsList;
    }
}

