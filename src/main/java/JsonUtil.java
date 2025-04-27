import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import models.Student;
import models.University;

import java.util.List;

public class JsonUtil {

    private JsonUtil() {
    }

    public static String studentToJson(Student student) { // Cериализация объектов класса Student
        return new GsonBuilder().setPrettyPrinting().create().toJson(student);    }

    public static String universityToJson(University university) { // Cериализация объектов класса University
        return new GsonBuilder().setPrettyPrinting().create().toJson(university);    }

    public static Student jsonToStudent(String json) { // Десериализация в объект класса Student
        return new Gson().fromJson(json, Student.class);    }

    public static University jsonToUniversity(String json) { // Десериализация в объект класса University
        return new Gson().fromJson(json, University.class);    }

    public static String studentListToJson(List<Student> students) {
        return new GsonBuilder().setPrettyPrinting().create().toJson(students);    }

    public static String universityListToJson(List<University> universities) {
        return new GsonBuilder().setPrettyPrinting().create().toJson(universities);    }

    public static List<Student> jsonToStudentList(String json) {
        return new Gson().fromJson(json, new TypeToken<List<Student>>() {}.getType());
    }

    public static List<University> jsonToUniversityList(String json) {
        return new Gson().fromJson(json, new TypeToken<List<University>>() {}.getType());
    }
}
