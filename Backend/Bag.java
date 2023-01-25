import java.util.Random;
import java.util.ArrayList;

public class Bag {
    private ArrayList<Item> items = new ArrayList<Item>();


    public Bag() {
        generateBag();
    }

    
    /** 
     * Get all the items in the bag
     * @return ArrayList<Item>
     */
    public ArrayList<Item> getItems() {
        return items;
    }


    /**
     * Generate the bag, with each of the four items in the bag being unique
     */
    public void generateBag() {

        items = generateRandomItems();
        // While loops ensure there are no repeats to items
        while (items.get(0).equals(items.get(1)) || items.get(0).equals(items.get(2)) || items.get(0).equals(items.get(3)) || items.get(1).equals(items.get(2)) || items.get(1).equals(items.get(3)) || items.get(2).equals(items.get(3))) {
            items = generateRandomItems();
        }

    }


    
    /** 
     * Generate random items for the bag. 
     * It is a helper method to help create 4 unique items in each bag.
     * @return ArrayList<Item>
     */
    private ArrayList<Item> generateRandomItems() {
        Item[] allItems = Item.generateItems();
        Random generator = new Random();
        ArrayList<Item> t = new ArrayList<Item>();

        for (int i = 0; i < 4; i++) {
            t.add(allItems[generator.nextInt(7)]);
        }

        return t;
    }

    
    /** 
     * Remove item from bag
     * @param e
     */
    public void removeItem(Item e) {
        items.remove(e);
    }

    
    /** 
     * Replace an item with another item
     * @param e
     * @param itemName
     */
    public void replaceItem(Item e, String itemName) {
        int index = 0;

        for (int i = 0; i < 4; i++) {
            if (e.equals(items.get(i))) {
                index = i;
            }
        }

        items.add(index, new Item(itemName));
    }
}
