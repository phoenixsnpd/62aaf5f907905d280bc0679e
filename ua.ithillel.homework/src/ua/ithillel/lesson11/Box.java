package ua.ithillel.lesson11;

import java.util.ArrayList;
import java.util.List;

public class Box<T> {
    private List<T> fruits = new ArrayList<>();

    public void addOneFruit(T fruit) {
        fruits.add(fruit);
    }

    public void addManyFruits(List<T> newFruits) {
        fruits.addAll(newFruits);
    }

    public float getWeight() {
        Fruit newFruit = (Fruit) fruits.get(0);
        return newFruit.getWeight() * fruits.size();
    }

    public boolean compare (Box box) {
        if (getWeight() == box.getWeight()) {
            return true;
        } return false;
    }

    public void merge(Box<T> box) {
        fruits.addAll(box.getFruits());
    }

    public List<T> getFruits() {
        return fruits;
    }
}
