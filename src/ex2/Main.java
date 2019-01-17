package ex2;

import java.io.File;

public class Main {
    public static void main(String[] args) {

        Student student1 = new Student("Денис", "Піцул", true, 20, false,
                85, 43);
        Student student2 = new Student("Володимир", "Перон", true, 19, false,
                85, 54);
        Student student3 = new Student("Андрій", "Онищук", true, 20, false,
                80, 32);
        Student student4 = new Student("Роман", "Осадчук", true, 17, true,
                92, 65);
        Student student5 = new Student("Олександр", "Срібний", true, 19, true,
                88, 49);

        Group group = new Group(343);
        try {
            group.addStudentToGroup(student1);
            group.addStudentToGroup(student2);
            group.addStudentToGroup(student3);
            group.addStudentToGroup(student4);
            group.addStudentToGroup(student5);
        } catch (ArrayIsFullException e) {
            e.printStackTrace();
        }

        GroupSerializable gSerializable = new GroupSerializable(new File("group.txt"));
        gSerializable.groupSerializable(group);
        Group gDeserializable = gSerializable.groupDeserializable();

        System.out.println("group equal gDeserializable -> "+ group.equals(gDeserializable));

        Group groupClone = (Group) group.clone();
        System.out.println("group equal groupClone -> "+ group.equals(groupClone));

        group.sortStudent(1);
        System.out.println(group);

    }

}
