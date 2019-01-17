package ex2;

import java.io.*;
import java.util.List;

public class GroupDAO{

    public static void saveGroupToFile(Group group) throws IOException{
        StringBuilder sb = new StringBuilder();
        File file = new File("group.txt");
        List<Student> students = group.getStudentsList();
        for (Student student : students) {
            if (student != null) {
                sb.append(student.getFirstName()).append(" ");
                sb.append(student.getLastName()).append(" ");
                sb.append(student.getSex()).append(" ");
                sb.append(student.getAge()).append(" ");
                sb.append(student.isStipend()).append(" ");
                sb.append(student.getAverageScore()).append(" ");
                sb.append(student.getNumberOfTheRecordBook()).append(" ");
            }
            sb.append("\n");
        }
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(file));
            writer.write(sb.toString());
            writer.flush();

        } catch (IOException e) {
            throw e;
        }
    }


    public static Group loadGroupFromFile(File file) throws IOException, ArrayIsFullException {
        Group group = new Group();

        try (BufferedReader reader = new BufferedReader(new FileReader(file))){
            String line = "";
            while ((line = reader.readLine()) != null){
                group.addStudentToGroup(stringToStudent(line));
            }

        } catch (ArrayIsFullException | IOException e) {
            throw e;
        }

        return group;
    }

    public static Student stringToStudent(String line){
        if (line.equals(""))
            return null;

        String[] studentToString = line.split(" ");
        Student student = new Student();
        student.setFirstName(studentToString[0]);
        student.setLastName(studentToString[1]);
        student.setSex(Boolean.parseBoolean(studentToString[2]));
        student.setStipend(Boolean.parseBoolean(studentToString[4]));
        try {
            student.setAge(Integer.parseInt(studentToString[3]));
            student.setAverageScore(Double.parseDouble(studentToString[5]));
            student.setNumberOfTheRecordBook(Integer.parseInt(studentToString[6]));
        } catch (NumberFormatException e) {
            System.out.println("Error adding student to file.");
            return null;
        }

        return student;
    }
}
