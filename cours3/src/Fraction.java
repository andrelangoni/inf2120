public class Fraction {
    int num;
    int denum;

    public Fraction(int num, int denum) {
        this.num = num;
        this.denum = denum;
    } // Fraction

    @Override
    public String toString() {
        return String.valueOf(num) + " / " + String.valueOf(denum);
    } // toString()

    @Override
    public boolean equals(Object obj) {
        boolean sontEgaux = false;

        if ((null != obj) || (obj instanceof Fraction)) {
            Fraction temp = (Fraction) obj;
            sontEgaux = ((num * temp.denum) == (denum * temp.num));
            //return super.equals(obj);
        } // if

        return sontEgaux;
    } //equals()
} // Fraction