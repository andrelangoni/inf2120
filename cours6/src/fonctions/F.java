package fonctions;
/** f(a) = a + 2
 * f : N --> N (nombres naturels ou types)*/
public class F implements Fonction<Integer, Integer> {
    public Integer applique(Integer A) {
        return A + 2;
    }
}
