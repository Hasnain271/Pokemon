public class Item {
    private String name;
    private String healingProperty;


    public Item(String name, String healingProperty) {
        this.name = name; // Name of the item
        this.healingProperty = healingProperty; // The status that the item heals
    }

    public Item(String name) {
        this.name = name;
    }


    
    /** 
     * Get the healing property of the item
     * @return String
     */
    public String getHealingProperty() {
        return healingProperty;
    }

    
    /** 
     * Get the name of the item
     * @return String
     */
    public String getName() {
        return name;
    }


    
    /** 
     * Generate all the items into an array
     * @return Item[]
     */
    public static Item[] generateItems() {
        String[] allItemNames = {"Antidote", "Awakening", "Burn Heal", "Full Heal", "Ice Heal", "Paralyze Heal", "Persim Berry"};
        String[] allHealingProperties = {"Poisoned", "Sleeping", "Burning", "All", "Freezing", "Paralysed", "Confused"};
        Item[] x = new Item[7];
        for (int i = 0; i < allItemNames.length; i++) {
            x[i] = new Item(allItemNames[i], allHealingProperties[i]);
        }

        return x;
    }

    
    /** 
     * Check if one items name is equal to another items name
     * @param e
     * @return boolean
     */
    public boolean equals(Item e) {
        if (this.name == e.name) {
            return true;
        }
        return false;
    }

    
    /** 
     * Check if the healing property of the item equals to the name of the status
     * @param e
     * @return boolean
     */
    public boolean equals(Status e) {
        if (this.healingProperty.equals(e.getName())) {
            return true;
        }
        return false;
    }



    
}
