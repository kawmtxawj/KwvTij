package ui;

import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JTextField;

import control.Control_UI;

public class UILog extends JPanel {

	/**
	 * Default UID
	 */
	private static final long serialVersionUID = 1L;
	private JTextField log_text;
	private Control_UI clt_ui;
	
	public UILog( Control_UI clt_ui ) {
		this.clt_ui = clt_ui;
		
		log_text = new JTextField();
		log_text.setPreferredSize(new Dimension(225, 315));
		
		JPanel border = new JPanel();
		border.setPreferredSize(new Dimension(240, 350));
    	border.setBorder(BorderFactory.createTitledBorder(" Log "));
    	border.add(log_text);
		this.add(border);
	}
	
	
}
