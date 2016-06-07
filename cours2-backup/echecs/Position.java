package echecs;

import java.lang.Math;

public class Position {
    public enum Colonne {
        A, B, C, D, E, F, G, H;

        public int distance(Colonne colonne) {
            return Math.abs(ordinal() - colonne.ordinal());
        } // distance()
    } // Colonne


} // Position