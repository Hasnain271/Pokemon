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

        items = generateRandomItems();
        while (items.get(0).equals(items.get(1)) || items.get(0).equals(items.get(2)) || items.get(0).equals(items.get(3)) || items.get(1).equals(items.get(2)) || items.get(1).equals(items.get(3)) || items.get(2).equals(items.get(3))) {
            items = generateRandomItems();
        }

    }


    private ArrayList<Item> generateRandomItems() {
        Item[] allItems = Item.generateItems();
        Random generator = new Random();
        ArrayList<Item> t = new ArrayList<Item>();

        for (int i = 0; i < 4; i++) {
            t.add(allItems[generator.nextInt(7)]);
        }

        return t;
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
