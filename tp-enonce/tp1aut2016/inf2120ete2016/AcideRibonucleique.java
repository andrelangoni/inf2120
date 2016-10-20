package inf2120ete2016;

import java.util.ArrayList;
import java.util.Collection;

public class AcideRibonucleique extends ArrayList<Nucleotide> {
        public AcideRibonucleique( Collection< Nucleotide > c ) {
	        super( c );
        }

        public boolean estValide(){
		return false;
	}
	
	public AcideAmine getAcideAmine( int position ) throws IndexOutOfBoundsException{
		return null;
	}
	
	public AcideRibonucleique complement(){
		return null;
	}
	
	public boolean decrit( AcideRibonucleique decrite ){
		return false;
	}
	
	public AcideRibonucleique generalise( AcideRibonucleique arn ) throws IndexOutOfBoundsException{
		return this;
	}
}
