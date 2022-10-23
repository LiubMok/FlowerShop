package flower_store;

public class Main {
    public static void main(String[] args) {
        InventoryStaticStream inventory = new InventoryStaticStream();
        inventory.addFlowerPack(new FlowerPack(new Flower(40, FlowerColor.RED, 25, FlowerType.ROSE), 15));
        inventory.addFlowerPack(new FlowerPack(new Flower(40, FlowerColor.RED, 25, FlowerType.ROSE), 15));
        inventory.addFlowerPack(new FlowerPack(new Flower(40, FlowerColor.BLUE, 25, FlowerType.ROSE), 15));
        inventory.addFlowerPack(new FlowerPack(new Flower(40, FlowerColor.YELLOW, 25, FlowerType.ROSE), 15));
        inventory.addFlowerPack(new FlowerPack(new Flower(25, FlowerColor.RED, 15, FlowerType.TULIP), 15));
        inventory.addFlowerPack(new FlowerPack(new Flower(25, FlowerColor.BLUE, 15, FlowerType.TULIP), 15));
        inventory.addFlowerPack(new FlowerPack(new Flower(25, FlowerColor.YELLOW, 15, FlowerType.TULIP), 15));
        inventory.addFlowerPack(new FlowerPack(new Flower(25, FlowerColor.YELLOW, 10, FlowerType.CHAMOMILE), 15));

        SellManager sellManager = new SellManager(inventory);
        Store store = new Store(inventory, sellManager);
        store.formOrder();
    }
}

