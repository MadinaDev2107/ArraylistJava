import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

       StudyCenter studyCenter = new StudyCenter();
        Scanner scanner = new Scanner(System.in);
        System.out.println("O'quv markaz dasturiga xush kelibsiz!");
        System.out.print("O'quv markaz nomini kiriting");
        String scannerStr=scanner.nextLine();
        studyCenter.setName(scannerStr);
        Commands commands = new Commands();
        Group group= new Group();
        while (true){
          commands.group();
            int scanerInt= scanner.nextInt();
            switch (scanerInt){
                case 1:
                  studyCenter.addGroup();
                  studyCenter.displayAll();
                    break;
                case 2:
                    studyCenter.displayAll();
                    break;
                case 3:
                    System.out.println("Guruhlardan birini tanlang");
                    studyCenter.display();
                    int a= scanner.nextInt();
                    studyCenter.groupSelect(a);
                    boolean manage= true;
                    while(manage){
                        commands.student();
                        switch (scanner.nextInt()){
                            case 1:
                                group.addStudent(a);
                                group.showStudent(a);
                                break;
                            case 2:
                                System.out.print("O'chirmoqchi bo'lgan student IDsini kiriting: ");
                                group.deleteStudent(scanner.nextInt());
                                group.seeAllStudent();
                                break;
                            case 0:
                                manage= false;
                                break;
                            default:
                                System.out.println("Noto'g'ri buyruq raqami.");
                                break;

                        }
                    }
                    break;
                case 4:
                    studyCenter.displayAll();
                    System.out.print("O'chirmoqchi bo'lgan guruh IDsini kiriting: ");
                    int b=scanner.nextInt();
                    studyCenter.deleteGroup(b);
                    studyCenter.displayAll();
                    break;
                case 5:
                    group.seeAllStudent();
                    break;
                default:
                    System.out.println("Mavjud bo'lmagan buyruq raqami!!!!");
                    break;
            }



        }
    }
}