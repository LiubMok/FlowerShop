package flower_store;


public enum FlowerColor {
    RED("Red"),
    BLUE("Blue"),
    YELLOW("Yellow");
    private String stringRepresentation;

    FlowerColor(String stringRepresantation) {
        this.stringRepresentation = stringRepresantation;
    }

    @Override
    public String toString() {
        return stringRepresentation;
    }


}
