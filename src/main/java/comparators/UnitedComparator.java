package comparators;

import comparators.studentComparators.*;
import comparators.universityComporators.*;
import enums.EStudentMethodComporator;
import enums.EUniversityMethodComparator;

public class UnitedComparator {

    public static IStudentComparator getStudentComparator(EStudentMethodComporator currentStudentMethod) {
        switch (currentStudentMethod) {
            case StudentAvgExamScoreComparator:
                return new StudentAvgExamScoreComparator();
            case StudentCurrentCourseNumberComparator:
                return new StudentCurrentCourseNumberComparator();
            case StudentFullNameComparator:
                return new StudentFullNameComparator();
            case StudentUniversityIdComparator:
                return new StudentUniversityIdComparator();
            default:
                throw new IllegalStateException("Unexpected method " + currentStudentMethod);

        }
    }

    public static IUniversityComparator getUniversityComparator(EUniversityMethodComparator currentStudentMethod) {
        switch (currentStudentMethod) {
            case UniversityFullNameComparator:
                return new UniversityFullNameComparator();
            case UniversityIdComparator:
                return new UniversityIdComparator();
            case UniversityMainProfileComparator:
                return new UniversityMainProfileComparator();
            case UniversityShortNameComparator:
                return new UniversityShortNameComparator();
            case UniversityYearOfFoundationComparator:
                return new UniversityYearOfFoundationComparator();
            default:
                throw new IllegalStateException("Unexpected method " + currentStudentMethod);

        }
    }
}
