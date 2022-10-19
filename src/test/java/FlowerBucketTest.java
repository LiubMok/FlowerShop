//package shop;

import flower_store.Flower;
import flower_store.FlowerBucket;
import flower_store.FlowerPack;
import flower_store.FlowerType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class FlowerBucketTest {
    private FlowerBucket flowerBucket;

    @BeforeEach
    public void init() {
        Flower flower = new Flower();
        FlowerType flowerType = FlowerType.ROSE;
        flower.setFlowerType(flowerType);
        flower.setPrice(10);
        FlowerPack flowerPack = new FlowerPack(flower, 10);
        flowerBucket = new FlowerBucket();
        flowerBucket.add(flowerPack);
    }

    @Test
    public void testPrice() {
        assertEquals(100, flowerBucket.getPrice());
    }

}
