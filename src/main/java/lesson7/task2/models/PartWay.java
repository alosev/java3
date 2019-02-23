package lesson7.task2.models;

public abstract class PartWay {
    private final String name;
    private final int length;

    public PartWay(String name, int length) {
        this.name = name;
        this.length = length;
    }

    public String getName() {
        return name;
    }

    public int getLength() {
        return length;
    }

    public abstract void run(Ship ship);

    protected void innerRun(Ship ship){
        System.out.println("Корабль " + ship.getName() + " начал проходить участок " + this.getName());
        try {
            Thread.sleep(40 * this.getLength());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Корабль " + ship.getName() + " закончил проходить участок " + this.getName());
    }
}
