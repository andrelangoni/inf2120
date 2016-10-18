package inf2120.tp3;

public class PulseGenerique extends Onde {

	protected double ratio;

	PulseGenerique( double tauxEchantillonage, double frequence ) 
	{
		super( tauxEchantillonage, frequence );

		this.ratio = 0.5;
	}

	PulseGenerique( double tauxEchantillonage, double frequence, double ratio ) 
	{
		super( tauxEchantillonage, frequence );

		this.ratio = ratio;
	}

	public void setRatio( double ratio ) {
		this.ratio = ratio;
	}
	
	@Override
	public double calcule( IterateurOnde ito )
	{
		double resultat = 0.0;
		double position = ito._horlogeFraction * frequence;
		double x = ( position - Math.floor( position ) );
		
		resultat = ( x < ratio )
				 ? 1.0 
				 : -1.0;
		
		return resultat;
	}
}
