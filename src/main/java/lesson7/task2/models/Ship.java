package lesson7.task2.models;

import java.util.ListIterator;

public class Ship<T extends Product> {
    private final T goods;
    private final String name;
    private final float maxWeight;
    private final float maxVolume;
    private int count;
    private boolean isActive;

    public Ship(T goods, String name, float maxWeight, float maxVolume) {
        this.goods = goods;
        this.name = name;
        this.maxWeight = maxWeight;
        this.maxVolume = maxVolume;
        this.isActive = true;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public String getName() {
        return name;
    }

    public float getMaxWeight() {
        return maxWeight;
    }

    public float getMaxVolume() {
        return maxVolume;
    }

    public T getGoods() {
        return goods;
    }

    public int getCount() {
        return count;
    }

    public void add(int count){
        this.count += count;
    }

    public int sub(int count){
        if(this.count < count){
            count = this.count;
        }

        this.count -= count;

        return count;
    }

    public int subAll(){
        int count = this.count;
        this.count = 0;

        return count;
    }

    public void go(ListIterator<PartWay> partWayIterator, Port postShipment, Port postDischarge){
        while (true){
            postShipment.shipment(this);
            if(!this.isActive()){
                break;
            }

            while (partWayIterator.hasNext()){
                partWayIterator.next().run(this);
            }

            postDischarge.discharge(this);

            while (partWayIterator.hasPrevious()){
                partWayIterator.previous().run(this);
            }
        }

        System.out.println("Корабль " + this.getName() + " закончил работу");
    }
}
