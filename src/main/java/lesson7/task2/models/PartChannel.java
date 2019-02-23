package lesson7.task2.models;

import java.util.concurrent.Semaphore;

public class PartChannel extends PartWay {
    private Semaphore semaphore = new Semaphore(2);

    public PartChannel(String name, int length) {
        super(name, length);
    }

    @Override
    public void run(Ship ship) {
        try {
            System.out.println(ship.getName() + " готовится проходить участок: " + this.getName());
            semaphore.acquire();
            innerRun(ship);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        finally {
            semaphore.release();
        }
    }
}
