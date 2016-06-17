package miniTest;

import org.junit.Test;

import static org.junit.Assert.*;

/** question 4*/
public class PieceEchecTest {
    @Test
    public void equals() throws Exception {
        PieceEchec piece = new PieceEchec(PieceEchec.Couleur.BLANC, PieceEchec.Type.CAVALIERS);
        PieceEchec piece2 = new PieceEchec(PieceEchec.Couleur.BLANC, PieceEchec.Type.CAVALIERS);
        PieceEchec piece3 = new PieceEchec(PieceEchec.Couleur.NOIR, PieceEchec.Type.CAVALIERS);
        PieceEchec piece4 = new PieceEchec(PieceEchec.Couleur.NOIR, PieceEchec.Type.DAME);

        System.out.println(PieceEchec.Couleur.BLANC + " = " + String.valueOf(PieceEchec.Couleur.BLANC.ordinal()));
        System.out.println(PieceEchec.Couleur.NOIR + " = " + String.valueOf(PieceEchec.Couleur.NOIR.ordinal()));

        assertEquals(true, piece.equals(piece2));
        assertEquals(false, piece.equals(piece3));
        assertEquals(false, piece3.equals(piece4));
    } // equals()

} // PieceEchecTest