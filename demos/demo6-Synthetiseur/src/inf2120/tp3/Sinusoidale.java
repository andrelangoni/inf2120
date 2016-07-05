package inf2120.tp3;

public class Sinusoidale extends Onde {

	public Sinusoidale( double tauxEchantillonage, double frequence )
	{
		super( tauxEchantillonage, frequence );
	}
	
	@Override
	public double calcule( IterateurOnde ito )
	{
		return Math.sin( 2.0 * Math.PI * ito._frequence * ito._horlogeFraction );
	}
}
