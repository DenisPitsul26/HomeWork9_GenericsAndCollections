package ex3;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Collectors;

public class PrintStatistics {

    public static void print(File file) throws IOException {
        Files.lines(Paths.get(file.getAbsolutePath()))
                .map(n -> n.toUpperCase())
                .flatMapToInt(n -> n.chars())
                .filter(n -> (n>='A' && n<='Z'))
                .mapToObj(n -> (char) n)
                .collect(Collectors.groupingBy(n -> n, Collectors.counting())).entrySet().stream()
                .sorted((n, m) -> (int)(m.getValue() - n.getValue()))
                .forEach(System.out::println);
    }

}
