package lesson5.models;

import java.util.Iterator;
import java.util.concurrent.CyclicBarrier;
import java.util.function.Consumer;

public class Car {
    private int speed;
    private String name;

    public String getName() {
        return name;
    }

    public int getSpeed() {
        return speed;
    }

    public Car(String name, int speed) {
        this.speed = speed;
        this.name = name;
        System.out.println("Зарегестрирован участник: " + getName());
    }

    public void go(Iterator<Stage> stages, CyclicBarrier start, Consumer<Car> consumer) {
        try {
            System.out.println(getName() + " готовится");
            Thread.sleep(500 + (int)(Math.random() * 800));
            System.out.println(getName() + " готов");
            // ждем остальных гонщиков
            start.await();
        } catch (Exception e) {
            e.printStackTrace();
        }

        while (stages.hasNext()){
            stages.next().go(this);
        }

        consumer.accept(this);
    }



}
