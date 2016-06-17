package question5;

import java.util.ArrayList;

public class MapArrayList<K,V> implements TDAMap {
    ArrayList<Paire<K,V>> list;

    public MapArrayList() {
        list = new ArrayList<>();
    } // MapArrayList()

    /**
     * Retourne le nombre d'associations cle/valeur dans ce TDAMap.
     *
     * @return le nombre d'associations cle/valeur dans ce TDAMap.
     */
    @Override
    public int taille() {
        return list.size();
    } // taille()

    /**
     * Retourne vrai si ce TDAMap est vide, faux sinon.
     *
     * @return vrai si ce TDAMap est vide, faux sinon.
     */
    @Override
    public boolean estVide() {
        return taille() == 0;
    } // estVide()

    /**
     * Supprime toutes les associations cle/valeur de ce TDAMap.
     * Apres l'appel
     * de cette methode, estVide() retourne vrai.
     */
    @Override
    public void vider() {
        list.clear();
    } // vider()

    /**
     * Retourne la valeur associee a la cle donnee dans ce TDAMap.
     * Si la cle
     * donnee n'existe pas, retourne la valeur null.
     *
     * @param cle la cle de la valeur qu'on veut obtenir.
     * @return la valeur associee a la cle donnee dans ce TDAMap.
     * @throws NullPointerException si cle est null.
     */
    @Override
    public Object obtenir(Object cle) throws NullPointerException {
        Paire paire;
        Object cleCourante;
        Object valeur = null;
        boolean chercheCle = true;

        if (cle == null) {
            throw new NullPointerException();
        } // if

        for (int i = 0; chercheCle && (i < taille()); i++) {
            paire = list.get(i);
            cleCourante = paire.getItem1();
            if (cleCourante.equals(cle)) {
                valeur = paire.getItem2();
                chercheCle = false;
            } // if
        } // for

        return valeur;
    } // obtenir()

    /**
     * Ajoute a ce TDAMap l'association cle -> valeur donnee en
     * parametre,
     * si cle n'existe pas deja dans ce TDAMap.
     *
     * @param cle    la cle a laquelle correspond valeur
     * @param valeur la valeur qui correspond a cle
     * @return vrai si l'association cle/valeur a ete ajoutee,
     * faux sinon.
     * @throws NullPointerException si cle ou valeur sont null.
     */
    @Override
    public boolean ajouter(Object cle, Object valeur)
            throws NullPointerException {
                Paire paire;
                boolean ajoute = !contientCle(cle);

                if (ajoute) {
                    paire = new Paire<>(cle, valeur);
                    list.add(paire);
                } // if

                return ajoute;
    } // ajouter()

    /**
     * Retourne vrai si ce TDAMap contient la cle donnee, faux sinon.
     *
     * @param cle la cle dont on teste l'existence.
     * @return vrai si ce TDAMap contient la cle donnee, faux sinon.
     * @throws NullPointerException si cle est null.
     */
    @Override
    public boolean contientCle(Object cle) throws NullPointerException {
        Paire paire;
        Object cleCourante;
        boolean chercheCle = true;

        if (cle == null) {
            throw new NullPointerException();
        } // if

        for (int i = 0; chercheCle && (i < taille()); i++) {
            paire = list.get(i);
            cleCourante = paire.getItem1();
            chercheCle = !cleCourante.equals(cle);
        } // for

        return !chercheCle;
    } // contientCle()

    /**
     * Retourne vrai si ce TDAMap contient au moins une valeur egale a
     * la valeur donnee, faux sinon.
     *
     * @param valeur la valeur dont on teste l'existence.
     * @return vrai si ce TDAMap contient la valeur donnee, faux sinon.
     * @throws NullPointerException si valeur est null.
     */
    @Override
    public boolean contientValeur(Object valeur)
            throws NullPointerException {
                Paire paire;
                Object valeurCourante;
                boolean trouveValeur = false;

                if (valeur == null) {
                    throw new NullPointerException();
                } // if

                for (int i = 0; !trouveValeur && (i < taille()); i++) {
                    paire = list.get(i);
                    valeurCourante = paire.getItem2();
                    trouveValeur = valeurCourante.equals(valeur);
                } // for

                return trouveValeur;
    } // contientValeur()

    /**
     * Supprime de ce TDAMap l'association cle/valeur pour la cle donnee, si elle
     * existe, et retourne la valeur associee a la cle donnee. Si la
     * cle donnee
     * n'existe pas, retourne null.
     *
     * @param cle la cle de l'association cle/valeur qu'on veut retirer
     *            de ce TDAMap.
     * @return la valeur associee a la cle donnee, si cette
     * association existait
     * avant la suppression, null sinon.
     * @throws NullPointerException si cle est null.
     */
    @Override
    public Object supprimer(Object cle) {
        Paire paire;
        Object cleCourante;
        Object valeur = null;
        boolean trouveCle = false;

        if (cle == null) {
            throw new NullPointerException();
        } // if

        for (int i = 0; (!trouveCle) && (i < taille()); i++) {
            paire = list.get(i);
            cleCourante = paire.getItem1();
            trouveCle = cleCourante.equals(cle);
            if (trouveCle) {
                valeur = paire.getItem2();
                list.remove(i);
            } // if
        } // for

        return valeur;
    } // supprimer()
} // MapArrayList