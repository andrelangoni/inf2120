package inf2120.tp3;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

public class Graphic extends Canvas {
	
	private static final long serialVersionUID = 1L;
	
	public static final int TAILLE_X = 512;
	public static final int TAILLE_Y = 128;
	
	public ArrayList<Short> fonction;
	
	public void setFonction( Onde s )
	{
		fonction = null;
		fonction = new ArrayList<Short>();
		
	    for( Double a : s )
	    {
	    	fonction.add( (short)Math.floor( TAILLE_Y + ( TAILLE_Y - 1 ) * ( - a ) ) );
	    }
	    repaint();
	}
	
	@Override
	public void paint(Graphics g)
	{
		g.setColor(Color.black);
		g.drawLine(0, 0, 0, TAILLE_Y * 2 + 1 );
		g.drawLine(0, TAILLE_Y, TAILLE_X, TAILLE_Y);
		
		int step = fonction.size() / TAILLE_X;
		
		short precedant = fonction.get(0);
		
		for( int i = 1; i < TAILLE_X; ++i )
		{
			short courrant = fonction.get( i * step );
			
			g.drawLine(i-1, precedant, i, courrant);
			
			precedant = courrant;
		}
	}

	@Override
	public void update(Graphics g)
	{
		g.clearRect(0, 0, TAILLE_X, 2 * TAILLE_Y + 1 );
		paint(g);
	}
}
