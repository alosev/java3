package lesson5.models;

import java.util.concurrent.Semaphore;

public class Tunnel extends Stage {
    public static Semaphore smp = new Semaphore(2);

    public Tunnel(int length) {
        super(length, "Тоннель");
    }

    @Override
    public void go(Car c) {
        try {
            System.out.println(c.getName() + " готовится к этапу(ждет): " + getDescription());
            smp.acquire();
            System.out.println(c.getName() + " начал этап: " + getDescription());
            runStage(c);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        finally {
            System.out.println(c.getName() + " закончил этап: " + getDescription());
            smp.release();
        }
    }
}
