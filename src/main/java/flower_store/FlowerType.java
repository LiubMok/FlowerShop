package flower_store;

import java.util.List;

public enum FlowerType {
    CHAMOMILE("Chamomile"),
    ROSE("Rose"),
    TULIP("Tulip");
    private String flowerType;

    FlowerType(String flowerType) {
        this.flowerType = flowerType;
    }

    @Override
    public String toString() {
        return flowerType;
    }
}
