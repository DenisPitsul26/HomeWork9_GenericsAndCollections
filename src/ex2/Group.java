package ex2;

import java.io.Serializable;
import java.util.*;

public class Group implements Voenkom, Serializable, Cloneable {

    private int numberOfGroup;
    private List<Student> studentsList;

    private static final long SerialVersionUID = 1L;


    public Group(int numberOfGroup) {
        this.numberOfGroup = numberOfGroup;
        studentsList = new ArrayList<>();
    }

    public Group() {
        studentsList = new ArrayList<>();
    }

    public int getNumberOfGroup() {
        return numberOfGroup;
    }

    public void setNumberOfGroup(int numberOfGroup) {
        this.numberOfGroup = numberOfGroup;
    }

    public List<Student> getStudentsList() {
        return studentsList;
    }

    public void addStudentToGroup(Student student) throws ArrayIsFullException {
        if (student == null) {
            System.out.println("This student is null..");
            return;
        }

        if (isGroupNotFull()) {
            boolean thisStudentIsAlreadyInTheGroup = false; //для того щоб ми не добавляни 2 раза одного студента
            for (int i = 0; i < studentsList.size(); i++) {
                if (studentsList.get(i).getFirstName().equals(student.getFirstName())
                        && studentsList.get(i).getLastName().equals(student.getLastName())) {
                    thisStudentIsAlreadyInTheGroup = true;
                }
            }
            if (!thisStudentIsAlreadyInTheGroup) {
                studentsList.add(student);
                System.out.println(student.getFirstName() + " " + student.getLastName() + " has added successfully.");
            }
            else
                System.out.println("This student is already in the group.");
        }
        else
            throw new ArrayIsFullException();

    }

    public boolean isGroupNotFull(){
        return studentsList.size() < 10;
    }

    public static Student createStudent(){
        Scanner in = new Scanner(System.in);
        Student student = new Student();

        try {
            System.out.print("Input first name: ");
            student.setFirstName(in.nextLine());
            System.out.print("Input last name: ");
            student.setLastName(in.nextLine());
            System.out.print("Input sex: ");
            student.setSex(in.nextBoolean());
            System.out.print("Input age: ");
            student.setAge(in.nextInt());
            System.out.print("Is get stipend: ");
            student.setStipend(in.nextBoolean());
            System.out.print("Input average score: ");
            student.setAverageScore(in.nextDouble());
            System.out.print("Input number of the record book: ");
            student.setNumberOfTheRecordBook(in.nextInt());
        }catch (InputMismatchException e) {
            System.out.println("Error adding student.");
            return null;
        }

        return student;
    }

    public void deleteStudentFromGroup(Student student) {
        if (student != null) {
            boolean thereIsTheStudentInGroup = false;
            for (int i = 0; i < studentsList.size(); i++) {
                if (studentsList.get(i).getFirstName().equals(student.getFirstName())
                        && studentsList.get(i).getLastName().equals(student.getLastName())) {
                    thereIsTheStudentInGroup = true;
                    studentsList.remove(student);
                    System.out.println(student.getFirstName() + " " + student.getLastName() + " has deleted from group.");
                }

            }
            if (!thereIsTheStudentInGroup) {
                System.out.println("Such a student is not in the group.");
            }
        }
    }

    public void deleteStudentByIndex(int index) {
        if (index <= studentsList.size()) {
            Student student = studentsList.get(index-1);
            studentsList.remove(index-1);
            System.out.println(student +" is delete from the "+ index +" place in the group.");
        }
        else
            System.out.println("No such place in the group.");
    }

    public Student getStudentByLastName(String lastName) {
        for (Student aStudentsList : studentsList) {
            try {
                if (aStudentsList.getLastName().equals(lastName)) {
                    return aStudentsList;
                }
            } catch (NullPointerException e) {
            }
        }
        System.out.println("Such a student is not in the group.");
        return null;
    }

    public void sortStudent(int paremetr) {
        if (paremetr >= 1 && paremetr <= 6) {
            Student.setSortParam(paremetr);
            studentsList.sort(new Student());
        }
    }

    @Override
    public List<Student> getAdultMaleStudents() {
        List<Student> adultStudents = new ArrayList<>();

        for (int i = 0; i < studentsList.size(); i++) {
            if (studentsList.get(i).getAge() >= 18 && studentsList.get(i).getSex()) {
                adultStudents.add(studentsList.get(i));
            }
        }

        return adultStudents;
    }

    public void showInfo() {
        System.out.println("Group{\n");
        for (int i = 0; i < studentsList.size(); i++) {
            System.out.println(studentsList.get(i));
        }
        System.out.println("}");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Group group = (Group) o;
        return numberOfGroup == group.numberOfGroup &&
                Objects.equals(studentsList, group.studentsList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(numberOfGroup, studentsList);
    }

    @Override
    protected Object clone(){
        try {
            return (Group) super.clone();
        }
        catch (CloneNotSupportedException e){
            return null;
        }
    }

    @Override
    public String toString() {
        return "Group{" +
                "numberOfGroup=" + numberOfGroup +
                ", studentsList=" + studentsList +
                '}';
    }
}
