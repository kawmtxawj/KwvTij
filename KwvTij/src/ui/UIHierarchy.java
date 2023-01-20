package ui;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;

/**
 * Darw family tree on hierarchy
 * @author Kao Vang
 *
 */
public class UIHierarchy extends JPanel{

	/**
	 * serial UID default
	 */
	private static final long serialVersionUID = 1L;
	
	
	public UIHierarchy() {
		this.setPreferredSize(new Dimension(1000, 600));
		
		//changeColor();
		
		this.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED));
		this.setBorder(BorderFactory.createTitledBorder(" Hierarchy "));		// Border 
		
		GridBagLayout g = new GridBagLayout();
		this.setLayout(g);
		/*
		gridx - The initial gridx value.
		gridy - The initial gridy value.
		gridwidth - The initial gridwidth value.
		gridheight - The initial gridheight value.
		weightx - The initial weightx value.
		weighty - The initial weighty value.
		anchor - The initial anchor value.
		fill - The initial fill value.
		insets - The initial insets value.
		ipadx - The initial ipadx value.
		ipady - The initial ipady value.
		*/

		
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.BOTH;
		c.gridx = 0;
		c.gridy = 0;
		c.gridwidth=1;
		c.gridheight=1;
		
		UICaseTrait name = new UICaseTrait();
		//name.add(new JLabel("Vam Sawm"));
		name.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED));
		this.add(name, c);
		
		c.gridx = 0;
		c.gridy = 1;
		c.gridwidth=1;
		
		JPanel name2 = new JPanel();
		name2.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED));
		name2.add(new JLabel("Vam Sawm2"));
		
		this.add(name2, c);
		
		
		
		
	}

	@Override
	protected void paintComponent(Graphics g) {
		Graphics2D graphics = (Graphics2D) g.create(); 
		graphics.setColor(Color.WHITE);
		Dimension d = this.getSize();
		graphics.fillRect(0, 0, d.width, d.height);
		
	}

	
}
