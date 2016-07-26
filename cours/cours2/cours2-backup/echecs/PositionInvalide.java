package echecs;

public class PositionInvalide extends Exception {
    static final long SERIAL_VERSION_UID = 10;

    public PositionInvalide() {
        super();
    } // PositionInvalide()

    public PositionInvalide(String message) {
        super(message);
    } // PositionInvalide()
} // PositionInvalide