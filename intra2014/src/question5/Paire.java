package question5;

public class Paire<I, J> {
    private I item1;
    private J item2;

    public Paire(I item1, J item2) {
        this.item1 = item1;
        this.item2 = item2;
    }

    public I getItem1() {
        return item1;
    }

    public J getItem2() {
        return item2;
    }

    public void setItem1(I item1) {
        this.item1 = item1;
    }

    public void setItem2(J item2) {
        this.item2 = item2;
    }

    //on suppose item1 et item2 non null ici
    public String toString() {
        return "(" + item1.toString() + ", " + item2.toString() + ")";
    }

    //on suppose item1 et item2 non null ici
    public boolean equals(Object autrePair) {
        return autrePair != null
                && this.getClass().equals(autrePair.getClass())
                && this.item1.equals(((Paire) autrePair).item1)
                && this.item2.equals(((Paire) autrePair).item2);
    } // equals()
} // Paire