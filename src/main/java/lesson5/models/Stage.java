package lesson5.models;

public abstract class Stage {
    private int length;
    private String name;

    public Stage(int length, String name) {
        this.length = length;
        this.name = name;
        System.out.println("Подготовлен участок: " + getDescription());
    }

    public int getLength() {
        return length;
    }

    public String getDescription() {
        return name + " " + getLength() + " метров";
    }

    protected void runStage(Car car){
        try {
            Thread.sleep(getLength() / car.getSpeed() * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public abstract void go(Car c);
}
