import java.util.*;

class Course {
    String code, title, description, schedule;
    int capacity;
    List<String> registeredStudents = new ArrayList<>();

    Course(String code, String title, String description, int capacity, String schedule) {
        this.code = code;
        this.title = title;
        this.description = description;
        this.capacity = capacity;
        this.schedule = schedule;
    }

    boolean isAvailable() {
        return registeredStudents.size() < capacity;
    }
}

class Student {
    String id, name;
    List<Course> registeredCourses = new ArrayList<>();

    Student(String id, String name) {
        this.id = id;
        this.name = name;
    }
}

public class CourseRegistrationSystem {
    static List<Course> courses = new ArrayList<>();
    static List<Student> students = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        initializeCourses();
        while (true) {
            System.out.println("\n1. List Courses\n2. Register Student\n3. Register for Course\n4. Drop Course\n5. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1 -> listCourses();
                case 2 -> registerStudent();
                case 3 -> registerForCourse();
                case 4 -> dropCourse();
                case 5 -> System.exit(0);
                default -> System.out.println("Invalid choice!");
            }
        }
    }

    static void initializeCourses() {
        courses.add(new Course("C101", "Java Basics", "Intro to Java", 2, "Mon-Wed 10AM"));
        courses.add(new Course("C102", "Data Structures", "DS Concepts", 3, "Tue-Thu 1PM"));
    }

    static void listCourses() {
        System.out.println("\nAvailable Courses:");
        for (Course c : courses) {
            System.out.printf("%s - %s (%s), Slots: %d/%d\n", c.code, c.title, c.schedule, c.registeredStudents.size(), c.capacity);
        }
    }

    static void registerStudent() {
        System.out.print("Enter Student ID: ");
        String id = scanner.nextLine();
        System.out.print("Enter Name: ");
        String name = scanner.nextLine();
        students.add(new Student(id, name));
        System.out.println("Student registered successfully!");
    }

    static Student findStudent(String id) {
        return students.stream().filter(s -> s.id.equals(id)).findFirst().orElse(null);
    }

    static Course findCourse(String code) {
        return courses.stream().filter(c -> c.code.equals(code)).findFirst().orElse(null);
    }

    static void registerForCourse() {
        System.out.print("Enter Student ID: ");
        String studentId = scanner.nextLine();
        Student student = findStudent(studentId);
        if (student == null) {
            System.out.println("Student not found!");
            return;
        }
        System.out.print("Enter Course Code: ");
        String courseCode = scanner.nextLine();
        Course course = findCourse(courseCode);
        if (course == null || !course.isAvailable()) {
            System.out.println("Course not found or full!");
            return;
        }
        student.registeredCourses.add(course);
        course.registeredStudents.add(studentId);
        System.out.println("Course registration successful!");
    }

    static void dropCourse() {
        System.out.print("Enter Student ID: ");
        String studentId = scanner.nextLine();
        Student student = findStudent(studentId);
        if (student == null) {
            System.out.println("Student not found!");
            return;
        }
        System.out.print("Enter Course Code: ");
        String courseCode = scanner.nextLine();
        Course course = findCourse(courseCode);
        if (course == null || !student.registeredCourses.remove(course)) {
            System.out.println("Course not found in student's registered courses!");
            return;
        }
        course.registeredStudents.remove(studentId);
        System.out.println("Course dropped successfully!");
    }
}
