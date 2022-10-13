package flower_store;
import lombok.Getter;
import lombok.Setter;



public enum FlowerColor{
    RED("#FF0000"), BLUE("#00000FF");
    private String stringRepresentation;

    FlowerColor(String stringRepresantation){
        this.stringRepresentation = stringRepresantation;
    }
    @Override
    public String toString(){
        return stringRepresentation;
    }
}
