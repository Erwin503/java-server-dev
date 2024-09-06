import java.util.ArrayList;
import java.util.List;

public class StudentManager {
    private List<Student> students;

    // Конструктор
    public StudentManager() {
        this.students = new ArrayList<>();
    }

    // Метод для добавления студента в список
    public void addStudent(Student student) {
        students.add(student);
    }

    // Метод для выбора студентов по курсу
    public List<Student> getStudentsByCourse(int course) {
        List<Student> result = new ArrayList<>();
        for (Student student : students) {
            if (student.getCourse() == course) {
                result.add(student);
            }
        }
        return result;
    }

    // Метод для выбора студентов по факультету
    public List<Student> getStudentsByFaculty(String faculty) {
        List<Student> result = new ArrayList<>();
        for (Student student : students) {
            if (student.getFaculty() == faculty) {
                result.add(student);
            }
        }
        return result;
    }

    public List<Student> getStudentsByGroup(String group) {
        List<Student> result = new ArrayList<>();
        for (Student student : students) {
            if (student.getGroup() == group) {
                result.add(student);
            }
        }
        return result;
    }

    // Метод для вывода всех студентов
    public void printAllStudents() {
        for (Student student : students) {
            System.out.println(student);
        }
    }
};