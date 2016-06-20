package question5;

import java.util.Iterator;

@SuppressWarnings("WeakerAccess")
public class Main2 {
  public static boolean existeElement(File<String> uneFile, String s) {
    boolean existe = false;
    Iterator i;
    String chaine;

    if ((uneFile != null) && !uneFile.isEmpty()) {
      // Parcourir tous les éléments de la pile du début à la fin
      i = uneFile.iterator();
      while (!existe && i.hasNext()) {
        chaine = (String) i.next();
        existe = chaine.equals(s);
      } // while
    } // if

    return existe;
  } // existeElement()

} // Main2