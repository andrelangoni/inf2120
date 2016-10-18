package inf2120.tp3;

public class TriangleGenerique extends Onde {

	protected double ratio;

	TriangleGenerique( double tauxEchantillonage, double frequence ) 
	{
		super( tauxEchantillonage, frequence );

		this.ratio = 0.5;
	}

	TriangleGenerique( double tauxEchantillonage, double frequence, double ratio ) 
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
		double position = ito._horlogeFraction * ito._frequence;
		double x = ( position - Math.floor( position ) ) - ratio;

		resultat = ( x < 0.0 )
				 ? ( 2.0 * x / ratio ) + 1.0 
				 : ( -2.0 * x / ( 1.0 - ratio ) ) + 1.0;

		return resultat;
	}
}
