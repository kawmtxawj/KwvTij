package ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

import control.Control_UI;


public class UIMenu extends JMenuBar {

	/**
	 * Default serial UID
	 */
	private static final long serialVersionUID = 1L;
	private Control_UI cltr_ui ;
	
	public UIMenu(Control_UI con_ui) {
		this.cltr_ui = con_ui;
		
		JMenu file = new JMenu("File");
		file.setMnemonic(KeyEvent.VK_F);
		
			// Menu File/Start
		
		
		
			// Menu File/Open	
			JMenuItem open = new JMenuItem("Open File", KeyEvent.VK_O);
			open.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, ActionEvent.CTRL_MASK));
			open.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {			
					cltr_ui.openFile();
				}
			});
			file.add(open);
			
			// Menu File/Save
			JMenuItem save = new JMenuItem("Save File", KeyEvent.VK_S);
			save.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.CTRL_MASK));
			save.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {			
					cltr_ui.saveFile();
				}
			});
			file.add(save);
			
			
			// Menu File/SaveAs
			JMenuItem saveAs = new JMenuItem("Save File As", KeyEvent.VK_A);
			saveAs.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, ActionEvent.CTRL_MASK));
			saveAs.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					cltr_ui.saveFileAs();
				}
			});
			file.add(saveAs);
			
					
			// Menu File/Tawm
			JMenuItem quit = new JMenuItem("Quit", KeyEvent.VK_Q);
			quit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q, ActionEvent.CTRL_MASK));
			quit.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {			
					//controller.quitter();
				}
			});
			file.add(quit);
			
			add(file);
			
			/* Help */
			
			JMenu help = new JMenu("Help");
			help.setMnemonic(KeyEvent.VK_H);
			
			// Menu File/Tawm
			JMenuItem about = new JMenuItem("About", KeyEvent.VK_A);
			about.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_I, ActionEvent.CTRL_MASK));
			about.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {			
					//cltr_ui.about();
				}
			});
			help.add(about);
		
		add(help);
	}
	
}
