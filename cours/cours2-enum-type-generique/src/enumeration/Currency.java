package enumeration;

public enum Currency {
    PENNY(1),
    NICKLE(5),
    DIME(10),
    QUARTER(25);

    private int value;

    Currency(int value) {
        setValue(value);
    } // Currency()

    public int getValue() {
        return value;
    } // getValue()

    public void setValue(int value) {
        this.value = value;
    } // setValue()
} // Currency
