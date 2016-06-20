package question1.intra;

public class Test {
  private static int entier = 0;
  static protected String chaine = "";
  static double reel = 0d;
  public static char c = '0';

  public Test() {
  }

  public Test(int entier, String chaine, double reel, char c) {
    this.entier = entier;
    this.chaine = chaine;
    this.reel = reel;
    this.c = c;
  }

  public class Test5 {
    int i = entier;
    String s = chaine;
    double d = reel;
    char c2 = c;
  } // Test5
} // Test
