package question7.services;

public interface IPile <T> {
    public boolean estVide();
    
    public T tete() throws PileVide;
            
    //public void empiler(T element);
    
    public T depiler() throws PileVide;
}
