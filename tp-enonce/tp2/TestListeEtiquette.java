package inf2120ete2016;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.stream.StreamSupport;

import org.junit.Test;

public class TestListeEtiquette {
	private static final ArrayList< Integer >   VIDE_I = new ArrayList<>();
	private static final ArrayList< Etiquette > VIDE_E = new ArrayList<>();
	
	private static final Integer ZERO   = new Integer( 0 );
	private static final Integer UN     = new Integer( 1 );
	private static final Integer DEUX   = new Integer( 2 );
	private static final Integer TROIS  = new Integer( 3 );
	private static final Integer QUATRE = new Integer( 4 );
	
	private static final String ID1 = new String( "id1" );
	private static final String ID2 = new String( "id2" );
	
	private static final Etiquette E1 = new Etiquette( ID1, 1, 2 );
	private static final Etiquette E2 = new Etiquette( ID1, 4, 4 );
	private static final Etiquette E3 = new Etiquette( ID2, 0, 1 );
	private static final Etiquette E4 = new Etiquette( ID2, 0, 4 );
	
	/**
	 * Cette methode utilise les assert de JUnit pour verifier que deux iterateurs
	 * pointe sur les memes contenus, l'ordre est sans importance, seulement les 
	 * occurence sont verifie.
	 * Si un des Iterator termine avant l'autre, fail est utilise pour donner une erreur.
	 * @param mssg     : un message d'identification pour le test.
	 * @param attendu  : un Iterator sur les resutlats attendus.
	 * @param recu     : un Iterator sur les resultat produits.
	 */
	private <E> void assertContenuEgalSansOrdre( String mssg,
												 Iterator< E > attendu,
												 Iterator< E > recu ) {
		Iterable< E > iterableAttendu = () -> attendu;
		Iterable< E > iterableRecu = () -> recu;
		
		assertContenuEgal( mssg,
				StreamSupport.stream( iterableAttendu.spliterator(), false ).sorted().iterator(),
				StreamSupport.stream( iterableRecu.spliterator(), false ).sorted().iterator() );
	}
	
	/**
	 * Cette methode utilise les assert de JUnit pour verifier que deux iterateurs
	 * pointe sur les memes contenus, dans le meme ordre.
	 * Si un des Iterator termine avant l'autre, fail est utilise pour donner une erreur.
	 * @param mssg     : un message d'identification pour le test.
	 * @param attendu  : un Iterator sur les resutlats attendus.
	 * @param recu     : un Iterator sur les resultat produits.
	 */
	private <E> void assertContenuEgal( String mssg,
										Iterator< E > attendu, Iterator< E > recu ) {
		while( attendu.hasNext() && recu.hasNext() ) {
			assertEquals( mssg, attendu.next(), recu.next() );
		}
		if( attendu.hasNext() ) {
			fail( mssg + " : il manque des valeurs." );
		}
		if( recu.hasNext() ) {
			fail( mssg + " : il y a des valeurs en trop." );
		}
	}
	
	@Test
	public void test() {
		ListeEtiquette< Integer > le = new ListeEtiquette< Integer >();
		
		// Construire une liste de cinq elements :
		le.add( ZERO );
		le.add( UN );
		le.add( DEUX );
		le.add( TROIS );
		le.add( QUATRE );
		
		// L'etiquette suivante couvre les elements UN et DEUX, teste si vrai en demandant l'iterateur
		// ayant le meme id.
		le.ajouterEtiquette( E1 );
		assertContenuEgal( "iterer sur id t1", Arrays.asList( UN, DEUX ).iterator(), le.iterator( ID1 ) );
		
		// Ajouter une Etiquette ayant le meme ID mais couvant la case 4.
		// Maintenant, l'ID couvre donc les case 1, 2 et 4.
		le.ajouterEtiquette( E2 );
		assertContenuEgal( "iterer sur id t2", Arrays.asList( UN, DEUX, QUATRE ).iterator(), le.iterator( ID1 ) );
		
		// Ajouter une Etiquette ayant un nom different, couvrant les case 0 et 1.
		// Tester l'iterateur qui me donne toutes les etiquettes de la case 1.
		le.ajouterEtiquette( E3 );
		assertContenuEgalSansOrdre( "iterer sur case t3", Arrays.asList( E1, E3 ).iterator(), le.iterator( 1 ) );
		
		// Doubler l'etiquette sur les cases 0 et 1.
		le.ajouterEtiquette( E3 );
		// L'iterateur d'etiquette pour une case doit repeter les etiquettes similaire.
		assertContenuEgalSansOrdre( "iterer sur case t4", Arrays.asList( E1, E3, E3 ).iterator(), le.iterator( 1 ) );
		// Par contre, l'iterateur pour une etiquette ne repete pas le nombre de case, peut importe le nombre d'etiquette.
		assertContenuEgal( "iterer sur id t5", Arrays.asList( ZERO, UN ).iterator(), le.iterator( ID2 ) );
		
		// Enlever une des etiquettes en double, pas important laquel.
		le.supprimerEtiquette( E3 );
		// Verifier qu'elle n'est plus double.
		assertContenuEgalSansOrdre( "iterer sur case t6", Arrays.asList( E1, E3 ).iterator(), le.iterator( 1 ) );

		// Supprimer toutes les etiquettes ayant le meme ID.
		le.supprimerEtiquettes( ID1 );
		// Verifier qu'il n'en reste plus.
		assertContenuEgal( "iterer sur case t7", VIDE_I.iterator(), le.iterator( ID1 ) );
		// Donc la case 4 n'a plus d'etiquette :
		assertContenuEgalSansOrdre( "iterer sur case t8", VIDE_E.iterator(), le.iterator( 4 ) );
		// Mais la case 1 a encore des etiquettes ayant l'id2 :
		assertContenuEgalSansOrdre( "iterer sur case t9", Arrays.asList( E3 ).iterator(), le.iterator( 1 ) );
		
		// finalement, avec une etiquette qui couvre toutes les cases :
		le.ajouterEtiquette( E4 );
		assertContenuEgal( "iterer sur id t10", Arrays.asList( ZERO, UN, DEUX, TROIS, QUATRE ).iterator(), le.iterator( ID2 ) );
	}
}
