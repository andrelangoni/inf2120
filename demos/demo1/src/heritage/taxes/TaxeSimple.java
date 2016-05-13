package heritage.taxes;

import heritage.Bien;

public class TaxeSimple extends Bien {
    public static final double TAXE_SIMPLE = 1.05d;

    public TaxeSimple(double prixEtalage) {
        super(prixEtalage);
    } // TaxeSimple()

    @Override
    public double prix() {
        return getPrixEtalage() * TAXE_SIMPLE;
    } // prix()
} // TaxeSimple