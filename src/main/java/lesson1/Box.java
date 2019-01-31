package lesson1;

import lesson1.model.Fruit;
import java.util.ArrayList;
import java.util.Arrays;

public class Box<T extends Fruit> {

    private ArrayList<T> fruits;
    private String name;

    public Box(String name, T... fruits) {
        this.name = name;
        this.fruits = new ArrayList<T>(Arrays.asList(fruits));
    }

    public String getName() {
        return name;
    }

    public void add(T fruit){
        fruits.add(fruit);
    }

    public float getWeight(){
        float weightTotal = 0;
        int size = fruits.size();
        if(size > 0){
            weightTotal = fruits.get(0).getWeight() * size;
        }

        return weightTotal;
    }

    public boolean compare(Box box){
        return this.getWeight() == box.getWeight();
    }

    public void outBox(Box<T> box){
        for (T fruit: fruits) {
            box.add(fruit);
        }

        fruits.clear();
    }
}
