package flower_store;


public class Order {
    private FlowerBucket order = new FlowerBucket();
    private final IInventory inventory;
    private int budget;

    public Order(IInventory inventory, int budget) {
        this.inventory = inventory;
        this.budget = budget;
    }

    public int setFlowerToOrder(FlowerPack flowerPack) {
        if (inventory.isExist(flowerPack)) {
            this.order.add(flowerPack);
            budget -= flowerPack.getPrice();
            return budget;
        }
        return 0;
    }

    public FlowerBucket getOrder() {
        return order;
    }
}
