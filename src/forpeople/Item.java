package forpeople;


import enums.Items;

public class Item {
    private Items name;
    private boolean wetness;
    private boolean integrity;

    public Item(Items name) {
        this.name = name;
    }

    public Item(Items name, boolean wetness, boolean integrity) {
        this.name = name;
        this.wetness = wetness;
        this.integrity = integrity;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        Item item = (Item) obj;
        return wetness == item.wetness &&
                integrity == item.integrity &&
                name == item.name;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (wetness ? 1 : 0);
        result = 31 * result + (integrity ? 1 : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Item{" +
                "name=" + name +
                ", wetness=" + wetness +
                ", integrity=" + integrity +
                '}';
    }

    public Items getName() {
        return name;
    }

    public void setIntegrity(boolean integrity) {
        this.integrity = integrity;
    }

    public boolean isIntegrity() {
        return integrity;
    }

    public boolean getWetness() {
        return wetness;
    }

    public void setWetness(boolean wetness) {
        System.out.println("Веревка пропталась кровью");
        this.wetness = wetness;
    }


}
