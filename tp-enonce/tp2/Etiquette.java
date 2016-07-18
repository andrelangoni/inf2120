package inf2120ete2016;

public class Etiquette implements Comparable< Etiquette > {
	private String _id;
	private int _debut;
	private int _fin;
	
	{
		_id = "";
		_debut = 0;
		_fin = 0;
	}
	
	public Etiquette( String a_id, int a_debut, int a_fin ) {
		_id = a_id;
		_debut = a_debut;
		_fin = a_fin;
	}
	
	public String id() {
		return _id;
	}
	
	public int debut() {
		return _debut;
	}
	
	public int fin() {
		return _fin;
	}

	@Override
	public int compareTo( Etiquette a_deuxieme ) {
		int resultat = _debut - a_deuxieme._debut;
		
		if( 0 == resultat ) {
			resultat = _fin - a_deuxieme._fin;
		}
		
		return resultat;
	}
	
	@Override
	public boolean equals( Object a_deuxieme ) {
		boolean resultat = false;
		
		if( a_deuxieme instanceof Etiquette ) {
			Etiquette temp = ( Etiquette ) a_deuxieme;
			resultat = _id == temp._id && 0 == compareTo( temp );
		}
		
		return resultat;
	}
}
