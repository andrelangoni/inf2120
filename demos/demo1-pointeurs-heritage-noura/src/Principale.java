public class Principale {
    public static void main(String[] args) {

    Bien b[]= new Bien [3];
        Legume patate = new Legume(3.99) ;
        Livre francais= new Livre (14.99);
        Meuble chaise=  new Meuble (25.99);

        Bien[] tableau= {patate,francais,chaise};

        System.out.println(facture(tableau));



    }

    public static double facture(Bien[] tableau){
        double total = 0;
        Bien b;

        for(int i=0; i<tableau.length;++i) {
            b = tableau[i];
            //total = total + b.prix();
            total += b.prix();
        }
        return total;
    }
}
