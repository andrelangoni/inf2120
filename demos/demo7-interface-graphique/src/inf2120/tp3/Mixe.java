package inf2120.tp3;

public class Mixe extends Compose {
	protected double volume1;
	protected double volume2;
	
	public Mixe( Onde onde1, double volume1, Onde onde2, double volume2 )
	{
		super( onde1, onde2 );
		
		assert volume1 >= 0.0;
		assert volume2 >= 0.0;
		assert ( volume1 + volume2 ) <= 1.0;
		
		this.volume1 = volume1;
		this.volume2 = volume2;
	}
	
	public double calcule( IterateurOnde ito )
	{
		IterateurOndeCompose it = (IterateurOndeCompose)ito;
		
		double a1 = it.it1.next() * volume1; 
		double a2 = it.it2.next() * volume2;
				
		return a1 + a2;
	}
}
