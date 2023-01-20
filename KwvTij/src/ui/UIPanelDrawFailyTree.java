package ui;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Point;

import javax.swing.JLabel;

import model.TibNeeg;
import model.YawmSuab;

public class UIPanelDrawFailyTree extends Canvas {

	/**
	 * Serial default UID
	 */
	private static final long serialVersionUID = 1L;
	private static int lenghtTraitVertical = 20;			// Trait height 20pixel
	private static int distanceFromNpeAndBeginTrait = 5;	// Distance from Npe to begin draw trait vertical
	//private static int distanceFromTopToBeginNpe = 15;
	private static int centerTraitVertical = 50;			// Allow to draw trait to center of Npe
	private static int lenghtTraitHorizontal_1_tn = 70;	// the lenght of trait horizontal
	private static int lenghtFromTopPanel = 30;				// the lenght from top panel
	
	private Image image;
	private Point begin;
	private Point end;
	private YawmSuab yawmSuab;	// For can call their functions
	private TibNeeg tusTop;		// Tus yawg top to display his descendants 
	
	public UIPanelDrawFailyTree(YawmSuab yawmSuab, TibNeeg tnTop) {
		
		this.setPreferredSize(new Dimension(1000, 600));
		this.yawmSuab = yawmSuab;
		this.tusTop = tnTop;
		
		
	}
	

	/**
	 * Recreation du dessin (on reinitialise tout)
	 * @param g Graphique
	 */
	@Override
	public void paint(Graphics g) {
		
		initialSize();

		//dessinerTrait(point1, point2, color);
		Dimension d = this.getSize();
		
		/* Fill WHITE color on background */
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, d.width, d.height);
		
		/* Change color */
		g.setColor(Color.BLACK);
		
		
		
		// First person position
		int x = (int) ((d.getWidth()/2)-centerTraitVertical);
		int y = (int) ((d.getHeight()-d.getHeight()) + lenghtFromTopPanel);
		int width = (int) d.getWidth();
		int height = (int) d.getHeight();
		
		System.out.println("Width : "+d.getWidth());
		System.out.println("Height : "+d.getHeight());
		
		// Sau npe
		drawNpeXeem(g, x, y);
		
		
		// Trait horizontal for 4 me nyuam
		x = (width/2) - (lenghtTraitHorizontal_1_tn+(lenghtTraitHorizontal_1_tn/2) ); // *2 : 4 tus me nyuam 
		y = ((height-height) + (lenghtFromTopPanel+distanceFromNpeAndBeginTrait+lenghtTraitVertical));
		int meNyuam_total = 4; 	// 4 tug
		drawLineHorizontal(g, x, y, meNyuam_total );
		
		// Trait vertical for 4 me nyuam
		// 1st
		x = (width/2) - (lenghtTraitHorizontal_1_tn+(lenghtTraitHorizontal_1_tn/2) ); // *2 : 4 tus me nyuam 
		y = ((height-height) + (lenghtFromTopPanel+distanceFromNpeAndBeginTrait+lenghtTraitVertical));
		drawLineVertical(g, x, y);

		//2nd
		x = ((width/2) - (lenghtTraitHorizontal_1_tn*2))+(lenghtTraitHorizontal_1_tn+(lenghtTraitHorizontal_1_tn/2) ); // *2 : 4 tus me nyuam 
		y = ((height-height) + (lenghtFromTopPanel+distanceFromNpeAndBeginTrait+lenghtTraitVertical));
		drawLineVertical(g, x, y);
		
		// 3th
		x = ((width/2) - (lenghtTraitHorizontal_1_tn*2))+(lenghtTraitHorizontal_1_tn*2+(lenghtTraitHorizontal_1_tn/2) ); // *2 : 4 tus me nyuam 
		y = ((height-height) + (lenghtFromTopPanel+distanceFromNpeAndBeginTrait+lenghtTraitVertical));
		drawLineVertical(g, x, y);
		
