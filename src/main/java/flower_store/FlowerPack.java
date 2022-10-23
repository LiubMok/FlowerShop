package flower_store;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@AllArgsConstructor
public class FlowerPack {
    @Getter
    private final Flower flower;
    @Setter
    @Getter
    private int quantity;

    public int getPrice() {
        return flower.getPrice() * quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FlowerPack that = (FlowerPack) o;
        return flower.equals(that.flower);
    }

    @Override
    public String toString() {
        return "FlowerPack{" +
                "flower=" + flower +
                ", quantity=" + quantity +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(flower);
    }
}
