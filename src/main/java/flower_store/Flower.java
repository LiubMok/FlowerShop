package flower_store;
import lombok.Setter;
import lombok.Getter;

public class Flower {
    @Setter @Getter
    private double sepalLength;
    @Setter
    private FlowerColor color;
    @Setter @Getter
    private int price;
    public String getColor() {
        return color.toString();
    }
}
