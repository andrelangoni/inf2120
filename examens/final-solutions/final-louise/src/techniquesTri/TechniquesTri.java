package techniquesTri;


import java.util.Arrays;

/**
 * La classe TechniquesTri représente quelques techniques
 * de tri.
 * <p>
 * Université du Québec à Montréal
 * INF2120 - Programmation II
 *
 * @author Ismael Doukoure
 * @version Avril 2011
 *          Modifié en Avril 2014
 */
public class TechniquesTri<T extends Comparable<T>> {
  private static TechniquesTri<Integer> trieuse = new TechniquesTri<Integer>();

  /**
   * Cette méthode trie les éléments du tableau selon la stratégie
   * du tri par sélection.
   * <p>
   * Le tri par séléction consiste à trouver le plus petit élément et
   * à l'échanger avec le premier élément du tableau, puis à
   * recommencer avec le sous-tableau qui commence à la deuxième
   * entrée et ainsi de suite.
   *
   * @param tableauAtrier Le tableau à trier
   */
  public void triSelection(T[] tableauAtrier) {
    int minIndice;
    T temp;

    for (int i = 0; i < tableauAtrier.length - 1; i++) {
      minIndice = i;
      // Recherche du plus petit élément dans le reste du tableau
      for (int j = i + 1; j < tableauAtrier.length; j++) {
        if (tableauAtrier[j].compareTo(tableauAtrier[minIndice]) < 0) {
          minIndice = j;
        } // if
      } // for
      // Échanger le premier élément non trié et le plus petit élément
      if (i != minIndice) {
        temp = tableauAtrier[minIndice];
        tableauAtrier[minIndice] = tableauAtrier[i];
        tableauAtrier[i] = temp;
      } // if

      // Affiche le contenu du tableau après itération de la boucle interne
      System.out.println(" Itération  " + (i + 1) + " : " + Arrays.asList(tableauAtrier));
    } // for

  } // triSelection()

  /**
   * Cette méthode trie les éléments du tableau selon la stratégie
   * du tri à bulles.
   * <p>
   * Le tri à bulles consiste à comparer les deux premiers
   * éléments du tableau et à les ordonner puis à recommencer avec les éléments
   * 2 et 3, et ainsi de suite
   *
   * @param tableauAtrier Le tableau à trier
   */
  public void triABulles(T[] tableauAtrier) {
    T temp;
    int taille = tableauAtrier.length;
    for (int indice = taille - 1; indice >= 0; indice--) {
      for (int indiceRecherche = 0; indiceRecherche <= indice - 1; indiceRecherche++) {
        // Trouve le plus grand élément et le déplace vers la fin du tableau par permutations
        if (tableauAtrier[indiceRecherche].compareTo(tableauAtrier[indiceRecherche + 1]) > 0) {
          // Échanger les éléments adjacents s'ils ne sont pas dans l'ordre naturel
          temp = tableauAtrier[indiceRecherche];
          tableauAtrier[indiceRecherche] = tableauAtrier[indiceRecherche + 1];
          tableauAtrier[indiceRecherche + 1] = temp;
        }
      }

      System.out.println(" Iteration " + (taille - indice) + " : " + Arrays.asList(tableauAtrier));
    }
  }

  /**
   * Cette méthode trie les éléments du tableau selon la stratégie
   * du tri par insertion.
   * <p>
   * <ul>
   * <li>Comparer les éléments 1 et 2 du tableau et les ordonner
   * s’ils ne sont pas dans l’ordre naturel ;</li>
   * <li>Insérer le 3e élément dans une position appropriée par
   * rapport aux 2 éléments déjà triés ;</li>
   * <li>Insérer le 4e élément dans une position appropriée par
   * rapport aux 3 éléments déjà triés ;</li>
   * <li>Répéter l’opération précédente jusqu’à la fin du tableau.</li>
   * </ul>
   *
   * @param tableauAtrier Le tableau à trier
   */
  public void triInsertion(T[] tableauAtrier) {

    for (int indice = 1; indice < tableauAtrier.length; indice++) {
      T valeur = tableauAtrier[indice];// Mettre le premier élément non trié dans la variable valeur.
      int position = indice;

      while (position > 0 && tableauAtrier[position - 1].compareTo(valeur) > 0) {
        tableauAtrier[position] = tableauAtrier[position - 1];
        // On recule dans la partie triée pour faciliter
        // le décalage des éléments plus grands.
        position--;
      }

      // On place l'élément à la position correcte dans la partie triée.
      tableauAtrier[position] = valeur;

      System.out.println(" Itération " + indice + " : " + Arrays.asList(tableauAtrier));
    }
  }

