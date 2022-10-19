package flower_store;

import java.util.ArrayList;

public class FlowerBucket {
    private ArrayList<FlowerPack> arr = new ArrayList<FlowerPack>();
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
