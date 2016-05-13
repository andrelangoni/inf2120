package typeGenerique;

public class QQChose <T> extends PeutEtre<T> {
    private T valeur;

    public QQChose(T valeur) {
        this.valeur = valeur;
    } // QQChose(

    public boolean estQQChose() {
        return true;
    } // estQQChose()

    public boolean estRien() {
        return false;
    } // estRien()

    public T qQChose() throws ARien {
        return valeur;
    } // qQChose()
} // QQChose