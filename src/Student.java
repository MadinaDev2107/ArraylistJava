public class Student {
    private int id;
    private int groupId;
    private String name;
    public int getGroupId() {
        return groupId;
    }
    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public void studentDisplay() {
        System.out.println("Group ID: " + groupId + " | Student ID: " + id + " | Name: " + name);
    }
    public Student(int id, String name, int groupId) {
        this.id = id;
        this.name = name;
        this.groupId = groupId;
    }

}
