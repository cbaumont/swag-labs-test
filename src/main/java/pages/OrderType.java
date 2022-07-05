package pages;

public enum OrderType {
    NAME_A_TO_Z("az"),
    NAME_Z_TO_A("za"),
    PRICE_HIGH_TO_LOW("hilo"),
    PRICE_LOW_TO_HIGH("lohi");

    private final String value;

    OrderType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
