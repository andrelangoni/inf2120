package inf2120.tp3;

import java.util.Iterator;

public class Compose extends Onde {
	protected Onde onde1;
	protected Onde onde2;
	
	public Compose( Onde onde1, Onde onde2 )
	{
		super( onde1.getTauxEchantillonage(), 1.0 );
		
		assert onde1.getTauxEchantillonage() == onde2.getTauxEchantillonage();
		
		this.onde1 = onde1;
		this.onde2 = onde2;
		
		if( onde1.getTauxEchantillonage() == 0.0 )
		{
			setTauxEchantillonage( onde2.getTauxEchantillonage() );
		}
		else if( onde2.getTauxEchantillonage() != 0.0 )
		{
			assert onde1.getTauxEchantillonage() == onde2.getTauxEchantillonage();
		}
		
		if( onde1.getFrequence() == 0.0 )
		{
			setFrequence( onde2.getFrequence() ); 
		} 
		else if( onde2.getFrequence() == 0.0 ) 
		{
			setFrequence( onde1.getFrequence() ); 			
		} 
		else
		{
			setFrequence( ( onde1.getFrequence() + onde2.getFrequence() ) / 2.0 );
		}		
	}
	
	@Override
	public void setDure( double dure )
	{
		this.dure = dure;
		onde1.setDure(dure);
		onde2.setDure(dure);
	}
	
	@Override
	public Iterator<Double> iterator()
	{
		return new IterateurOndeCompose( this );
	}

	@Override
	public double calcule( IterateurOnde ito )
	{
		super.calcule( ito );
		
		return 0.0;
	}
	
	
	public class IterateurOndeCompose extends Onde.IterateurOnde
	{
		public Iterator<Double> it1;
		public Iterator<Double> it2;
		
		public IterateurOndeCompose( Compose onde )
		{
			super( onde );
			
			it1 = onde.onde1.iterator();
			it2 = onde.onde2.iterator();
		}
		
		@Override
		public boolean hasNext()
		{
			return it1.hasNext() || it2.hasNext();
		}
	}
}
