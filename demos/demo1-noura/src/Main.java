public class Main {
    public static void main(String[] args) {
        Couleur c1 = new Couleur(1, 4, 6);
        Couleur c2 = c1;
        Couleur c3= new Couleur(c1);

        System.out.println(c2.toString());
        c2.setRouge(100);
        c3.setVert(20);
        System.out.println(c1.toString());

        System.out.println(c2.toString());
        System.out.println(c3.toString());

        c1.blanchir();
        System.out.println( c1.toString() );
        System.out.println( c2.toString() );
    }
}

