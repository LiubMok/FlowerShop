package flower_store;
import java.util.List;

public interface IInventory {
    List<FlowerPack> getAllFlowerPacks();
    void addFlowerPack(FlowerPack flowerPack);
    boolean isExist(FlowerPack flowerPack);
    FlowerPack getFlowerPack(FlowerPack flowerPack);
}
