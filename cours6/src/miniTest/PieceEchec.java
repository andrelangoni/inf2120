package miniTest;

public class PieceEchec {
    enum Couleur {BLANC, NOIR}; // BLANC = 0; NOIR = 1; (on peut les utiliser comme des int)
    enum Type {ROI, DAME, FOUS, CAVALIERS, TOURS, PIONS};
    Couleur c;
    Type t;

    public PieceEchec(Couleur c, Type t) {
        this.c = c;
        this.t = t;
    } // PieceEchec()

    @Override
    public boolean equals(Object obj) {
        boolean b = false;

        if (obj instanceof PieceEchec) {
            PieceEchec piece = (PieceEchec) obj;
            b = ((piece.t == t) && (piece.c == c));
        } // if

        return b;
    } // equals()
} // PieceEchec
