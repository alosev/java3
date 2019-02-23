package lesson7.task2;

import lesson7.task2.models.*;

import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class MainStart {
    public static void main(String[] args) {
        run();
    }

    private static void run() {
        ArrayList<PartWay> way = getWay();
        ArrayList<Ship> ships = getShips();
        Port postShipment = getPortShipment();
        Port postDischarge = getPortDischarge();

        ExecutorService service = Executors.newFixedThreadPool(ships.size());

        for (Ship ship : ships) {
            service.submit(() -> ship.go(way.listIterator(), postShipment, postDischarge));
        }

        service.shutdown();

        try {
            service.awaitTermination(1, TimeUnit.HOURS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(postShipment.toString());
        System.out.println(postDischarge.toString());
    }

    private static ArrayList<PartWay> getWay(){
        ArrayList<PartWay> way = new ArrayList<>();
        way.add(new PartWater("Водный путь #1", 80));
        way.add(new PartWater("Водный путь #2", 30));
        way.add(new PartChannel("Пролив #1", 20));
        way.add(new PartWater("Водный путь #3", 30));
        way.add(new PartChannel("Пролив #2", 30));
        way.add(new PartWater("Водный путь #4", 50));
        return way;
    }

    private static ArrayList<Ship> getShips(){
        ArrayList<Ship> ships = new ArrayList<>();

        ships.add(new Ship(new Clothes(), "Корабль #1", 500f, 570f));
        ships.add(new Ship(new Fuel(), "Корабль #2", 520f, 480f));
        ships.add(new Ship(new Food(), "Корабль #3", 900f, 930f));
        ships.add(new Ship(new Fuel(), "Корабль #4", 4400f, 4500f));

        return ships;
    }

    private static Port getPortShipment(){
        Port port = new Port("Порт загрузки");

        port.addPier(new Pier("Док с одеждой", new Clothes(), 2700));
        port.addPier(new Pier("Док с топливом", new Fuel(), 8500));
        port.addPier(new Pier("Док с едой", new Food(), 5900));

        return port;
    }

    private static Port getPortDischarge(){
        Port port = new Port("Порт разгрузки");

        port.addPier(new Pier("Док с одеждой", new Clothes(), 0));
        port.addPier(new Pier("Док с топливом", new Fuel(), 0));
        port.addPier(new Pier("Док с едой", new Food(), 0));

        return port;
    }
}
