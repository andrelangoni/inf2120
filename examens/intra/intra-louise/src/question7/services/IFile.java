package question7.services;

public interface IFile<T> {
    public int taille();

    public boolean estVide();

    public T tete() throws FileVide;
            
    public void enfiler(T element);
    
    public void defiler() throws FileVide;
    
    public T trouverElement(int position);
}
