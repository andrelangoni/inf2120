public class Fraction2 implements Eq<Fraction> {
    int num;
    int denum;

    public Fraction2(int num, int denum) {
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

        if ((null != obj) || (obj instanceof Fraction2)) {
            Fraction2 temp = (Fraction2) obj;
            sontEgaux = ((num * temp.denum) == (denum * temp.num));
            //return super.equals(obj);
        } // if

        return sontEgaux;
    } //equals()


    @Override
    public boolean sontEgaux(Fraction a_element) {
        return (num * a_element.denum) == (denum * a_element.num);
    }

} // Fraction