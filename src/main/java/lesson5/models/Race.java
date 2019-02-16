package lesson5.models;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Race {
    private ArrayList<Stage> stages = new ArrayList<>();
    private ArrayList<Car> cars = new ArrayList<>();
    private Lock lockFinish = new ReentrantLock();
    private Lock lockRace = new ReentrantLock();
    private boolean finish;

    public void addStage(Stage stage){
        stages.add(stage);
    }

    public void addStage(Stage... stages){
        this.stages.addAll(Arrays.asList(stages));
    }

    public void removeStage(int i){
        if(stages.size() - 1 >= i){
            stages.remove(i);
        }
    }

    public void addCar(Car car){
        cars.add(car);
    }

    public void addCar(Car... cars){
        this.cars.addAll(Arrays.asList(cars));
    }

    public void removeCar(int i){
        if(cars.size() -1 >= i){
            cars.remove(i);
        }
    }

    public void run(){
        lockRace.lock();

        finish = false;

        // Можем разрешить большему числу участников въезжать в тоннель
        //Tunnel.smp = new Semaphore(4);

        CyclicBarrier start = new CyclicBarrier (cars.size() + 1);
        ExecutorService service = Executors.newFixedThreadPool(cars.size());

        for (Car car : cars) {
            service.submit(() -> car.go(stages.iterator(), start, this::checkFinish));
        }

        // запускаем гонку
        service.shutdown();

        try {
            // Ждем готовности всех гонщиков
            start.await();
            System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка началась!!!");

            // ждем окончания макс 1 час.
            service.awaitTermination(1, TimeUnit.HOURS);
        } catch (InterruptedException | BrokenBarrierException e) {
            e.printStackTrace();
        }finally {
            System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка закончилась!!!");
        }

        lockRace.unlock();
    }

    private void checkFinish(Car c){
        lockFinish.lock();
        if(!finish){
            finish = true;
            System.out.println(c.getName() + " WIN");
        }
        lockFinish.unlock();
    }
}