  /**
   * Cette méthode trie les éléments du tableau selon la stratégie
   * du tri QuickSort.
   * <p>
   * <ul>
   * <li>Choisir un élément dans le tableau pour jouer le rôle du pivot
   * (Exemple le premier élément) ;</li>
   * <li>Diviser le tableau à trier en 2 sous-tableaux tels que tous les
   * éléments du 1er  sous-tableau soient inferieur ou égale au pivot
   * et les éléments du 2e sous-tableau soient superieur au pivot. Le pivot
   * est alors dans sa place définitive.</li>
   * <li>Répéter les mêmes opérations sur les deux sous listes jusqu‘à
   * obtenir des tableaux réduits à un seul élément.</li>
   * </ul>
   *
   * @param tableauAtrier Tableau à trier
   * @param debut         Indice de début du tableau
   * @param fin           Indice de fin du tableau
   */
  public void quickSort(T[] tableauAtrier, int debut, int fin) {

    int droit = debut + 1; // Curseur allant vers la droite
    int gauche = fin; // Curseur allant vers la gauche
    T valeurPivot; // Pivot de la partition
    T temp;  // pour les échanges

    if (debut < fin) {
      valeurPivot = tableauAtrier[debut];
      System.out.println("\nPartition à trier " + Arrays.asList(Arrays.copyOfRange(tableauAtrier, debut, fin + 1)));
      System.out.println("Valeur du pivot : " + valeurPivot);

      do {
        // Deplacement du curseur DROIT vers la droite à la recherche
        // d'une valeur plus grande que la valeur pivot.
        while (droit <= gauche && tableauAtrier[droit].compareTo(valeurPivot) <= 0) {
          droit = droit + 1;
        }
        // Deplacement du curseur GAUCHE vers la gauche à la recherche
        // d'une valeur plus petite que la valeur pivot.
        while (droit <= gauche && tableauAtrier[gauche].compareTo(valeurPivot) > 0) {
          gauche = gauche - 1;
        }

        if (droit < gauche) {
          // Échanger les éléments sur lesquels gauche et droit se sont arrêtés
          System.out.println("    Échange : " + tableauAtrier[droit] + " <--> " + tableauAtrier[gauche]);
          temp = tableauAtrier[gauche];
          tableauAtrier[gauche] = tableauAtrier[droit];
          tableauAtrier[droit] = temp;
          droit = droit + 1;
          gauche = gauche - 1;
        }
      } while (droit <= gauche);// while

      // déplacer la valeur du pivot au point de partition (ou gauche s'est arrêté)
      temp = tableauAtrier[gauche];
      tableauAtrier[gauche] = tableauAtrier[debut];
      tableauAtrier[debut] = temp;

      // Afficher le resultat du partitionnement
      System.out.println("\nRésultat du partitionnement");
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

      // La valeur du point de partition (pivot) est donnée par le curseur gauche. Trier ensuite de part et d'autre du pivot.
      quickSort(tableauAtrier, debut, gauche - 1);// partition de gauche
      quickSort(tableauAtrier, gauche + 1, fin);// partition de droite

    } else if (debut == fin) {
      System.out.println("\nPartition à trier [" + tableauAtrier[debut] + "]");
    } else {
      System.out.println("\nPartition à trier []");
    }
  }

