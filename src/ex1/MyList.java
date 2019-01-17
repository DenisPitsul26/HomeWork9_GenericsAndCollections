package ex1;

import java.util.ArrayList;
import java.util.List;

public class MyList{

    private List<Integer> list;

    public MyList() {
        list = new ArrayList<>();
    }

    public void createList(){
        for (int i = 0; i < 10; i++) {
            Integer number = (int) (Math.random() * 10 + 1);
            list.add(number);
        }
        System.out.println(list);
        list.remove(0);
        list.remove(0);
        list.remove(list.size()-1);

        System.out.println(list);
    }

    @Override
    public String toString() {
        return "MyList{" +
                "list=" + list +
                '}';
    }
}
