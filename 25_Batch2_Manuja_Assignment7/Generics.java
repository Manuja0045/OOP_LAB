// Author: Manuja Nagvekar
// Roll No.: 25
// Title: Generic Storage for Food Items
// Description: This program demonstrates the use of generics in Java 
// by creating a Storage class that can hold items of any type. 


import java.util.ArrayList;
import java.util.List;

class Storage<T> {
    private List<T> items = new ArrayList<>(); 

    public void storeItem(T item) {
        items.add(item); 
    }

    public List<T> retrieveItems() {
        return items; 
    }
}

class Food {
    private String name;

    public Food(String name) {
    this.name = name; 
    }

    @Override
    public String toString() {
    return "Food: " + name; 
}
}

public class Generics {
    public static void main(String[] args) {
        // Create a Storage instance for Food objects
        Storage<Food> foodStorage = new Storage<>();
        // Store food items
        foodStorage.storeItem(new Food("Apple"));
        foodStorage.storeItem(new Food("Banana"));
        foodStorage.storeItem(new Food("Orange"));

        // Display stored food items
        System.out.println("Stored food items:");
    for (Food food : foodStorage.retrieveItems()) {
            System.out.println(food);
        }
    }    
}