  public static <E extends Comparable> void triRapide_R(E[] tab, int debut, int fin) {
    if (debut < fin) { // if (fin - debut) > k { ... k appartient a [5,15]
      E pivot = tab[(debut + fin) / 2]; // (tab[debut] + tab[fin]) / 2
      int i = debut;
      int j = fin;

      // Partition
      while (i < j) {
        while ((i < j) && (tab[i].compareTo(pivot) < 0)) {
          ++i;
        } // while()
        while ((i < j) && (tab[j].compareTo(pivot) > 0)) {
          --j;
        } // while()

        E temp = tab[i];
        tab[i] = tab[j];
        tab[j] = temp;
        ++i;
        --j;
      } // while

      triRapide_R(tab, debut, i - 1);
      triRapide_R(tab, i, fin);
      // triInsertion(tab)
    } // if ... else {
    // tri insertion
    // rapide pour les petits tableaux
    // }
  } // triRapide_R()

  // Appel de main pour tester les différentes techniques de tri
  public static void main(String[] args) {
    triSelection();
    Integer[] tableauAtrier;

    //tableauAtrier = new Integer[]{9, 6, 8, 12, 3, 1, 7};
    tableauAtrier = new Integer[]{51, 8, 21, 52, 26, 28, 57, 3, 99, 46, 38, 16, 34, 42, 68};
    System.out.println("***************************************");
    System.out.println("|        Début Tri à bulles           |");
    System.out.println("***************************************");

    System.out.println("Tableau à trier : " + Arrays.asList(tableauAtrier));
    System.out.println();

    trieuse.triABulles(tableauAtrier);

    System.out.println();
    System.out.println("Tableau trié : " + Arrays.asList(tableauAtrier));

    System.out.println("***************************************");
    System.out.println("|         Fin Tri à bulles            |");
    System.out.println("***************************************");

    //tableauAtrier = new Integer[]{9, 6, 8, 12, 3, 1, 7};
    tableauAtrier = new Integer[]{51, 8, 21, 52, 26, 28, 57, 3, 99, 46, 38, 16, 34, 42, 68};
    System.out.println("***************************************");
    System.out.println("|        Début Tri par insertion      |");
    System.out.println("***************************************");

    System.out.println("Tableau à trier : " + Arrays.asList(tableauAtrier));
    System.out.println();

    trieuse.triInsertion(tableauAtrier);

    System.out.println();
    System.out.println("Tableau trié : " + Arrays.asList(tableauAtrier));

    System.out.println("***************************************");
    System.out.println("|         Fin Tri par insertion       |");
    System.out.println("***************************************");


    tableauAtrier = new Integer[]{90, 65, 7, 305, 120, 110, 8};
    //tableauAtrier = new Integer[]{51, 8, 21, 52, 26, 28, 57, 3, 99, 46, 38, 16, 34, 42, 68};
    System.out.println("***************************************");
    System.out.println("|        Début Tri QuickSort          |");
    System.out.println("***************************************");

    System.out.println("Tableau à trier : " + Arrays.asList(tableauAtrier));
    System.out.println();

    trieuse.quickSort(tableauAtrier, 0, tableauAtrier.length - 1);

    System.out.println();
    System.out.println("Tableau trié : " + Arrays.asList(tableauAtrier));

    System.out.println("***************************************");
    System.out.println("|         Fin Tri QuickSort           |");
    System.out.println("***************************************");

  }

  private static void triSelection() {
    Integer[] tableauAtrier = new Integer[]{51, 8, 21, 52, 26, 28, 57, 3, 99, 46, 38, 16, 34, 42, 68};
    System.out.println("**********************************");
    System.out.println("|     Début Tri sélection        |");
    System.out.println("**********************************");

    System.out.println("Tableau à trier : " + Arrays.asList(tableauAtrier));
    System.out.println();

    trieuse.triSelection(tableauAtrier);

    System.out.println();
    System.out.println("Tableau trié : " + Arrays.asList(tableauAtrier));

    System.out.println("**********************************");
    System.out.println("|     Fin Tri sélection          |");
    System.out.println("**********************************");
  }
}

