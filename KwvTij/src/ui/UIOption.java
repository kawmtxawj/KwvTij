package ui;

import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

import control.Control_UI;

public class UIOption extends JPanel {
	
	/**
	 * Default UID
	 */
	private static final long serialVersionUID = 1L;
	private Control_UI clt_ui;

	public UIOption(Control_UI clt_ui) {
		this.clt_ui = clt_ui;
		
		JPanel border = new JPanel();
		border.setPreferredSize(new Dimension(240, 330));
    	border.setBorder(BorderFactory.createTitledBorder(" Options "));
    	JPanel pan_option = new JPanel();
    	pan_option.add(new JLabel("Options ..."));
    	
    	border.add(pan_option);
    	this.add(border);
	}
	
	// Option Changed -> refresh cltl_ui.frame.refresh_family_tree() 
	
}
