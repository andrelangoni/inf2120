package inf2120ete2016;

import java.util.Arrays;

public class Principaler {

	public static void verifier( boolean test, String mssg ){
		if( ! test ){
			System.err.println( "test non passe : " + mssg );
		}
	}

	
	
	public static void testerBase(){
		AcideRibonucleique arn = new AcideRibonucleique();
		
		verifier( arn.size() == 0, "devrait etre vide." );
		
		arn.add( Nucleotide.A );
		verifier( arn.get(0) == Nucleotide.A, "devrait contenir le nucleotide A." );
		
		arn.set( 0, Nucleotide.C );
		verifier( arn.get(0) == Nucleotide.C, "devrait contenir le nucleotide C." );
		
		arn.remove( 0 );
		verifier( arn.size() == 0, "devrait etre vide a nouveau." );
		
		AcideRibonucleique arn1 = new AcideRibonucleique( Arrays.asList( Nucleotide.A, Nucleotide.C ) );
		AcideRibonucleique arn2 = new AcideRibonucleique( Arrays.asList( Nucleotide.A, Nucleotide.C ) );
		verifier( arn1.equals( arn2 ), "Devrait etre egaux." );
	}
	
	public static void testerEstValide(){
		AcideRibonucleique arnValide = new AcideRibonucleique( Arrays.asList( 
				Nucleotide.A, Nucleotide.U, Nucleotide.G, 
				Nucleotide.U, Nucleotide.A, Nucleotide.A
				) );
		
		verifier( arnValide.estValide(), "Cette sequence devrait etre valide." );
		
		AcideRibonucleique arnInvalide = new AcideRibonucleique( Arrays.asList( 
				Nucleotide.A, Nucleotide.U, Nucleotide.G, 
				Nucleotide.U, Nucleotide.A,
				Nucleotide.U, Nucleotide.A, Nucleotide.A
				) );
		
		verifier( ! arnInvalide.estValide(), "Cette sequence ne devrait pas etre valide." );
	}
	
	public static void testerGetAcideAmine(){
		AcideRibonucleique arn = new AcideRibonucleique( Arrays.asList(
				Nucleotide.G, Nucleotide.C, Nucleotide.U,
				Nucleotide.U, Nucleotide.G, Nucleotide.U,
				Nucleotide.U, Nucleotide.A, Nucleotide.U
				) );
		
		verifier( AcideAmine.ALA == arn.getAcideAmine( 0 ), "devrait etre ALA." );
		verifier( AcideAmine.CYS == arn.getAcideAmine( 1 ), "devrait etre CYS." );
		verifier( AcideAmine.TYR == arn.getAcideAmine( 2 ), "devrait etre TYR." );
	}
	
	public static void testerComplement(){
		AcideRibonucleique arn = new AcideRibonucleique( Arrays.asList(
				Nucleotide.G, Nucleotide.C, Nucleotide.N,
				Nucleotide.R, Nucleotide.W, Nucleotide.B,
				Nucleotide.U, Nucleotide.A, Nucleotide.M
				) );
		AcideRibonucleique arnComplement = new AcideRibonucleique( Arrays.asList(
				Nucleotide.C, Nucleotide.G, Nucleotide.N,
				Nucleotide.Y, Nucleotide.W, Nucleotide.V,
				Nucleotide.A, Nucleotide.U, Nucleotide.K
				) );
		
		verifier( arn.complement().equals( arnComplement ), "pas le bon complement" );
	}
	
	public static void testerDecrit(){
		AcideRibonucleique arn = new AcideRibonucleique( Arrays.asList(
				Nucleotide.C, Nucleotide.K, Nucleotide.N,
				Nucleotide.B, Nucleotide.W, Nucleotide.N,
				Nucleotide.D, Nucleotide.N, Nucleotide.W
				) );
		AcideRibonucleique arnDecrite = new AcideRibonucleique( Arrays.asList(
				Nucleotide.C, Nucleotide.G, Nucleotide.N,
				Nucleotide.Y, Nucleotide.W, Nucleotide.V,
				Nucleotide.A, Nucleotide.U, Nucleotide.A
				) );
		
		verifier( arn.decrit( arnDecrite ), "devrait decrire la sequence" );
	}
	
	public static void testerGeneralise(){
		AcideRibonucleique arn1 = new AcideRibonucleique( Arrays.asList(
				Nucleotide.C, Nucleotide.U, Nucleotide.U,
				Nucleotide.B, Nucleotide.W, Nucleotide.N,
				Nucleotide.D, Nucleotide.C, Nucleotide.D
				) );
		AcideRibonucleique arn2 = new AcideRibonucleique( Arrays.asList(
				Nucleotide.C, Nucleotide.A, Nucleotide.N,
				Nucleotide.C, Nucleotide.W, Nucleotide.N,
				Nucleotide.C, Nucleotide.U, Nucleotide.A
				) );
		AcideRibonucleique arnR = new AcideRibonucleique( Arrays.asList(
				Nucleotide.C, Nucleotide.W, Nucleotide.N,
				Nucleotide.B, Nucleotide.W, Nucleotide.N,
				Nucleotide.N, Nucleotide.Y, Nucleotide.D
				) );
		
		verifier( arnR.equals( arn1.generalise( arn2 ) ), "devrait donnees la forme generalise" );		
	}
	
	public static void main(String[] args) {
		testerBase();
		testerEstValide();
		testerGetAcideAmine();
		testerComplement();
		testerDecrit();
		testerGeneralise();
	}

}
