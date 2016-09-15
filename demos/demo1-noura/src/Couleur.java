public class Couleur {
    private int rouge;
    private int vert;
    private int bleu;

    public Couleur(int rouge, int vert, int bleu) {
        setRouge(rouge);
        setVert(vert);
        setBleu(bleu);
    }

    public Couleur(Couleur c) {
        setRouge(c.getRouge());
        setBleu(c.getBleu());
        setVert(c.getVert());
    }

    public int getRouge() {
        return rouge;
    }

    public void setRouge(int rouge) {
        if (valide(rouge))
            this.rouge = rouge;
    }

    public int getVert() {
        return vert;
    }

    public void setVert(int vert) {
        if (valide(vert))
            this.vert = vert;
    }

    public int getBleu() {
        return bleu;
    }

    public void setBleu(int bleu) {
        if (valide(bleu))
            this.bleu = bleu;
    }

    private boolean valide(int valeur) {
        return (valeur >= 0 && valeur <= 255);
    }

    public String toString() {
        return "(" + rouge + "," +
                vert + "," +
                +bleu + ")";
    }

    public void blanchir() {
        rouge = (rouge + 255) / 2;
        bleu = (bleu + 255) / 2;
        vert = (vert + 255) / 2;
    }
} // Couleur