package cours1Clone;

public class Fraction {
    private int num;
    private int denum;

    public static final Fraction un;
    public static final Fraction zero;

    // valeurs initiales par defaut
    {
        num = 0;
        denum = 1;
    }

    // valeurs initiales par defaut
    static {
        un = new Fraction(1, 1);
        zero = new Fraction(0, 1);
    }

    public Fraction(int num) {
        this.num = num;
    }

    public Fraction(int num, int denum) {
        setNum(num);
        setDenum(denum);
    }

    // Constructeur pour cloner
    public Fraction(Fraction fraction) {
        setNum(fraction.getNum());
        setDenum(fraction.getDenum());
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public int getDenum() {
        return denum;
    }

    public void setDenum(int denum) {
        this.denum = denum;
    }

    public Fraction add(Fraction fraction) {
        int num = this.num * fraction.denum + fraction.num * this.denum;
        int denum = this.denum * fraction.denum;
        return new Fraction(num, denum);
    } // add()

} // Fraction