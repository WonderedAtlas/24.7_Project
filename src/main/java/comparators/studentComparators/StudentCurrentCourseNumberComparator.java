package comparators.studentComparators;

import models.Student;

public class StudentCurrentCourseNumberComparator implements IStudentComparator {
    @Override
    public int compare(Student s1, Student s2) {
        return Integer.compare(s1.getCurrentCourseNumber(), s2.getCurrentCourseNumber());
    }
}
