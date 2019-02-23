package lesson7.task2.models;

import java.util.ArrayList;
import java.util.Iterator;

public class Port {
    private ArrayList<Pier> piers;
    private final String name;

    public Port(String name) {
        this.name = name;
        this.piers = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void addPier(Pier pier){
        piers.add(pier);
    }

    // загрузка корабля в порту
    public void shipment(Ship ship){
        System.out.println("Корабль " + ship.getName() + " прибыл в порт " + this.getName());
        Product product = ship.getGoods();

        Iterator<Pier> pierIterator = piers.iterator();

        while(pierIterator.hasNext()){
            Pier pier = pierIterator.next();
            if(pier.getGoods().equals(product)){
                System.out.println("Корабль " + ship.getName() + " ожидает загрузки в доке " + pier.getName());
                pier.shipment(ship);
            }
        }

        if(ship.getCount() > 0){
            System.out.println("Корабль " + ship.getName() + " отплыл из порта " + this.getName());
        }
        else{
            ship.setActive(false);
        }
    }

    public void discharge(Ship ship){
        System.out.println("Корабль " + ship.getName() + " прибыл в порт " + this.getName());
        Product product = ship.getGoods();

        Iterator<Pier> pierIterator = piers.iterator();

        while(pierIterator.hasNext()){
            Pier pier = pierIterator.next();
            if(pier.getGoods().equals(product)){
                System.out.println("Корабль " + ship.getName() + " ожидает разгрузки в доке " + pier.getName());
                pier.discharge(ship);
            }
        }

        System.out.println("Корабль " + ship.getName() + " отплыл из порта " + this.getName());
    }

    @Override
    public String toString() {
        StringBuilder info = new StringBuilder();
        info.append("Порт " + this.getName() + "\n");

        Iterator<Pier> pierIterator = piers.iterator();
        while(pierIterator.hasNext()){
            Pier pier = pierIterator.next();
            info.append(pier.toString());
        }

        return info.toString();
    }
}
