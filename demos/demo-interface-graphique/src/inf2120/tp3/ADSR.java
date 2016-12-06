package inf2120.tp3;

import java.util.Iterator;

public class ADSR extends Onde {
	
	protected double a;
	protected double d;
	protected double s;
	protected double r;
	
	public ADSR( double tauxEchantillonage, 
				 double monte, double descente, double soutenue, double relache )
	{
		super( tauxEchantillonage, 0.0 );
		
		a = monte;
		d = descente;
		s = soutenue;
		r = relache;
		
		dure -= r;
	}
	
	public double calcule( IterateurOnde ito )
	{
		double resultat = 0.0;
	
		double horloge = ito._horlogeFraction + ito._horlogeSeconde;
		
		if( 0.0 <= horloge && horloge < a )
		{
			resultat = horloge / a;
		}
		if( a <= horloge && horloge < ( a + d ) )
		{
			resultat = ( ( s - 1.0 ) / d ) * ( horloge - a ) + 1.0;
		}
		if( ( a + d ) <= horloge && horloge < dure )
		{
			resultat = s;
		}
		if( dure <= horloge && horloge < ( dure + r ) )
		{
			resultat = ( - s / r ) * ( horloge - dure ) + s;			
		}
		
		return resultat;
	}
	
	public Iterator<Double> iterator()
	{
		return new IterateurOndeADSR( this );
	}
	
	
	public class IterateurOndeADSR extends IterateurOnde
	{		
		public IterateurOndeADSR( Onde onde )
		{
			super( onde );
		}
		
		@Override
		public boolean hasNext()
		{
			ADSR onde = (ADSR)_onde;
			
			return ( _horlogeSeconde + _horlogeFraction ) <= ( onde.dure + onde.r );
		}
	}
}
