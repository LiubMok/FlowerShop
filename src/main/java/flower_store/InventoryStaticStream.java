package flower_store;

import java.util.ArrayList;
import java.util.List;

public class InventoryStaticStream implements IInventory {
    private static final List<FlowerPack> db = new ArrayList<>();


    @Override
    public List<FlowerPack> getAllFlowerPacks() {
//        List<FlowerPack> packs = new ArrayList<>();
//        for (Flower flower : db) {
//            packs.forEach(flowerPack -> {
//                if (flowerPack.getFlower().equals(flower)) {
//                    flowerPack.setQuantity(flowerPack.getQuantity() + 1);
//                }
//                else {
//                    packs.add(new FlowerPack(flower, 1));
//                }
//            });
//        }
        return db;
    }

    /**
     * method to add new flowerPack into our database
     */
    @Override
    public void addFlowerPack(FlowerPack flowerPack) {
        if (db.contains(flowerPack)) {
            FlowerPack flowerPack2 = db.stream().filter(flowerPack1 -> flowerPack1.equals(flowerPack)).findFirst().get();
            flowerPack2.setQuantity(flowerPack.getQuantity() + flowerPack2.getQuantity());
            db.remove(flowerPack);
            db.add(flowerPack2);
        } else {
            db.add(flowerPack);
        }
    }

    /**
     * method to find flowerPack from database
     * for searching flowerPack is used
     */
    @Override
    public FlowerPack getFlowerPack(FlowerPack flowerPack) {
        for (FlowerPack flower_Pack : db) {
            if (flower_Pack.equals(flowerPack)) {
                return flower_Pack;
            }
        }
        return null;
    }


    /**
     * method checks whether database contains such flowerPack
     */
    @Override
    public boolean isExist(FlowerPack flowers) {
        for (FlowerPack flowerPack : db) {
            if (flowerPack.equals(flowers)) {
                return true;
            }
        }
        return false;
    }
}
