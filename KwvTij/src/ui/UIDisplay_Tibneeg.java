package ui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.font.FontRenderContext;
import java.awt.font.TextLayout;
import java.awt.geom.Rectangle2D;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import model.TibNeeg;
import model.YawmSuab;

/**
 * This class is a Panel and consist to display the TibNeeg, and take actions for modifications of this TibNeeg
 * on the panel parent.  
 * @author Anukun
 *
 */
public class UIDisplay_Tibneeg extends JPanel implements MouseListener{

	/**
	 * Default UID
	 */
	private static final long serialVersionUID = 1L;
	private TibNeeg kuv_tn;
	private JPanel rootLabel;
	
	public UIDisplay_Tibneeg(TibNeeg tn, YawmSuab ys, Dimension dim) {
		this.kuv_tn = tn;
		this.setPreferredSize(new Dimension(120, 70));
		//this.setBorder(BorderFactory.createEtchedBorder());
		
		//rootLabel = new JLabel(this.kuv_tn.getNpe(), SwingConstants.CENTER);
		
		
		rootLabel = new JPanel(){
			
			
			@Override
			public void paint(Graphics g) {
				// TODO Auto-generated method stub
				//super.paint(g);
				
				Graphics2D g2d = (Graphics2D) g.create();
				
				Font f = getFont();
				FontRenderContext context = g2d.getFontRenderContext();
				
				TextLayout txt = new TextLayout(kuv_tn.getNpe(), f, context);
				Rectangle2D rect =  txt.getBounds();
				
				g2d.setColor(Color.YELLOW);
				g2d.fillRect(1, 1, getWidth()-3, getHeight()-3);
				
				g2d.setColor(Color.BLACK);
				int stringX = (int) ((getWidth() - rect.getWidth())/2.0);
				int stringY = (int) ((getHeight() - rect.getHeight())/2.0);
				
				g2d.drawString(kuv_tn.getNpe(), stringX, stringY);
				
				drawRect(this, g2d);
				g2d.dispose();
				
			}
		};
		
		rootLabel.setPreferredSize(new Dimension(110, 50));
		rootLabel.addMouseListener(this);
		
   		this.add(rootLabel);
   		
	}
	
	/**
	 * Draw the rectangle of npe label
	 * @param pan
	 * @param g2d
	 */
	private void drawRect(JPanel pan, Graphics2D g2d) {
		// TODO Auto-generated method stub
		g2d.drawLine(0, 0, 0, pan.getHeight()-2);
		g2d.drawLine(0, 0, pan.getWidth()-2, 0);
		g2d.drawLine(pan.getWidth()-2, 0, pan.getWidth()-2, pan.getHeight()-2);
		g2d.drawLine(0, pan.getHeight()-2, pan.getWidth()-2, pan.getHeight()-2);
	}
	
	
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		if( e.getButton() == MouseEvent.BUTTON3){
			System.out.println("Click droit ");
			
			
		}
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
		System.out.println(" Enter -> "+ kuv_tn.getNpe());
		paint(UIFamilyTree.LABEL_ENTER_BACKGROUND);
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		paint(UIFamilyTree.LABEL_DEFAULT_BACKGROUND);
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	private void paint(Color color) {
		// TODO Auto-generated method stub
		Graphics2D g2d = (Graphics2D) rootLabel.getGraphics();
		
		Font f = rootLabel.getFont();
		FontRenderContext context = g2d.getFontRenderContext();
		
		TextLayout txt = new TextLayout(kuv_tn.getNpe(), f, context);
		Rectangle2D rect =  txt.getBounds();
		
		g2d.setColor(color);
		g2d.fillRect(1, 1, rootLabel.getWidth()-3, rootLabel.getHeight()-3);
		
		g2d.setColor(Color.BLACK);
		
		int stringX = (int) ((rootLabel.getWidth() - rect.getWidth())/2.0);
		int stringY = (int) ((rootLabel.getHeight() - rect.getHeight())/2.0);
		
		g2d.drawString(kuv_tn.getNpe(), stringX, stringY);
		
	}
	
}
