package recherche;

public interface IRechercheBinaire {
  /**
   * Effectue une recherche binaire (Dichotomique) sous la
   * forme iterative
   *
   * @param liste            : La liste dans laquelle la recherche est
   *                         faite
   * @param valeurRecherchee : La valeure que l'on souhaire
   *                         trouvee dans la liste
   * @return la position de valeurRecherchee ou -1 si la
   * valeur introuvable dans la liste
   */
  int rechercheBinaireIterative(String[] liste, String valeurRecherchee);

  /**
   * Effectue une recherche binaire (Dichotomique) sous la
   * forme recursive
   *
   * @param liste            : La liste dans laquelle la recherche est
   *                         faite
   * @param valeurRecherchee : La valeure que l'on souhaire
   *                         trouvee dans la liste
   * @param depart           : Position de depart
   * @param fin:             Position de fin
   * @return la position de valeurRecherchee
   * @throws RechercheBinaireException: Lance une exception
   *                                    si la valeure est introuvable
   */
  int rechercheBinaireRecursive(String[] liste, String valeurRecherchee, int depart, int fin)
      throws RechercheBinaireException;
} // IRechercheBinaire