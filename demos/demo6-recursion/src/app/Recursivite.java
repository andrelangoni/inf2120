package app;

import services.IRecursivite;
import services.RecursiviteException;

public class Recursivite implements IRecursivite {
  @Override
  public int additionner(int nombre, int nFois) throws RecursiviteException {
    // Cas de base
    if (nFois == 1) {
      return nombre;
    } // if

    if (nFois < 1) {
      throw new RecursiviteException("nFois invalide");
    } // if

    return nombre + additionner(nombre, --nFois);
  } // additionner()

  @Override
  public int pgcd(int n, int m) {
    if (m == 0) {
      return n;
    } // if

    return pgcd(m, n % m);
  } // pgcd()
} // Recursivite