package lesson8.wood;

import java.util.*;

public class MainWood {
    public static void main(String[] args) {
        run();
    }

    private static void run() {

        Integer[] res = Forester.countTree(1, 2, 1, 4, 1, 3, 4, 2, 2, 5, 2, 3, 1, 1, 2, 3, 3, 4, 4, 2, 4, 1, 2, 2, 2, 5, 1, 5, 1, 2, 2, 1, 3, 3, 4, 3, 5, 3, 5, 1, 2, 1, 3, 3, 2, 4, 1, 4, 3, 5, 1, 2, 1, 2, 3, 2, 1, 3);

        System.out.println(Arrays.asList(res));
    }
}

class Forester{

    public static Integer[] countTree(int... data){
        HashMap<Integer, Integer> tree = new HashMap<>();

        for (int item: data) {
            int count = tree.getOrDefault(item, 0);
            tree.put(item, ++count);
        }

        return tree.values().toArray(new Integer[0]);
    }
}