		// 4th
		x = ((width/2) - (lenghtTraitHorizontal_1_tn*2))+(lenghtTraitHorizontal_1_tn*3+(lenghtTraitHorizontal_1_tn/2) ); // *2 : 4 tus me nyuam 
		y = ((height-height) + (lenghtFromTopPanel+distanceFromNpeAndBeginTrait+lenghtTraitVertical));
		drawLineVertical(g, x, y);
				
		
		/* 2 Generation */
		// Sau npe 1st
		x = (width/2)-((lenghtTraitHorizontal_1_tn*2)) ;
		//y = (height-height) + lenghtFromTopPanel + distanceFromNpeAndBeginTrait + longTraitVertical*2 + distanceFromTopToBeginNpe;
		y = (height-height) + lenghtFromTopPanel + distanceFromNpeAndBeginTrait + lenghtTraitVertical*2 + distanceFromNpeAndBeginTrait*3;
		drawNpe(g, "Neej Tsom", x, y);
		
		// Sau npe 2nd
		x = (width/2)-lenghtTraitHorizontal_1_tn ;
		y = (height-height) + lenghtFromTopPanel + distanceFromNpeAndBeginTrait + lenghtTraitVertical*2 + distanceFromNpeAndBeginTrait*3;
		drawNpe(g, "Txawj Luj", x, y);
		
		// Sau npe 3nd
		x = (width/2) ;
		y = (height-height) + lenghtFromTopPanel + distanceFromNpeAndBeginTrait + lenghtTraitVertical*2 + distanceFromNpeAndBeginTrait*3;
		drawNpe(g, "Txiaj Kaus", x, y);
		
		g.setColor(Color.RED);
		// Sau npe 4nd
		x = (width/2)+( lenghtTraitHorizontal_1_tn );
		y = (height-height) + lenghtFromTopPanel + distanceFromNpeAndBeginTrait + lenghtTraitVertical*2 + distanceFromNpeAndBeginTrait*3;
		drawNpe(g, "Pob Tsuas", x, y);
		
	}


	private void drawNpeXeem(Graphics g, int x, int y) {
		drawNpe(g, tusTop.getNpe(), x, y);
		drawLineVertical(g, x+centerTraitVertical, (y+distanceFromNpeAndBeginTrait));
	}


	private void drawNpe(Graphics g, String npeXeem, int x, int y) {
		g.drawString(npeXeem, x, y);
	}

	private void drawLineVertical(Graphics g, int x, int y) {
		g.drawLine(x, y, x, y+lenghtTraitVertical);
	}

	private void drawLineHorizontal(Graphics g, int x, int y, int meNyuam_total) {
		g.drawLine(x, y, x+lenghtTraitHorizontal_1_tn*(meNyuam_total-1), y);
		
	}

	
	private void initialSize() {
		/* +++++ Have to modify for adapt to the size of their descendants ++++++++++++ */
		Dimension d = new Dimension(800, 500);
		Point begin = new Point(50,d.height/2);
		Point end = new Point(d.width-50,d.height/2);
		/* +++++ ++++++++++++++++++++++++++++++++ ++++++++++++ */
		
		this.setPreferredSize(d);
		this.begin = begin;
		this.end = end;
	}
	
	
/*

	public void reinitialise() {
		// Le background
		this.image = createImage(this.getWidth(), this.getHeight());
		Graphics gImage = this.image.getGraphics();
		gImage.setColor(Color.WHITE);
		gImage.fillRect(0, 0, this.getWidth(), this.getHeight());
	}
	
	public void dessinerTrait(Point pointDepart, Point pointArrive, Color couleur) {
		Graphics2D trait = (Graphics2D)this.image.getGraphics();
		trait.scale(0.01, 0.01);
		trait.setColor(couleur);
		//trait.drawLine(pointDepart.x, pointDepart.y, pointArrive.x, pointArrive.y);
		
	}
*/
}
