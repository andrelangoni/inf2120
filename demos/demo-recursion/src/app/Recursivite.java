package app;

import services.IRecursivite;
import services.RecursiviteException;

public class Recursivite implements IRecursivite {
  @Override
  public int additionner(int nombre, int nbFois) throws RecursiviteException {
    // Cas de base
    if (nbFois == 1) {
      return nombre;
    } // if

    if (nbFois < 1) {
      throw new RecursiviteException("nbFois invalide");
    } // if

    return nombre + additionner(nombre, --nbFois);
  } // additionner()

  @Override
  public int pgcd(int n, int m) {
    if (m == 0) {
      return n;
    } // if

    return pgcd(m, n % m);
  } // pgcd()
} // Recursivite