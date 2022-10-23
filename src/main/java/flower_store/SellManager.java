package flower_store;

public class SellManager {

    private final IInventory inventory;

    public SellManager(IInventory inventory) {
        this.inventory = inventory;
    }

    public void sellFlowerPack(FlowerPack flowerPack) {
        FlowerPack flowerPackForSelling = this.inventory.getFlowerPack(flowerPack);
        flowerPackForSelling.setQuantity(flowerPackForSelling.getQuantity() - flowerPack.getQuantity());
    }
}
