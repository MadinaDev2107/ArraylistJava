import java.util.ArrayList;
import java.util.Scanner;

public class StudyCenter {
    private   String name;
    private static int idCounter = 1;
    private  int Next=1;
    private ArrayList<Group> groups;
    StudyCenter(){
        this.groups = new ArrayList<>();
    }
    public void setName(String name) {
        this.name = name;
    }
    public void displayAll() {
        System.out.println("📘 O‘quv markazi nomi: " + name);
        if (groups.isEmpty()) {
            System.out.println("️ Hozircha guruhlar mavjud emas.");
            return;
        }
        for (Group g : groups) {
            g.groupDisplay();
        }
    }
    public void display() {
        if (groups.isEmpty()) {
            System.out.println("Hozircha guruhlar mavjud emas.");
            return;
        }
        for (Group g : groups) {
            g.groupDisplay();
        }
    }
    public void addGroup() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("➕ Guruh nomini kiriting: ");
        String groupName = scanner.nextLine().trim();
        if (groupName.isEmpty()) {
            System.out.println(" Guruh nomi bo‘sh bo‘lmasligi kerak!");
            return;
        }

        Group newGroup = new Group(Next++, groupName);
        groups.add(newGroup);
        System.out.println(" Guruh muvaffaqiyatli qo‘shildi: " + groupName);
    }
    public void groupSelect(int id) {
        boolean found = false;
        for (Group g : groups) {
            if (g.getId() == id) {
                g.groupDisplay();
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println(" Bunday ID ga ega guruh topilmadi.");
        }
    }
    public void deleteGroup(int id) {
        boolean found = false;
        for (int j = 0; j < groups.size(); j++) {
            Group g = groups.get(j);
            if (g.getId() == id) {
                g.deleteGroup(id);
                groups.remove(j);
                System.out.println(" Guruh va unga tegishli studentlar o‘chirildi.");
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println(" Bunday ID ga ega guruh topilmadi.");
        }
    }
}
