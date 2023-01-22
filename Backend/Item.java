public class Item {
    private String name;
    private String healingProperty;


    public Item(String name, String healingProperty) {
        this.name = name;
        this.healingProperty = healingProperty;
    }


    public String getHealingProperty() {
        return healingProperty;
    }

    public String getName() {
        return name;
    }


    public static Item[] generateItems() {
        String[] allItemNames = {"Antidote", "Awakening", "Burn Heal", "Full Heal", "Ice Heal", "Paralyze Heal", "Persim Berry"};
        String[] allHealingProperties = {"Poisoned", "Sleeping", "Burning", "All", "Frozen", "Paralysed", "Confused"};
        Item[] x = new Item[7];
        for (int i = 0; i < allItemNames.length; i++) {
            x[i] = new Item(allItemNames[i], allHealingProperties[i]);
        }

        return x;
    }

    public boolean equals(Item e) {
        if (this.name == e.name) {
            return true;
        }
        return false;
    }

    public boolean equals(Status e) {
        if (this.healingProperty.equals(e.getName())) {
            return true;
        }
        return false;
    }



    
}
