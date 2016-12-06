package inf2120.tp3;

import java.util.Iterator;

public class Onde implements Iterable<Double> {
	protected double tauxEchantillonage;
	protected double frequence;
	protected double dure;
	
	{
		dure = 0.0;
	}
	
	public Onde( double tauxEchantillonage, double frequence )
	{
		this.tauxEchantillonage = tauxEchantillonage;
		this.frequence          = frequence;
	}
	
	public double getTauxEchantillonage()
	{
		return tauxEchantillonage;
	}

	public void setTauxEchantillonage(double tauxEchantillonage)
	{
		this.tauxEchantillonage = tauxEchantillonage;
	}

	public double getFrequence()
	{
		return frequence;
	}

	public void setFrequence(double frequence)
	{
		this.frequence = frequence;
	}

	public double getDure()
	{
		return dure;
	}
	
	public void setDure( double dure )
	{
		this.dure = dure;
	}

	public double calcule( IterateurOnde ito )
	{
		return 0.0;
	}
	
	public Iterator<Double> iterator()
	{
		return new IterateurOnde( this );
	}
	
	
	public class IterateurOnde implements Iterator<Double>
	{
		public Onde _onde;
		public double _tauxEchantillonage;
		public double _frequence;
		public double _horlogeFraction;
		public double _horlogeSeconde;
		public double _dure;
		public double _delta;
		
		public IterateurOnde( Onde onde )
		{
			_onde = onde;
			_tauxEchantillonage = onde.tauxEchantillonage;
			_frequence = onde.frequence;
			_horlogeFraction = 0.0;
			_horlogeSeconde = 0.0;
			_dure = onde.dure;
			_delta = 1.0 / _tauxEchantillonage;
		}
		
		public double getFrequence()
		{
			return _frequence;
		}

		public void setFrequence(double frequence)
		{
			this._frequence = frequence;
		}

		@Override
		public boolean hasNext()
		{
			return ( _horlogeSeconde + _horlogeFraction ) <= _dure;
		}
		
		@Override
		public Double next()
		{
			double res = _onde.calcule( this );
			
			_horlogeFraction += _delta;
			
			if( _horlogeFraction >= 1.0 )
			{
				_horlogeFraction -= 1.0;
				++ _horlogeSeconde;
			}

			return res;
		}
		
		@Override
		public void remove()
		{
			// ne fait rien.
		}
	}
}
