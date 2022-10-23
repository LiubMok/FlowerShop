package flower_store;

import java.util.ArrayList;

public class FlowerBucket {
    @Override
    public String toString() {
        return "FlowerBucket{" +
                "arr=" + arr +
                '}';
    }

    private ArrayList<FlowerPack> arr = new ArrayList<>();
    public ArrayList<FlowerPack> getBucket() {
        return arr;
    }
    public void add(FlowerPack flowerPack) {
        this.arr.add(flowerPack);
    }

    public int getPrice() {
        int result = 0;
        for (FlowerPack element: this.arr) {
            result += element.getPrice();
        }
        return result;
    }
}
