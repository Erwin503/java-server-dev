public class Main {
    public static void main(String[] args) {
        Student student1 = new Student("Иванов", "Иван", "Иванович", 
        "2000-01-15", "ул. Ленина, д. 1", 
        "123456", "Факультет информатики", 
        1, "Группа А");

        Student student2 = new Student("Петров", "Петр", "Петрович", 
                "1999-02-20", "ул. Пушкина, д. 2", 
                "654321", "Факультет математики", 
                2, "Группа Б");

        Student student3 = new Student("Сидоров", "Сидор", "Сидорович", 
                "2001-05-30", "ул. Чехова, д. 3", 
                "987654", "Факультет физики", 
                2, "Группа В");

        // Вывод информации о студентах
        System.out.println(student1.toString());
        System.out.println(student2.toString());
        System.out.println(student3.toString());

        StudentManager manager = new StudentManager();

        manager.addStudent(student1);
        manager.addStudent(student2);
        manager.addStudent(student3);

        // Вывод всех студентов
        System.out.println("Все студенты:");
        manager.printAllStudents();
        // Вывод студентов по факультету
        System.out.println("\nСтуденты факультета 'Факультет информатики':");
        System.out.println(manager.getStudentsByFaculty("Факультет информатики"));

        // Вывод студентов по курсу
        System.out.println("\nСтуденты 2 курса:");
        System.out.println(manager.getStudentsByCourse(2));

        // Вывод студентов группы
        System.out.println("\nСтуденты группы 'Группа А':");
        System.out.println(manager.getStudentsByGroup("Группа А"));
    }
}