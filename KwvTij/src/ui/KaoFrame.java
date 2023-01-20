package ui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

import control.Control_UI;


public class KaoFrame{
	
	private Control_UI cltr_ui ;
	private UIMenu menu;
	private UITool tools;
	private UIFamilyTree family_tree;
	private UIOption option ;
	
	private JFrame window;
	private JPanel main_panel;
	
	
	/**
	 * Constructor of frame
	 * @param title
	 * @param con_ui
	 */
	public KaoFrame(String title, Control_UI con_ui) {
		this.cltr_ui = con_ui;
		this.window = new JFrame(title);
		this.window.setPreferredSize(new Dimension(1200, 800));
		this.window.setResizable(true);
		this.window.pack();
		this.window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.menu = new UIMenu(cltr_ui);
		this.window.setJMenuBar(this.menu);
		
		
		// Le Layout
		//GridBagLayout g = new GridBagLayout();
		//window.setLayout(g);
		
		this.tools = new UITool(this.cltr_ui);
		this.window.add(this.tools, BorderLayout.NORTH);
		
		main_panel = new JPanel();
		main_panel.setLayout(new GridBagLayout());
		build_main_panel();
		
		window.add(main_panel);
	} 
	

	private void build_main_panel() {
   		GridBagConstraints c = new GridBagConstraints();
   		
   		this.option = new UIOption(this.cltr_ui);
   		
   		c.fill = GridBagConstraints.HORIZONTAL;
   		c.gridx = 0;
   		c.gridy = 0;
   		c.weightx = 1;
   		c.gridwidth = 3;
   		c.gridheight = 2;
		family_tree = new UIFamilyTree(cltr_ui.getYawmSaub(), option);
		main_panel.add(family_tree, c);
		
   		c.gridx = 3;
   		c.gridy = 0;
   		c.weightx = 1;
   		c.gridwidth = 1;
   		c.gridheight = 1;
   		main_panel.add( this.option, c);
   		
		c.gridx = 3;
   		c.gridy = 1;
   		c.weightx = 1;
   		c.gridwidth = 1;
   		c.gridheight = 1;
		main_panel.add(new UILog(this.cltr_ui), c );
		
	}


	/**
	 * Refresh the family tree panel  
	 */
	public void refresh_family_tree() {
		this.family_tree.refresh_tree();
		
	}
	
	/**
	 * Show the main window
	 */
	public void show(){
		this.window.setVisible(true);
	}
	
	/**
	 * Hide the main window
	 */
	public void hide(){
		this.window.setVisible(false);
	}
	
	public JFrame getWindow() {
		return this.window;
	}


	
	/* ++++++++ Listeners++++++++ */
	/*
	private class ButtonListener implements ActionListener {
		  public void actionPerformed (ActionEvent event) {
		    Object source = event.getSource();

		    if (source == button_add) {
	
		        
		    }
		    
		    if (source == button_showHier) {
		        
		        cltr_ui.showHierarchy();

		    }
		  }
	 }
	*/
}
