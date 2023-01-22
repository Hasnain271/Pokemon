import java.util.Random;
import java.util.ArrayList;

public class Bag {
    private ArrayList<Item> items = new ArrayList<Item>();


    public Bag() {
        generateBag();
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    public void generateBag() {

        generateRandomItems();
        while (items.get(0).equals(items.get(1)) || items.get(0).equals(items.get(2)) || items.get(0).equals(items.get(3)) || items.get(1).equals(items.get(2)) || items.get(1).equals(items.get(3)) || items.get(2).equals(items.get(3))) {
            generateRandomItems();
        }

    }


    private void generateRandomItems() {
        Item[] allItems = Item.generateItems();
        Random generator = new Random();

        for (int i = 0; i < 4; i++) {
            items.add(allItems[generator.nextInt(7)]);
        }
    }

    public void removeItem(Item e) {
        items.remove(e);
    }




    public static void main(String[] args) {
        Bag x = new Bag();
        for (Item e : x.getItems()) {
            System.out.println(e.getName());
        }
    }
}
