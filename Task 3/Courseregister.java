import java.util.*;

class Course {
    private String code, title, description;
    private int capacity, slots;

    public Course(String code, String title, String description, int capacity) {
        this.code = code;
        this.title = title;
        this.description = description;
        this.capacity = capacity;
        this.slots = capacity;
    }

    public String getCode() {
        return code;
    }
    public String getTitle() {
        return title;
    }
    public int getSlots() {
        return slots;
    }
    public void register() {
        if (slots > 0) slots--;
    }
    public void unregister() {
        if (slots < capacity)
            slots++;
    }
}

class Student {
    private String id, name;
    private List<String> registeredCourses;

    public Student(String id, String name) {
        this.id = id;
        this.name = name;
        this.registeredCourses = new ArrayList<>();
    }

    public String getId() {
        return id;
    }
    public String getName() {
        return name; }
    public List<String> getRegisteredCourses() {
        return registeredCourses;
    }

    public void registerCourse(String courseId) {
        registeredCourses.add(courseId);
    }
    public void removeCourse(String courseId) {
        registeredCourses.remove(courseId);
    }
}

public class Courseregister {
    private Map<String, Course> courses;
    private Map<String, Student> students;

    public Courseregister() {
        this.courses = new HashMap<>();
        this.students = new HashMap<>();
    }

    public void addCourse(String code, String title, String description, int capacity) {
        courses.put(code, new Course(code, title, description, capacity));
    }

    public void addStudent(String id, String name) {
        students.put(id, new Student(id, name));
    }

    public void listCourses() {
        for (Course course : courses.values()) {
            System.out.println("Code: " + course.getCode() + ", Title: " + course.getTitle() + ", Slots: " + course.getSlots());
        }
    }

    public void registerStudent(String studentId, String courseId) {
        if (students.containsKey(studentId) && courses.containsKey(courseId)) {
            Student student = students.get(studentId);
            Course course = courses.get(courseId);

            if (course.getSlots() > 0 && !student.getRegisteredCourses().contains(courseId)) {
                student.registerCourse(courseId);
                course.register();
                System.out.println("---------------------------------------------------------------");
                System.out.println("Student : " + studentId + " Registered for course : " + courseId);
            }
            else {
                System.out.println("Course is full or student already registered...");
            }
        }
        else {
            System.out.println("Student or course not found...");
        }
    }

    public void removeCourse(String studentId, String courseId) {
        if (students.containsKey(studentId) && courses.containsKey(courseId)) {
            Student student = students.get(studentId);
            Course course = courses.get(courseId);

            if (student.getRegisteredCourses().contains(courseId)) {
                student.removeCourse(courseId);
                course.unregister();
                System.out.println("---------------------------------------------------------------");
                System.out.println("Student : " + studentId + " Removed from course : " + courseId);
                System.out.println("---------------------------------------------------------------");
            }
            else {
                System.out.println("Student not registered for course !");
            }
        }
        else {
            System.out.println("Student or course not found !");
        }
    }

    public static void main(String[] args) {
        Courseregister crs = new Courseregister();
        crs.addCourse("314443", "Machine Learning", "Basic of Machine Learning", 12);
        crs.addCourse("314445", "Theory of Computation", "Learn about the Automata", 16);
        crs.addCourse("314441", "Operating System", "Introduction of Operating System", 8);
        crs.addStudent("TE015", "Niraj Tapase");
        crs.addStudent("TE016", "Rohit Galande");
        crs.addStudent("TE017", "Shriram Bidave");

        System.out.println("Initial Course List:");
        crs.listCourses();

        crs.registerStudent("TE015", "314443");
        crs.registerStudent("TE016", "314445");
        crs.registerStudent("TE017", "314441");

        System.out.println("\nCourse List after registration:");
        crs.listCourses();

        crs.removeCourse("TE015", "314443");

        System.out.println("\nCourse List after removal:");
        crs.listCourses();
    }
}
