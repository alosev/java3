package lesson5.models;

public class Road extends Stage {
    public Road(int length) {
        super(length, "Дорога");
    }

    @Override
    public void go(Car c) {
        System.out.println(c.getName() + " начал этап: " + getDescription());
        runStage(c);
        System.out.println(c.getName() + " закончил этап: " + getDescription());
    }
}
