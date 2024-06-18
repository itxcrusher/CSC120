import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Test {
    private final String name;
    List<Integer> list;

    public Test(String name){
        this.name = name;
        list = new ArrayList<>();
    }

    public String toString() {
        return "My name is " + name;
    }
    public void populateList(){
        for (int i = 1; i <= 10; i++) {
            list.add(i);
        }
    }

    public static void main(String[] args) {
        Test test = new Test("Hassaan");
        System.out.println(test);
        test.populateList();
        System.out.println("Original list: " + test.list);
        Collections.shuffle(test.list);
        System.out.println("Shuffled list: " + test.list);
    }
}