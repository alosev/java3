package lesson7.task2.models;

public class Pier<T extends Product> {
    private final T goods;
    private final String name;
    private int count;

    public Pier(String name, T goods, int count) {
        this.name = name;
        this.goods = goods;
        this.count = count;
    }

    public String getName() {
        return name;
    }

    public T getGoods() {
        return goods;
    }

    public int getCount() {
        return count;
    }

    // загрузка пирса в порту. Приехал откуда-то самосвал и сгрузил в пирс товар
    public synchronized void add(int count){
        innerAdd(count);
    }

    // внутренняя работа
    private void innerAdd(int count){
        this.count += count;
    }

    // разгрузка пирса в порту. Приехал откуда-то самосвал и забрал груз куда-то
    public synchronized int sub(int count){
        return innerSub(count);
    }

    // внутренняя работа
    private int innerSub(int count){
        if(this.count < count){
            count = this.count;
        }
        this.count -= count;
        return count;
    }

    // загрузка на корабль
    public synchronized void shipment(Ship ship){
        System.out.println("Корабль " + ship.getName() + " начал загрузку в доке " + this.getName());
        Product product = ship.getGoods();

        if(product.equals(getGoods())){
            int count = ship.getCount();
            float maxWeight = ship.getMaxWeight();
            float maxVolume = ship.getMaxVolume();

            int deltaWeightCount = (int)((maxWeight - (product.getWeight() * count)) / product.getWeight());
            int deltaVolumeCount = (int)((maxVolume - (product.getVolume() * count)) / product.getVolume());

            int maxCount = Math.max(deltaWeightCount, deltaVolumeCount);

            try {
                Thread.sleep(1000 * maxCount/100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            ship.add(this.innerSub(maxCount));
            System.out.println("Корабль " + ship.getName() + " загрузил " + product.getName() + " в количестве " + maxCount + " ед.");
        }

        System.out.println("Корабль " + ship.getName() + " закончил загрузку в доке " + this.getName());
    }

    // разгрузка корабля
    public synchronized void discharge(Ship ship){
        System.out.println("Корабль " + ship.getName() + " начал разгрузку в доке " + this.getName());
        Product product = ship.getGoods();

        if(product.equals(getGoods())){
            int count = ship.subAll();

            try {
                Thread.sleep(1000 * count/100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            this.innerAdd(count);
            System.out.println("Корабль " + ship.getName() + " разгрузил " + product.getName() + " в количестве " + count + " ед.");
        }

        System.out.println("Корабль " + ship.getName() + " закончил разгрузку в доке " + this.getName());
    }

    @Override
    public String toString() {

        String info = "Док: " + this.getName() + "\n" +
                "Товар: " + this.getGoods().getName() + "\n" +
                "Количество: " + this.getCount() + "\n";

        return info;
    }
}
