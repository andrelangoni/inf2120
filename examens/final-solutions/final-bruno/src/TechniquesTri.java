import java.util.Arrays;

/**
 * La classe TechniquesTri represente quelques techniques
 * de tri.
 * <p>
 * Universite du Quebec a Montreal
 * INF2120 - Programmation II
 *
 * @author Ismael Doukoure
 * @version Avril 2011
 *          Modifie en Avril 2014
 */
public class TechniquesTri<T extends Comparable<T>> {

  /**
   * Cette methode trie les elements du tableau selon la strategie
   * du tri par selection.
   * <p>
   * Le tri par selection consiste a trouver le plus petit element et
   * a l'echanger avec le premier element du tableau, puis a
   * recommencer avec le sous-tableau qui commence a la deuxième
   * entree et ainsi de suite.
   *
   * @param tableauAtrier Le tableau a trier
   */
  private void triSelection(T[] tableauAtrier) {

    int minIndice;
    T temp;

    for (int i = 0; i < tableauAtrier.length - 1; i++) {
      minIndice = i;
      // Recherche du plus petit element dans le reste du tableau
      for (int j = i + 1; j < tableauAtrier.length; j++) {
        if (tableauAtrier[j].compareTo(tableauAtrier[minIndice]) < 0) {
          minIndice = j;
        }
      }
      // Échanger le premier element non trie et le plus petit element
      temp = tableauAtrier[minIndice];
      tableauAtrier[minIndice] = tableauAtrier[i];
      tableauAtrier[i] = temp;

      // Affiche le contenu du tableau après iteration de la boucle interne
      System.out.println(" Iteration  " + (i + 1) + " : " + Arrays.asList(tableauAtrier));
    }

  }

  /**
   * Cette methode trie les elements du tableau selon la strategie
   * du tri a bulles.
   * <p>
   * Le tri a bulles consiste a comparer les deux premiers
   * elements du tableau et a les ordonner puis a recommencer avec les elements
   * 2 et 3, et ainsi de suite
   *
   * @param tableauAtrier Le tableau a trier
   */
  private void triABulles(T[] tableauAtrier) {
    T temp;
    int taille = tableauAtrier.length;
    for (int indice = taille - 1; indice >= 0; indice--) {
      for (int indiceRecherche = 0; indiceRecherche <= indice - 1; indiceRecherche++) {
        // Trouve le plus grand element et le deplace vers la fin du tableau par permutations
        if (tableauAtrier[indiceRecherche].compareTo(tableauAtrier[indiceRecherche + 1]) > 0) {
          // Échanger les elements adjacents s'ils ne sont pas dans l'ordre naturel
          temp = tableauAtrier[indiceRecherche];
          tableauAtrier[indiceRecherche] = tableauAtrier[indiceRecherche + 1];
          tableauAtrier[indiceRecherche + 1] = temp;
        }
      }

      System.out.println(" Iteration " + (taille - indice) + " : " + Arrays.asList(tableauAtrier));
    }
  }

  /**
   * Cette methode trie les elements du tableau selon la strategie
   * du tri par insertion.
   * <p>
   * <ul>
   * <li>Comparer les elements 1 et 2 du tableau et les ordonner
   * s’ils ne sont pas dans l’ordre naturel ;</li>
   * <li>Inserer le 3e element dans une position appropriee par
   * rapport aux 2 elements deja tries ;</li>
   * <li>Inserer le 4e element dans une position appropriee par
   * rapport aux 3 elements deja tries ;</li>
   * <li>Repeter l’operation precedente jusqu’a la fin du tableau.</li>
   * </ul>
   *
   * @param tableauAtrier Le tableau a trier
   */
  private void triInsertion(T[] tableauAtrier) {

    for (int indice = 1; indice < tableauAtrier.length; indice++) {
      T valeur = tableauAtrier[indice];// Mettre le premier element non trie dans la variable valeur.
      int position = indice;

      while (position > 0 && tableauAtrier[position - 1].compareTo(valeur) > 0) {
        tableauAtrier[position] = tableauAtrier[position - 1];
        // On recule dans la partie triee pour faciliter
        // le decalage des elements plus grands.
        position--;
      }

      // On place l'element a la position correcte dans la partie triee.
      tableauAtrier[position] = valeur;

      System.out.println(" Iteration " + indice + " : " + Arrays.asList(tableauAtrier));
    }
  }

