package service;

public interface IListe<T> {
    /**
     * @return true si la liste est vide, false autrement
     */
    public boolean estVide();
    /**
     * @return la taille de la liste
     */
    public int taille();
    /**
     * @return le premier element de la liste
     * @throws ListeException si liste vide
     */
    public T debut();
    /**
     * @return le dernier element de la liste
     * @throws ListeException si liste vide
     */
    public T fin() throws ListeException;
    /**
     * @return l'element de cette postion
     * @throws ListeException si position < 0 || position >= taille
     */
    public T elementPosition(int position) throws ListeException;
    /**
     * @param element l'element d’insertion
     */
    public void insererDebut(T element) throws ListeException;
    /**
     * @param element l'element d’insertion
     */
    public void insererFin(T element) throws ListeException;

    /**
     * @param element l'element d’insertion
     * @param pos position d’insertion
     * @throws ListeException si position < 0 || position >= taille
     */
    public void insererPosition(T element, int position) throws ListeException;
    /**
     * @return le premier element de la liste qui est remplacé
     * @throws ListeException si la liste est vide
     */
    public T modifierDebut(T element) throws ListeException;
    /**
     * @return le dernier element de la liste remplacé
     * @throws ListeException si la liste est vide
     */
    public T modifierFin(T element) throws ListeException;
    /**
     * Remplace et retourne l’element se trouvant à cette postion.
     * @throws ListeException si position < 0 || position >= taille
     */
    public T modifierPosition(T element, int position) throws ListeException;
} // IListe