import static org.junit.Assert.*;

import java.util.Iterator;

import org.junit.Test;

public class ListeDCTest {

	static final Integer I1 = new Integer( 1 );
	static final Integer I2 = new Integer( 2 );
	static final Integer I3 = new Integer( 3 );
	static final Integer I4 = new Integer( 4 );
	static final Integer I5 = new Integer( 5 );
	
	@Test
	public void testListeDC() {
		ListeDC<Integer> li = new ListeDC<>();
		
		assertTrue( li.estVide() );
		assertEquals( 0, li.taille() );
	}

	@Test
	public void testEstVide() {
		try {
			ListeDC<Integer> li = new ListeDC<>();
			
			assertTrue( li.estVide() );
	
			li.ajouter_debut( I1 );
			assertFalse( li.estVide() );
			
			li.ajouter_debut( I2 );
			assertFalse( li.estVide() );

			li.supprimer_debut();
			assertFalse( li.estVide() );
		
			li.supprimer_debut();
			assertTrue( li.estVide() );
			
			ListeDC<Integer> li2 = new ListeDC<>();
			
			assertTrue( li2.estVide() );
	
			li2.ajouter_fin( I1 );
			assertFalse( li2.estVide() );
			
			li2.ajouter_fin( I2 );
			assertFalse( li2.estVide() );

			li2.supprimer_fin();
			assertFalse( li2.estVide() );
		
			li2.supprimer_fin();
			assertTrue( li2.estVide() );		
		} catch( EstVide e ) {
			fail( "Ne devrait pas etre levee." );
		}
	}

	@Test
	public void testTaille() {
		try {
			ListeDC<Integer> li = new ListeDC<>();
			
			assertEquals( 0, li.taille() );
	
			li.ajouter_debut( I1 );
			assertEquals( 1, li.taille() );
			
			li.ajouter_debut( I2 );
			assertEquals( 2, li.taille() );

			li.supprimer_debut();
			assertEquals( 1, li.taille() );
		
			li.supprimer_debut();
			assertEquals( 0, li.taille() );
			
			ListeDC<Integer> li2 = new ListeDC<>();
			
			assertEquals( 0, li2.taille() );
	
			li2.ajouter_fin( I1 );
			assertEquals( 1, li2.taille() );
			
			li2.ajouter_fin( I2 );
			assertEquals( 2, li2.taille() );

			li2.supprimer_fin();
			assertEquals( 1, li2.taille() );
		
			li2.supprimer_fin();
			assertEquals( 0, li2.taille() );
		} catch( EstVide e ) {
			fail( "Ne devrait pas etre levee." );
		}
	}

	@Test
	public void testAjouter_debut() {
		try {
			ListeDC<Integer> li = new ListeDC<>();

			li.ajouter_debut( I1 );
			assertEquals( I1, li.debut() );
			assertEquals( I1, li.fin() );
		
			li.ajouter_debut( I2 );
			assertEquals( I2, li.debut() );
			assertEquals( I1, li.fin() );
		} catch ( EstVide e ) {
			fail( "Ne devrait pas etre levee." );			
		}		
	}

	@Test
	public void testAjouter_fin() {
		try {
			ListeDC<Integer> li = new ListeDC<>();

			li.ajouter_fin( I1 );
			assertEquals( I1, li.fin() );
			assertEquals( I1, li.debut() );
		
			li.ajouter_fin( I2 );
			assertEquals( I2, li.fin() );
			assertEquals( I1, li.debut() );
		} catch ( EstVide e ) {
			fail( "Ne devrait pas etre levee." );			
		}		
	}

	@Test
	public void testDebut() {
		try {
			ListeDC<Integer> li = new ListeDC<>();
	
			li.ajouter_debut( I1 );
			assertEquals( I1, li.debut() );

			li.ajouter_debut( I2 );
			assertEquals( I2, li.debut() );

			li.ajouter_debut( I3 );
			assertEquals( I3, li.debut() );
		} catch ( EstVide e ) {
			fail( "Ne devrait pas etre levee." );			
		}
	}

	@Test
	public void testFin() {
		try {
			ListeDC<Integer> li = new ListeDC<>();
	
			li.ajouter_fin( I1 );
			assertEquals( I1, li.fin() );

			li.ajouter_fin( I2 );
			assertEquals( I2, li.fin() );

			li.ajouter_fin( I3 );
			assertEquals( I3, li.fin() );
		} catch ( EstVide e ) {
			fail( "Ne devrait pas etre levee." );			
		}
	}

	@Test
	public void testSupprimer_fin() {
		try {
			ListeDC<Integer> li = new ListeDC<>();
			
			li.ajouter_debut( I1 );
			li.ajouter_fin( I2 );
			
			li.supprimer_fin();
			assertEquals( I1, li.fin() );
			
			li.supprimer_fin();
			assertTrue( li.estVide() );
		} catch ( EstVide e ) {
			fail( "Ne devrait pas etre levee." );						
		}
	}

	@Test
	public void testSupprimer_debut() {
		try {
			ListeDC<Integer> li = new ListeDC<>();
			
			li.ajouter_fin( I1 );
			li.ajouter_debut( I2 );
			
			li.supprimer_debut();
			assertEquals( I1, li.debut() );
			
			li.supprimer_debut();
			assertTrue( li.estVide() );
		} catch ( EstVide e ) {
			fail( "Ne devrait pas etre levee." );						
		}
	}

	@Test
	public void testIterator() {
		ListeDC<Integer> li1 = new ListeDC<>();
		ListeDC<Integer> li2 = new ListeDC<>();
		
		li1.ajouter_fin( I1 );
		li1.ajouter_fin( I2 );
		li1.ajouter_fin( I3 );
		li1.ajouter_fin( I4 );
		li1.ajouter_fin( I5 );
		
		li2.ajouter_debut( I5 );
		li2.ajouter_debut( I4 );
		li2.ajouter_debut( I3 );
		li2.ajouter_debut( I2 );
		li2.ajouter_debut( I1 );
		
		Iterator<Integer> it1 = li1.iterator();
		Iterator<Integer> it2 = li2.iterator();
		
		while( it1.hasNext() ) {
			assertEquals( it1.next(), it2.next() );
		}
		
		ListeDC<Integer> li3 = new ListeDC<>();

		Iterator<Integer> it3 = li3.iterator();
		
		while( it3.hasNext() ){
			fail( "Il n'y a pas d'iteration sur une liste vide." );
		}

		ListeDC<Integer> li4 = new ListeDC<>();
		li4.ajouter_debut( I1 );
		
		Iterator<Integer> it4 = li4.iterator();
		
		while( it4.hasNext() ){
			assertEquals( I1, it4.next() );
		}
	}
}
