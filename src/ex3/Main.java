package ex3;

import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {

        try {
            PrintStatistics.print(new File("text.txt"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
