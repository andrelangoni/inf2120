package app;

import services.IRecursivite;
import services.RecursiviteException;

public class NonRecursivite implements IRecursivite {
  @Override
  public int additionner(int nombre, int nFois) throws RecursiviteException {
    // Cas de base
    if (nFois == 1) {
      return nombre;
    } // if

    if (nFois < 1) {
      throw new RecursiviteException("nFois invalide");
    } // if

    int temp = nombre;
    while (nFois > 1) {
      temp += nombre;
      --nFois;
    } // if

    return temp;
  } // additionner()

  @Override
  public int pgcd(int n, int m) {
    int reste;

    do {
      reste = n % m;
      n = m;
      m = reste;
    } while (m != 0);

    return n;
  } // pgcd()
} // NonRecursivite
