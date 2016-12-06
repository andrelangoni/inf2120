public class TaxeSimple extends Bien {
    public TaxeSimple(double prixEtalage) {
        super(prixEtalage);
    }
    public double prix(){
        return prixEtalage * 1.05;
    }
}
