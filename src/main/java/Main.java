import java.sql.SQLOutput;

public class Main {
    public static void main(String[] args) {
        University urfu = new University("1", "UralFederalUniversity", "URFU", 1920, StudyProfile.PHYSICS);
        Student ivan = new Student("IvanIvanov", "1", 2, 4.6F);
        System.out.println(urfu);
        System.out.println(ivan);
    }
}
