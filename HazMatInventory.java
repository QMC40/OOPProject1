import java.util.ArrayList;

public class HazMatInventory {

    //NOT THREAD SAFE / SELF-SYNCHRONIZING!!!
    private ArrayList<HazMatItem> HazMatStock = new ArrayList<>();

    //another possible interface opportunity?
    //public interface HazMatInventoryAccess {}
    private ArrayList<HazMatItem> WasteInventory = new ArrayList<>();

    //refactor to implement exception handling for bad entry / boolean return
    //for entry confirmation?
    public void disposeOfWaste(HazMatItem wasteOut, int quantity) {
        WasteInventory.get(WasteInventory.indexOf(wasteOut)).quantityInStock -= quantity;
    }

    public void storeWaste(HazMatItem wasteIn, int quantity) {
        WasteInventory.get(WasteInventory.indexOf(wasteIn)).quantityInStock += quantity;
    }

    public void addHazMatItemToWasteInventory(HazMatItem gain) {
        WasteInventory.add(gain);
    }

    public void removeHazMatItemFromWasteInventory(HazMatItem loss) {
        WasteInventory.remove(loss);
    }

    public void issueInventory(HazMatItem issue, int quantity) {
        HazMatStock.get(HazMatStock.indexOf(issue)).quantityInStock -= quantity;

    }

    public void addToInventory(HazMatItem supply, int quantity) {
        HazMatStock.get(HazMatStock.indexOf(supply)).quantityInStock += quantity;
    }

    public void addHazMatItemToInventory() {
        HazMatItem gain = HazMatItem.createHazMatItem();
        HazMatStock.add(gain);
    }

    public void removeHazMatItemFromInventory(HazMatItem loss) {
        HazMatStock.remove(loss);
    }

    public String toString() {
        StringBuilder buffer = new StringBuilder();
        for (HazMatItem subj : HazMatStock) {
            System.out.println(subj.toString());
            buffer.append(subj.toString());
        }
        return buffer.toString();
    }

    //Item of Haz Mat to be inventoried
    public static class HazMatItem {

        String name;
        String stockNumber;
        HazMatCategory hazMatCategory;
        StorageArea storageArea;
        String shelfLocation;
        int quantityInStock;
        public HazMatItem(String name, String stockNumber, HazMatCategory hazMatCategory, StorageArea storageArea,
                          String shelfLocation, int stock) {
            this.name = name;
            this.stockNumber = stockNumber;
            this.hazMatCategory = hazMatCategory;
            this.storageArea = storageArea;
            this.shelfLocation = shelfLocation;
            this.quantityInStock = stock;
        }

        public static HazMatItem createHazMatItem() {
            String name = "test";
            String stockNumber = "1";
            HazMatCategory hazMatCategory = HazMatCategory.FLAMMABLE;
            StorageArea storageArea = StorageArea.COMMON;
            String shelfLocation = "A1";
            int stock = 1;
            return new HazMatItem(name, stockNumber, hazMatCategory, storageArea,
                    shelfLocation, stock);
        }

        public String toString() {
            System.out.println("test\n");
            return String.format("Name: %s%nStock number: %s%nHazardous Material Cat: %s%nStorage area: %s%n" +
                            "Shelf location: %s%nQuantity in stock: %d", getName(), getStockNumber(), getHazMatCategory(),
                    getStorageArea(), getShelfLocation(), getQuantityInStock());
        }

        //setters and getters
        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getStockNumber() {
            return stockNumber;
        }

        public void setStockNumber(String stockNumber) {
            this.stockNumber = stockNumber;
        }

        public HazMatCategory getHazMatCategory() {
            return hazMatCategory;
        }

        public void setHazMatCategory(HazMatCategory hazMatCategory) {
            this.hazMatCategory = hazMatCategory;
        }

        public StorageArea getStorageArea() {
            return storageArea;
        }

        public void setStorageArea(StorageArea storageArea) {
            this.storageArea = storageArea;
        }

        public String getShelfLocation() {
            return shelfLocation;
        }

        public void setShelfLocation(String shelfLocation) {
            this.shelfLocation = shelfLocation;
        }

        public int getQuantityInStock() {
            return quantityInStock;
        }

        public void setQuantityInStock(int quantityInStock) {
            this.quantityInStock = quantityInStock;
        }

        public enum HazMatCategory {
            TOXIC, FLAMMABLE, EXPLOSIVE, OXIDIZING, CORROSIVE, COMPRESSEDGAS,
            REACTIVE, SPECIAL, HEALTHHAZARD, ORGANICPEROXIDES
        }

        public enum StorageArea {
            COMMON, FLAMMABLELOCKER, GASCYLINDERENCLOSURE, REACTIVELOCKER, SPECIALLOCKER
        }

    }

}
