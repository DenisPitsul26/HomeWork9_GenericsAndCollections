package ex2;

import java.io.*;

public class GroupSerializable implements IGroupSerializable{

    private File file;

    public GroupSerializable(File file) {
        this.file = file;
    }

    public GroupSerializable() {
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    @Override
    public void groupSerializable(Group group) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file))){
            oos.writeObject(group);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Group groupDeserializable() {
        Group group = null;
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))){
            group = (Group) ois.readObject();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return group;
    }
}
