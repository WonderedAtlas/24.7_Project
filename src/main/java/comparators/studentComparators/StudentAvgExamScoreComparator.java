package comparators.studentComparators;

import models.Student;

public class StudentAvgExamScoreComparator implements IStudentComparator {
    @Override
    public int compare(Student s1, Student s2) {
        return Float.compare(s2.getAvgExamScore(), s1.getAvgExamScore()); // сортировка по убыванию
    }
}
