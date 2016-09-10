package heritage.taxes;

import heritage.Bien;

public class TaxeDouble extends Bien {
    public static final double TAXE_DOUBLE = 1.09975d;

    public TaxeDouble(double prixEtalage) {
        super(prixEtalage);
    } // TaxeDouble()

    @Override
    public double prix() {
        return getPrixEtalage() * TaxeSimple.TAXE_SIMPLE * TAXE_DOUBLE;
    } // prix()
} // TaxeDouble