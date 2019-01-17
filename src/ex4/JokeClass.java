package ex4;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;
import java.util.stream.Collectors;

public class JokeClass {

    private Deque<String> dequeOfNames = new ArrayDeque<>();

    public JokeClass(Deque<String> dequeOfNames) {
        this.dequeOfNames = dequeOfNames;
    }

    public JokeClass(String[] names){
        if (names == null)
            throw new IllegalArgumentException();

        for (String name : names) {
            if (name != null)
                dequeOfNames.add(name);
        }
    }

    public JokeClass(List<String> names){
        if (names == null)
            throw new IllegalArgumentException();
        dequeOfNames.addAll(names);
    }

    public JokeClass() {
        dequeOfNames.add("Sheldon");
        dequeOfNames.add("Leonard");
        dequeOfNames.add("Volovitc");
        dequeOfNames.add("Kutrapalli");
        dequeOfNames.add("Penny");
    }

    public Deque<String> getDequeOfNames() {
        return dequeOfNames;
    }

    public void setDequeOfNames(Deque<String> dequeOfNames) {
        this.dequeOfNames = dequeOfNames;
    }

    public void drinkGlassesOfCola(int number){
        for (int i = 0; i < number; i++) {
            String tempName = dequeOfNames.pollFirst();
            dequeOfNames.add(tempName);
            dequeOfNames.add(tempName);
        }
        System.out.println(this.toString());
    }


    @Override
    public String toString() {
        return "JokeClass{" +
                "dequeOfNames=" + dequeOfNames +
                '}';
    }
}
