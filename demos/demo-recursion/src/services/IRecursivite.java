package services;

public interface IRecursivite {
  int additionner(int nombre, int nFois) throws RecursiviteException;
  int pgcd(int n, int m);
} // IRecursivite