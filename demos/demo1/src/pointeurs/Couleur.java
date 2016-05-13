package pointeurs;

public class Couleur implements Cloneable {
    public static final int MINIMUM = 0;
    public static final int MAXIMUM = 255;

    private int rouge;
    private int vert;
    private int bleu;

    public Couleur(int rouge, int vert, int bleu) {
        setRouge(rouge);
        setVert(vert);
        setBleu(bleu);
    } // pointeurs.Couleur()

    public int getRouge() {
        return rouge;
    } // getRouge()

    public void setRouge(int rouge) {
        if (couleurValide(rouge)) {
            this.rouge = rouge;
        } // if
    } // setRouge()

    public int getVert() {
        return vert;
    } // getVert()

    public void setVert(int vert) {
        if (couleurValide(vert)) {
            this.vert = vert;
        } // if
    } // setVert()

    public int getBleu() {
        return bleu;
    } // getBleu()

    public void setBleu(int bleu) {
        if (couleurValide(bleu)) {
            this.bleu = bleu;
        } // if
    } // setBleu()

    public boolean couleurValide(int couleur) {
        return ((couleur >= MINIMUM) && (couleur <= MAXIMUM));
    } // couleurValide()

    public void blanchir() {
        setRouge((rouge + MAXIMUM) / 2);
        setVert((vert + MAXIMUM) / 2);
        setBleu((bleu + MAXIMUM) / 2);
    } // blanchir()

    @Override
    public String toString() {
        return String.valueOf(rouge) + ", " + String.valueOf(vert) + ", " + String.valueOf(bleu);
    } // toString()

    @Override
    public Object clone() {
        Couleur couleur = null;

        try {
            couleur = (Couleur) super.clone();
        } catch (CloneNotSupportedException e) {
            println(e.getMessage());
        } // catch

        return couleur;
    } // clone()

    private static void println(String s) {
        System.out.println(s);
    } // println()
} // pointeurs.Couleur