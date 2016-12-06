package inf2120.tp3;

public class Bruit extends Onde {
	public Bruit()
	{
		super( 0.0, 0.0 );
	}
	
	@Override
	public double calcule( IterateurOnde ito ) {
		return ( Math.random() * 2.0 ) - 1.0;
	}
}
