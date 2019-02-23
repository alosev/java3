package lesson7.task2.models;

import java.util.Objects;

public abstract class Product {
    private String name;
    private float weight;
    private float volume;

    public Product(String name, float weight, float volume) {
        this.name = name;
        this.weight = weight;
        this.volume = volume;
    }

    public String getName() {
        return name;
    }

    public float getWeight() {
        return weight;
    }

    public float getVolume() {
        return volume;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Float.compare(product.weight, weight) == 0 &&
                Float.compare(product.volume, volume) == 0 &&
                Objects.equals(name, product.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, weight, volume);
    }
}
