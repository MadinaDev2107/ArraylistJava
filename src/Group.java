import java.util.ArrayList;
import java.util.Scanner;

public class Group {
    private int id;
    private String name;
    private int Next = 1;
    private ArrayList<Student> students = new ArrayList<>();

    public Group() {}

    public Group(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public void groupDisplay() {
        System.out.println(id + ". " + name);
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public void addStudent(int groupId) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Student nomini kiriting: ");
        String studentName = scanner.nextLine().trim();

        if (studentName.isEmpty()) {
            System.out.println(" Ism bo‘sh bo‘lmasligi kerak!");
            return;
        }

        Student newStudent = new Student(Next++, studentName, groupId);
        students.add(newStudent);
        System.out.println("Student muvaffaqiyatli qo‘shildi!");
    }


    public void showStudent(int groupId) {
        int count = 0;
        for (Student s : students) {
            if (s.getGroupId() == groupId) {
                System.out.println((++count) + ". " + s.getName());
            }
        }
        if (count == 0) {
            System.out.println("-- Ushbu guruhda studentlar mavjud emas.--");
        }
    }


    public void seeAllStudent() {
        if (students.isEmpty()) {
            System.out.println("Studentlar mavjud emas!");
        } else {
            for (Student g : students) {
                g.studentDisplay();
            }
        }
    }

    public void deleteGroup(int groupId) {
        boolean found = false;
        for (int j = 0; j < students.size(); j++) {
            if (students.get(j).getGroupId() == groupId) {
                students.remove(j);
                j--;
                found = true;
            }
        }

        if (found) {
            System.out.println(" Guruhga tegishli barcha studentlar o‘chirildi.");
        } else {
            System.out.println("️ Ushbu guruhga tegishli student topilmadi.");
        }
    }

    public void deleteStudent(int studentId) {
        boolean removed = false;
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getId() == studentId) {
                students.remove(i);
                i--;
                removed = true;
            }
        }
        if (removed) {
            System.out.println(" Student o‘chirildi.");
        } else {
            System.out.println(" Student topilmadi.");
        }
    }

}
