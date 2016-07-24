package techniquesTri;


import java.util.Arrays;

/**
 * La classe TechniquesTri repr�sente quelques techniques
 * de tri.
 * <p>
 * Universit� du Qu�bec � Montr�al
 * INF2120 - Programmation II
 *
 * @author Ismael Doukoure
 * @version Avril 2011
 *          Modifi� en Avril 2014
 */
public class TechniquesTri<T extends Comparable<T>> {
  private static TechniquesTri<Integer> trieuse = new TechniquesTri<Integer>();

  /**
   * Cette m�thode trie les �l�ments du tableau selon la strat�gie
   * du tri par s�lection.
   * <p>
   * Le tri par s�l�ction consiste � trouver le plus petit �l�ment et
   * � l'�changer avec le premier �l�ment du tableau, puis �
   * recommencer avec le sous-tableau qui commence � la deuxi�me
   * entr�e et ainsi de suite.
   *
   * @param tableauAtrier Le tableau � trier
   */
  public void triSelection(T[] tableauAtrier) {
    int minIndice;
    T temp;

    for (int i = 0; i < tableauAtrier.length - 1; i++) {
      minIndice = i;
      // Recherche du plus petit �l�ment dans le reste du tableau
      for (int j = i + 1; j < tableauAtrier.length; j++) {
        if (tableauAtrier[j].compareTo(tableauAtrier[minIndice]) < 0) {
          minIndice = j;
        } // if
      } // for
      // �changer le premier �l�ment non tri� et le plus petit �l�ment
      if (i != minIndice) {
        temp = tableauAtrier[minIndice];
        tableauAtrier[minIndice] = tableauAtrier[i];
        tableauAtrier[i] = temp;
      } // if

      // Affiche le contenu du tableau apr�s it�ration de la boucle interne
      System.out.println(" It�ration  " + (i + 1) + " : " + Arrays.asList(tableauAtrier));
    } // for

  } // triSelection()

  /**
   * Cette m�thode trie les �l�ments du tableau selon la strat�gie
   * du tri � bulles.
   * <p>
   * Le tri � bulles consiste � comparer les deux premiers
   * �l�ments du tableau et � les ordonner puis � recommencer avec les �l�ments
   * 2 et 3, et ainsi de suite
   *
   * @param tableauAtrier Le tableau � trier
   */
  public void triABulles(T[] tableauAtrier) {
    T temp;
    int taille = tableauAtrier.length;
    for (int indice = taille - 1; indice >= 0; indice--) {
      for (int indiceRecherche = 0; indiceRecherche <= indice - 1; indiceRecherche++) {
        // Trouve le plus grand �l�ment et le d�place vers la fin du tableau par permutations
        if (tableauAtrier[indiceRecherche].compareTo(tableauAtrier[indiceRecherche + 1]) > 0) {
          // �changer les �l�ments adjacents s'ils ne sont pas dans l'ordre naturel
          temp = tableauAtrier[indiceRecherche];
          tableauAtrier[indiceRecherche] = tableauAtrier[indiceRecherche + 1];
          tableauAtrier[indiceRecherche + 1] = temp;
        }
      }

      System.out.println(" Iteration " + (taille - indice) + " : " + Arrays.asList(tableauAtrier));
    }
  }

  /**
   * Cette m�thode trie les �l�ments du tableau selon la strat�gie
   * du tri par insertion.
   * <p>
   * <ul>
   * <li>Comparer les �l�ments 1 et 2 du tableau et les ordonner
   * s�ils ne sont pas dans l�ordre naturel ;</li>
   * <li>Ins�rer le 3e �l�ment dans une position appropri�e par
   * rapport aux 2 �l�ments d�j� tri�s ;</li>
   * <li>Ins�rer le 4e �l�ment dans une position appropri�e par
   * rapport aux 3 �l�ments d�j� tri�s ;</li>
   * <li>R�p�ter l�op�ration pr�c�dente jusqu�� la fin du tableau.</li>
   * </ul>
   *
   * @param tableauAtrier Le tableau � trier
   */
  public void triInsertion(T[] tableauAtrier) {

    for (int indice = 1; indice < tableauAtrier.length; indice++) {
      T valeur = tableauAtrier[indice];// Mettre le premier �l�ment non tri� dans la variable valeur.
      int position = indice;

      while (position > 0 && tableauAtrier[position - 1].compareTo(valeur) > 0) {
        tableauAtrier[position] = tableauAtrier[position - 1];
        // On recule dans la partie tri�e pour faciliter
        // le d�calage des �l�ments plus grands.
        position--;
      }

      // On place l'�l�ment � la position correcte dans la partie tri�e.
      tableauAtrier[position] = valeur;

      System.out.println(" It�ration " + indice + " : " + Arrays.asList(tableauAtrier));
    }
  }

