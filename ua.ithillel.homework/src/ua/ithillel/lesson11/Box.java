package ua.ithillel.lesson11;

import java.util.ArrayList;
import java.util.List;

public class Box<T extends Fruit> {
    private List<T> fruits = new ArrayList<>();

    public void addOneFruit(T fruit) {
        fruits.add(fruit);
    }

    public void addManyFruits(List<T> newFruits) {
        fruits.addAll(newFruits);
    }

    public float getWeight() {
        return fruits.get(0).getWeight() * fruits.size();
    }

    public boolean compare (Box<? extends Fruit> box) {
        return getWeight() == box.getWeight();
    }

    public void merge(Box<T> box) {
        fruits.addAll(box.getFruits());
    }

    public List<T> getFruits() {
        return fruits;
    }
}
