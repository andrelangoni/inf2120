package question5;

public interface TDAMap<K, V> {
    /**
     * Retourne le nombre d'associations cle/valeur dans ce TDAMap.
     *
     * @return le nombre d'associations cle/valeur dans ce TDAMap.
     */
    public int taille();

    /**
     * Retourne vrai si ce TDAMap est vide, faux sinon.
     *
     * @return vrai si ce TDAMap est vide, faux sinon.
     */
    public boolean estVide();

    /**
     * Supprime toutes les associations cle/valeur de ce TDAMap. Apres l'appel
     * de cette methode, estVide() retourne vrai.
     */
    public void vider();

    /**
     * Retourne la valeur associee a la cle donnee dans ce TDAMap. Si la cle
     * donnee n'existe pas, retourne la valeur null.
     *
     * @param cle la cle de la valeur qu'on veut obtenir.
     * @return la valeur associee a la cle donnee dans ce TDAMap.
     * @throws NullPointerException si cle est null.
     */
    public V obtenir(K cle);

    /**
     * Ajoute a ce TDAMap l'association cle -> valeur donnee en parametre,
     * si cle n'existe pas deja dans ce TDAMap.
     *
     * @param cle    la cle a laquelle correspond valeur
     * @param valeur la valeur qui correspond a cle
     * @return vrai si l'association cle/valeur a ete ajoutee, faux sinon.
     * @throws NullPointerException si cle ou valeur sont null.
     */
    public boolean ajouter(K cle, V valeur);

    /**
     * Retourne vrai si ce TDAMap contient la cle donnee, faux sinon.
     *
     * @param cle la cle dont on teste l'existence.
     * @return vrai si ce TDAMap contient la cle donnee, faux sinon.
     * @throws NullPointerException si cle est null.
     */
    public boolean contientCle(K cle);

    /**
     * Retourne vrai si ce TDAMap contient au moins une valeur egale a la valeur donnee, faux sinon.
     *
     * @param valeur la valeur dont on teste l'existence.
     * @return vrai si ce TDAMap contient la valeur donnee, faux sinon.
     * @throws NullPointerException si valeur est null.
     */
    public boolean contientValeur(V valeur);

    /**
     * Supprime de ce TDAMap l'association cle/valeur pour la cle donnee, si elle
     * existe, et retourne la valeur associee a la cle donnee. Si la cle donnee
     * n'existe pas, retourne null.
     *
     * @param cle la cle de l'association cle/valeur qu'on veut retirer de ce TDAMap.
     * @return la valeur associee a la cle donnee, si cette association existait
     * avant la suppression, null sinon.
     * @throws NullPointerException si cle est null.
     */
    public V supprimer(K cle);

    /**
     * Retourne une chaine de caracteres representant ce TDAMap.
     * La chaine doit etre forme comme suit :
     * - une association cle/valeur par ligne
     * - chaque association cle/valeur indiquee comme suit : cle --> valeur
     *
     * @return
     */
    public String toString();
} // TDAMap