  /**
   * Cette m�thode trie les �l�ments du tableau selon la strat�gie
   * du tri QuickSort.
   * <p>
   * <ul>
   * <li>Choisir un �l�ment dans le tableau pour jouer le r�le du pivot
   * (Exemple le premier �l�ment) ;</li>
   * <li>Diviser le tableau � trier en 2 sous-tableaux tels que tous les
   * �l�ments du 1er  sous-tableau soient inferieur ou �gale au pivot
   * et les �l�ments du 2e sous-tableau soient superieur au pivot. Le pivot
   * est alors dans sa place d�finitive.</li>
   * <li>R�p�ter les m�mes op�rations sur les deux sous listes jusqu��
   * obtenir des tableaux r�duits � un seul �l�ment.</li>
   * </ul>
   *
   * @param tableauAtrier Tableau � trier
   * @param debut         Indice de d�but du tableau
   * @param fin           Indice de fin du tableau
   */
  public void quickSort(T[] tableauAtrier, int debut, int fin) {

    int droit = debut + 1; // Curseur allant vers la droite
    int gauche = fin; // Curseur allant vers la gauche
    T valeurPivot; // Pivot de la partition
    T temp;  // pour les �changes

    if (debut < fin) {
      valeurPivot = tableauAtrier[debut];
      System.out.println("\nPartition � trier " + Arrays.asList(Arrays.copyOfRange(tableauAtrier, debut, fin + 1)));
      System.out.println("Valeur du pivot : " + valeurPivot);

      do {
        // Deplacement du curseur DROIT vers la droite � la recherche
        // d'une valeur plus grande que la valeur pivot.
        while (droit <= gauche && tableauAtrier[droit].compareTo(valeurPivot) <= 0) {
          droit = droit + 1;
        }
        // Deplacement du curseur GAUCHE vers la gauche � la recherche
        // d'une valeur plus petite que la valeur pivot.
        while (droit <= gauche && tableauAtrier[gauche].compareTo(valeurPivot) > 0) {
          gauche = gauche - 1;
        }

        if (droit < gauche) {
          // �changer les �l�ments sur lesquels gauche et droit se sont arr�t�s
          System.out.println("    �change : " + tableauAtrier[droit] + " <--> " + tableauAtrier[gauche]);
          temp = tableauAtrier[gauche];
          tableauAtrier[gauche] = tableauAtrier[droit];
          tableauAtrier[droit] = temp;
          droit = droit + 1;
          gauche = gauche - 1;
        }
      } while (droit <= gauche);// while

      // d�placer la valeur du pivot au point de partition (ou gauche s'est arr�t�)
      temp = tableauAtrier[gauche];
      tableauAtrier[gauche] = tableauAtrier[debut];
      tableauAtrier[debut] = temp;

      // Afficher le resultat du partitionnement
      System.out.println("\nR�sultat du partitionnement");
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

      // La valeur du point de partition (pivot) est donn�e par le curseur gauche. Trier ensuite de part et d'autre du pivot.
      quickSort(tableauAtrier, debut, gauche - 1);// partition de gauche
      quickSort(tableauAtrier, gauche + 1, fin);// partition de droite

    } else if (debut == fin) {
      System.out.println("\nPartition � trier [" + tableauAtrier[debut] + "]");
    } else {
      System.out.println("\nPartition � trier []");
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

  // Appel de main pour tester les diff�rentes techniques de tri
  public static void main(String[] args) {
    triSelection();
    Integer[] tableauAtrier;

    //tableauAtrier = new Integer[]{9, 6, 8, 12, 3, 1, 7};
    tableauAtrier = new Integer[]{51, 8, 21, 52, 26, 28, 57, 3, 99, 46, 38, 16, 34, 42, 68};
    System.out.println("***************************************");
    System.out.println("|        D�but Tri � bulles           |");
    System.out.println("***************************************");

    System.out.println("Tableau � trier : " + Arrays.asList(tableauAtrier));
    System.out.println();

    trieuse.triABulles(tableauAtrier);

    System.out.println();
    System.out.println("Tableau tri� : " + Arrays.asList(tableauAtrier));

    System.out.println("***************************************");
    System.out.println("|         Fin Tri � bulles            |");
    System.out.println("***************************************");

    //tableauAtrier = new Integer[]{9, 6, 8, 12, 3, 1, 7};
    tableauAtrier = new Integer[]{51, 8, 21, 52, 26, 28, 57, 3, 99, 46, 38, 16, 34, 42, 68};
    System.out.println("***************************************");
    System.out.println("|        D�but Tri par insertion      |");
    System.out.println("***************************************");

    System.out.println("Tableau � trier : " + Arrays.asList(tableauAtrier));
    System.out.println();

    trieuse.triInsertion(tableauAtrier);

    System.out.println();
    System.out.println("Tableau tri� : " + Arrays.asList(tableauAtrier));

    System.out.println("***************************************");
    System.out.println("|         Fin Tri par insertion       |");
    System.out.println("***************************************");


    tableauAtrier = new Integer[]{90, 65, 7, 305, 120, 110, 8};
    //tableauAtrier = new Integer[]{51, 8, 21, 52, 26, 28, 57, 3, 99, 46, 38, 16, 34, 42, 68};
    System.out.println("***************************************");
    System.out.println("|        D�but Tri QuickSort          |");
    System.out.println("***************************************");

    System.out.println("Tableau � trier : " + Arrays.asList(tableauAtrier));
    System.out.println();

    trieuse.quickSort(tableauAtrier, 0, tableauAtrier.length - 1);

    System.out.println();
    System.out.println("Tableau tri� : " + Arrays.asList(tableauAtrier));

    System.out.println("***************************************");
    System.out.println("|         Fin Tri QuickSort           |");
    System.out.println("***************************************");

  }

  private static void triSelection() {
    Integer[] tableauAtrier = new Integer[]{51, 8, 21, 52, 26, 28, 57, 3, 99, 46, 38, 16, 34, 42, 68};
    System.out.println("**********************************");
    System.out.println("|     D�but Tri s�lection        |");
    System.out.println("**********************************");

    System.out.println("Tableau � trier : " + Arrays.asList(tableauAtrier));
    System.out.println();

    trieuse.triSelection(tableauAtrier);

    System.out.println();
    System.out.println("Tableau tri� : " + Arrays.asList(tableauAtrier));

    System.out.println("**********************************");
    System.out.println("|     Fin Tri s�lection          |");
    System.out.println("**********************************");
  }
}

