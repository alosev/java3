package lesson7.task2.models;

public class PartWater extends PartWay {

    public PartWater(String name, int length) {
        super(name, length);
    }

    @Override
    public void run(Ship ship) {
        this.innerRun(ship);
    }
}
