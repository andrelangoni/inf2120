package cours1Clone;

public class Main {

    public static void main(String[] args) {
        Fraction f1 = new Fraction(1, 2);
        int x = f1.getNum();
        x = 2;

        println("f1 num = " + String.valueOf(f1.getNum()));

        Fraction f2 = new Fraction(3, 4);
        Fraction f3 = f1.add(f2);
        println("f3 : " + f3.getNum() + " " + f3.getDenum());

        Fraction f4 = Fraction.un;
        f4.setDenum(2);
        println("" + f4.getDenum());

        Fraction f5 = (new Fraction(3)).add(Fraction.un);
        println("f5 : " + f5.getNum() + " " + f5.getDenum());

        Fraction f6 = new Fraction(f3);
        println("f3 : " + f3.getNum() + " " + f3.getDenum());
        println("f6 : " + f6.getNum() + " " + f6.getDenum());

        f6.setNum(1);
        f6.setDenum(1);
        println("f3 : " + f3.getNum() + " " + f3.getDenum());
        println("f6 : " + f6.getNum() + " " + f6.getDenum());
    } // main()

    public static void println(String s) {
        System.out.println(s);
    } // println()
} // Main