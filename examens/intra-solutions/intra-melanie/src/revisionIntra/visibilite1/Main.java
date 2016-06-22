package revisionIntra.visibilite1;

import revisionIntra.visibilite2.C;
import revisionIntra.visibilite2.D;

public class Main {
    public static void main(String[] args) {
        B b = new B();
        C c = new C();
        D d = new D();
        E e = new E();
        B.b = false;
        B.s = "dans le meme package";
    }
}
