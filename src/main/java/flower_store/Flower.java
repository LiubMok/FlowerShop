package flower_store;
import lombok.AllArgsConstructor;
import lombok.Setter;
import lombok.Getter;

public class Flower {
    @Setter @Getter
    private double sepalLength;
    @Setter
    private FlowerColor color;
    @Setter @Getter
    private int price;
    @Getter
    private FlowerType flowerType;
    public void setFlowerType(FlowerType flowerType) {
        this.flowerType = flowerType;
    }
    public String getColor() {
        return color.toString();
    }
}