  /**
   * Cette methode trie les elements du tableau selon la strategie
   * du tri QuickSort.
   * <p>
   * <ul>
   * <li>Choisir un element dans le tableau pour jouer le rôle du pivot
   * (Exemple le premier element) ;</li>
   * <li>Diviser le tableau a trier en 2 sous-tableaux tels que tous les
   * elements du 1er  sous-tableau soient inferieur ou egale au pivot
   * et les elements du 2e sous-tableau soient superieur au pivot. Le pivot
   * est alors dans sa place definitive.</li>
   * <li>Repeter les mêmes operations sur les deux sous listes jusqu‘a
   * obtenir des tableaux reduits a un seul element.</li>
   * </ul>
   *
   * @param tableauAtrier Tableau a trier
   * @param debut         Indice de debut du tableau
   * @param fin           Indice de fin du tableau
   */
  private void quickSort(T[] tableauAtrier, int debut, int fin) {

    int droit = debut + 1; // Curseur allant vers la droite
    int gauche = fin; // Curseur allant vers la gauche
    T valeurPivot; // Pivot de la partition
    T temp;  // pour les echanges

    if (debut < fin) {
      valeurPivot = tableauAtrier[debut];
      System.out.println("\nPartition a trier " + Arrays.asList(Arrays.copyOfRange(tableauAtrier, debut, fin + 1)));
      System.out.println("Valeur du pivot : " + valeurPivot);

      do {
        // Deplacement du curseur DROIT vers la droite a la recherche
        // d'une valeur plus grande que la valeur pivot.
        while (droit <= gauche && tableauAtrier[droit].compareTo(valeurPivot) <= 0) {
          droit = droit + 1;
        }
        // Deplacement du curseur GAUCHE vers la gauche a la recherche
        // d'une valeur plus petite que la valeur pivot.
        while (droit <= gauche && tableauAtrier[gauche].compareTo(valeurPivot) > 0) {
          gauche = gauche - 1;
        }

        if (droit < gauche) {
          // Échanger les elements sur lesquels gauche et droit se sont arrêtes
          System.out.println("    Échange : " + tableauAtrier[droit] + " <--> " + tableauAtrier[gauche]);
          temp = tableauAtrier[gauche];
          tableauAtrier[gauche] = tableauAtrier[droit];
          tableauAtrier[droit] = temp;
          droit = droit + 1;
          gauche = gauche - 1;
        }
      } while (droit <= gauche);// while

      // deplacer la valeur du pivot au point de partition (ou gauche s'est arrête)
      temp = tableauAtrier[gauche];
      tableauAtrier[gauche] = tableauAtrier[debut];
      tableauAtrier[debut] = temp;

      // Afficher le resultat du partitionnement
      System.out.println("\nResultat du partitionnement");
      if (debut <= gauche) {
        System.out.print(Arrays.asList(Arrays.copyOfRange(tableauAtrier, debut, gauche)));
      } else {
        System.out.print("[]");
      }
      System.out.print(" " + tableauAtrier[gauche] + " ");
      if (gauche <= fin) {
        System.out.println(Arrays.asList(Arrays.copyOfRange(tableauAtrier, gauche + 1, fin + 1)));
      } else {
        System.out.println("[]");
      }

      // La valeur du point de partition (pivot) est donnee par le curseur gauche. Trier ensuite de part et d'autre du pivot.
      quickSort(tableauAtrier, debut, gauche - 1);// partition de gauche
      quickSort(tableauAtrier, gauche + 1, fin);// partition de droite

    } else if (debut == fin) {
      System.out.println("\nPartition a trier [" + tableauAtrier[debut] + "]");
    } else {
      System.out.println("\nPartition a trier []");
    }
  }

  // Appel de main pour tester les differentes techniques de tri
  public static void main(String[] args) {
    TechniquesTri<Integer> trieuse = new TechniquesTri<>();

    Integer[] tableauAtrier = new Integer[]{11, 8, 6, 3, 10, 1, 9, 5, 7, 2, 14, 4, 15, 13, 12};
    System.out.println("***************************************");
    System.out.println("|        Debut Tri par insertion      |");
    System.out.println("***************************************");

    System.out.println("Tableau a trier : " + Arrays.asList(tableauAtrier));
    System.out.println();

    trieuse.triInsertion(tableauAtrier);

    System.out.println();
    System.out.println("Tableau trie : " + Arrays.asList(tableauAtrier));

    System.out.println("***************************************");
    System.out.println("|         Fin Tri par insertion       |");
    System.out.println("***************************************");

    tableauAtrier = new Integer[]{11, 8, 6, 3, 10, 1, 9, 5, 7, 2, 14, 4, 15, 13, 12};
    System.out.println("**********************************");
    System.out.println("|     Debut Tri selection        |");
    System.out.println("**********************************");

    System.out.println("Tableau a trier : " + Arrays.asList(tableauAtrier));
    System.out.println();

    trieuse.triSelection(tableauAtrier);

    System.out.println();
    System.out.println("Tableau trie : " + Arrays.asList(tableauAtrier));

    System.out.println("**********************************");
    System.out.println("|     Fin Tri selection          |");
    System.out.println("**********************************");


    tableauAtrier = new Integer[]{11, 8, 6, 3, 10, 1, 9, 5, 7, 2, 14, 4, 15, 13, 12};
    System.out.println("***************************************");
    System.out.println("|        Debut Tri a bulles           |");
    System.out.println("***************************************");

    System.out.println("Tableau a trier : " + Arrays.asList(tableauAtrier));
    System.out.println();

    trieuse.triABulles(tableauAtrier);

    System.out.println();
    System.out.println("Tableau trie : " + Arrays.asList(tableauAtrier));

    System.out.println("***************************************");
    System.out.println("|         Fin Tri a bulles            |");
    System.out.println("***************************************");


    tableauAtrier = new Integer[]{11, 8, 6, 3, 10, 1, 9, 5, 7, 2, 14, 4, 15, 13, 12};
    System.out.println("***************************************");
    System.out.println("|        Debut Tri QuickSort          |");
    System.out.println("***************************************");

    System.out.println("Tableau a trier : " + Arrays.asList(tableauAtrier));
    System.out.println();

    trieuse.quickSort(tableauAtrier, 0, tableauAtrier.length - 1);

    System.out.println();
    System.out.println("Tableau trie : " + Arrays.asList(tableauAtrier));

    System.out.println("***************************************");
    System.out.println("|         Fin Tri QuickSort           |");
    System.out.println("***************************************");

  }
}

