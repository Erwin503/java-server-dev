import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Student {
    private int student_id;
    private String last_name;
    private String first_name;
    private String middle_name;
    private String birth_date;
    private String address;
    private String phone;
    private String faculty;
    private int course;
    private String group;

    public Student(String last_name, String first_name, String middle_name, 
    String birth_date, String address, String phone, 
    String faculty, int course, String group) {
        this.setlast_name(last_name);
        this.setfirst_name(first_name);
        this.setmiddle_name(middle_name);
        this.setAddress(address);
        this.setbirth_date(birth_date);
        this.setPhone(phone);
        this.setFaculty(faculty);
        this.setCourse(course);
        this.setGroup(group);
    }

    public int getstudent_id() {
        return student_id;
    }

    public String setstudent_id(int student_id) {
        if (student_id < 1) {
            return ("ID не может быть меньше одного");
        };
        if (student_id % 1 != 0) {
            return("ID должен быть целым числом");
        };
        this.student_id = student_id;
        return null;
    }

    public String getlast_name() {
        return last_name;
    }

    public String setlast_name(String last_name) {
        if (last_name.length() < 3 || last_name.length() > 100) {
            return "Неверный размер строки";
        }
        this.last_name = last_name;
        return null;
    }

    public String getfirst_name() {
        return first_name;
    }

    public String setfirst_name(String first_name) {
        if (first_name.length() < 3 || first_name.length() > 100) {
            return "Неверный размер строки";
        }
        this.first_name = first_name;
        return null;
    }

    public String getmiddle_name() {
        return middle_name;
    }

    public String setmiddle_name(String middle_name) {
        if (middle_name.length() < 3 || middle_name.length() > 100) {
            return "Неверный размер строки";
        }
        this.middle_name = middle_name;
        return null;
    }

    public String getbirth_date() {
        return birth_date;
    }

    public String setbirth_date(String birth_date) {
        String regex_date = "\\\\b([1-9]|0[1-9]|[12][0-9]|3[01])-(0[1-9]|1[0-2])-\\\\d{4}\\\\b";
        Pattern pattern = Pattern.compile(regex_date);
        Matcher matcher = pattern.matcher(birth_date);
        if (!matcher.matches()) {
            return "Неверный формат даты. Вот пример ХХ-ХХ-ХХХХ";
        }
        this.birth_date = birth_date;
        return null;
    }

    public String getAddress() {
        return address;
    }

    public String setAddress(String address) {
        if (address.length() < 3 || address.length() > 100) {
            return "Неверный размер строки";
        }
        this.address = address;
        return null;
    }

    public String getPhone() {
        return phone;
    }

    public String setPhone(String phone) {
        String regexPhone = "\\+?[0-9]{1,3}?[-.\\s]?(\\(?[0-9]{3}\\)?|[0-9]{3})[-.\\s]?[0-9]{3}[-.\\s]?[0-9]{4}";
        Pattern pattern = Pattern.compile(regexPhone);
        Matcher matcher = pattern.matcher(phone);

        if (!matcher.matches()) {//+
            return "Неверный формат: +7 123 456 7890, +1 (123) 456-7890, " +
                "+44-123-456-7890, 123-456-7890, (123) 456 7890, 123.456.7890, +1 1234567890";
        }
        this.phone = phone;
        return null;
    }

    public String getFaculty() {
        return faculty;
    }

    public String setFaculty(String faculty) {
        if (faculty.length() < 3 || faculty.length() > 100) {
            return "Неверный размер строки";
        }
        this.faculty = faculty;
        return null;
    }

    public int getCourse() {
        return this.course;
    }

    public String setCourse(int course) {
        if (course < 0 || course > 6) {
            return "Неверное значение курса";
        }
        this.course = course;
        return null;
    }
    

    public String getGroup() {
        return group;
    }

    public String setGroup(String group) {
        if (group.length() < 3 || group.length() > 100) {
            return "Неверный размер строки";
        }
        this.group = group;
        return null;
    }

    @Override
    public String toString() {
        return "Student{" +
               "student_id=" + student_id +
               ", last_name='" + last_name + '\'' +
               ", first_name='" + first_name + '\'' +
               ", middle_name='" + middle_name + '\'' +
               ", birth_date='" + birth_date + '\'' +
               ", address='" + address + '\'' +
               ", phone='" + phone + '\'' +
               ", faculty='" + faculty + '\'' +
               ", course='" + course + '\'' +
               ", group='" + group + '\'' +
               '}';
    }
    @Override
    public int hashCode() {
        return Objects.hash(this.student_id, this.last_name, this.first_name);
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false; // Проверка класса

        Student student = (Student) obj;
        return student_id == student.student_id &&
               Objects.equals(last_name, student.last_name) &&
               Objects.equals(first_name, student.first_name);
    }
}
