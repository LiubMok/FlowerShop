package flower_store;

import java.util.ArrayList;

public class Store {
    ArrayList<FlowerBucket> inventory = new ArrayList<>();

    public void add(FlowerBucket flowerBucket) {
        inventory.add(flowerBucket);
    }

    public ArrayList<FlowerBucket> search(FlowerBucket flowerBucket) {
        ArrayList<FlowerBucket> matchingBuckets = new ArrayList<FlowerBucket>();
        for (FlowerBucket availableBucket : inventory) {
            if (availableBucket.equals(flowerBucket))
                matchingBuckets.add(availableBucket);
        }
        return matchingBuckets;
    }

    public static void main(String[] args) {
        Store flowerStore = new Store();

        // Buckets:
        // 1 - Rose x5 and Tulip x2
        Flower roseFlower = new Flower();
        roseFlower.setPrice(20);
        roseFlower.setFlowerType(FlowerType.ROSE);
        roseFlower.setSepalLength(2);
        FlowerPack rosePack = new FlowerPack(roseFlower, 5);

        Flower tulipFlower = new Flower();
        tulipFlower.setPrice(15);
        tulipFlower.setFlowerType(FlowerType.TULIP);
        tulipFlower.setSepalLength(3);
        FlowerPack tulipPack = new FlowerPack(tulipFlower, 2);

        FlowerBucket flowerBucket1 = new FlowerBucket();
        flowerBucket1.add(rosePack);
        flowerBucket1.add(tulipPack);

        flowerStore.add(flowerBucket1);

        ArrayList<FlowerBucket> searchRes = flowerStore.search(flowerBucket1);

        // search result
        int counter = 1;
        for (FlowerBucket bucket : searchRes) {
            System.out.println("Bucket " + counter);
            System.out.println(bucket);
            System.out.println("\n");
        }
    }
}