package inf2120.tp3;

public class Filtre extends Compose {
	public Filtre( Onde onde1, Onde onde2 )
	{
		super( onde1, onde2 );
	}
	
	public double calcule( IterateurOnde ito )
	{
		IterateurOndeCompose it = (IterateurOndeCompose)ito;
		
		double a1 = it.it1.next(); 
		double a2 = it.it2.next();
				
		return a1 * a2;
	}
}
