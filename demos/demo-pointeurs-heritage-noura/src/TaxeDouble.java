public class TaxeDouble extends Bien {
    public TaxeDouble(double prixEtalage) {
        super(prixEtalage);
    }
    public double prix() {
        return prixEtalage *1.05 *1.09975;


    }

}

