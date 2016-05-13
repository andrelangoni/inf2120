package typeGenerique;

public class Rien <T> extends PeutEtre<T> {

    public Rien() {

    } // Rien()

    public boolean estQQChose() {
        return false;
    } // estQQChose()

    public boolean estRien() {
        return true;
    } // estQQChose()

    public T qQChose() throws ARien {
        throw new ARien();
    } // qQChose()
} // Rien