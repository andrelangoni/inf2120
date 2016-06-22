package question6;

public class Main {
  static String s = "FRA+C*+1208++*9*2**+0*1+";

  public static void main(String[] args) {
    questionPileFile(s);
  }

  // contient 24 caractères dont 6 * et 6 +
  public static void questionPileFile(String s) {
    Pile<Character> p = new Pile<Character>();
    File<Character> f = new File<Character>();
    for (int i = 0; i < s.length(); ++i) {
      char c = s.charAt(i);
      if (c == '*' && !p.isEmpty()) {
        System.out.print(p.depiler());
      } else if (c == '+' && !f.isEmpty()) {
        System.out.print(f.defiler());
      } else {
        p.empiler(c);
        f.enfiler(c);
      } // else
    } // for
  } // questionPileFile()
} // Main
