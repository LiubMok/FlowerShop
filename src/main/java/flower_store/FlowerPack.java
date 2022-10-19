package flower_store;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class FlowerPack {
    private final Flower flower;
    private int quantity;

    public int getPrice(){
        return flower.getPrice()*quantity;
    }
}
