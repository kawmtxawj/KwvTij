package ui;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.ListIterator;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import control.Control_UI;


import model.TibNeeg;

/**
 * Dialog to creat a new Txiv and links to Cov Menyuam
 * @author Kao Vang
 *
 */
public class DialogCreatYawgKoobTop extends JDialog{
	
	/**
	 * Default serial UID
	 */
	private static final long serialVersionUID = 1L;
	private Control_UI cltr_ui;
	private ButtonListener listener;
	
	/* Components in this dialog*/
	private JPanel panel_main;
	private JPanel panel_fiel_npe;
	//private JPanel panel_fiel_xeem;
	
	private JPanel panel_combo;
	private JPanel panel_button;
	private JComboBox<TibNeeg> combo;
	private JTextField fiel_npe;
	private JTextField fiel_xeem; 
	private JButton button_add;
	
	/**
	 * Contructor with a frame that the dialog will dispaly on
	 * @param frame - the frame dialog will display on
	 */
	public DialogCreatYawgKoobTop(Control_UI con_ui) {
		this.cltr_ui = con_ui;
		
		this.setTitle("Ntxiv ib tug yawg (neeg) tshiab rau hauv family tree");
		this.setSize(new Dimension(500, 250));
		this.setLocationRelativeTo(cltr_ui.getFrame().getWindow());
		
		
		/* Create all components */
		panel_main = new JPanel();
		panel_main.setBorder(BorderFactory.createTitledBorder("Ntxiv neeg"));		// Border 
		panel_main.setLayout(new BoxLayout(panel_main, BoxLayout.PAGE_AXIS));	// 
		
		panel_fiel_npe = new JPanel();
		//panel_fiel_xeem = new JPanel();
		panel_combo = new JPanel();
		panel_button = new JPanel();
		
		panel_fiel_npe.add(new JLabel("Npe :"));
		fiel_npe = new JTextField(15);
		panel_fiel_npe.add(fiel_npe);
		
		panel_fiel_npe.add(new JLabel("Xeem :"));
		//panel_fiel_xeem.add(new JLabel("Xeem :"));
		fiel_xeem = new JTextField(15);
		//panel_fiel_xeem.add(fiel_xeem);
		panel_fiel_npe.add(fiel_xeem);
		
		panel_combo.add(new JLabel("Nws txiv yog :"));
		combo = new JComboBox<>();
		//addAllTibNeegToCombo();
		combo.addItem(cltr_ui.getYawmSaub().getYawgKoobTop());
		panel_combo.add(combo);
		
		listener = new ButtonListener();
		button_add = new JButton("Ntxiv");
		button_add.addActionListener(listener);
		panel_button.add(button_add);
		
		panel_main.add(panel_fiel_npe);
		//panel_main.add(panel_fiel_xeem);
		panel_main.add(panel_combo);
		panel_main.add(panel_button);
		
		this.getContentPane().add(panel_main);
		
		showDial();
	}
	
	/**
	 * Show dialog popup
	 */
	public void showDial() {
		this.setVisible(true);
	}
	
	/**
	 * Hide dialog popup
	 */
	public void hideDial() {
		this.setVisible(false);
	}
	
	/**
	 * 
	 */
	protected void addAllTibNeegToCombo(){
		ArrayList<TibNeeg> list_tn = new ArrayList<>();
		list_tn = this.cltr_ui.getThsobTree();
		ListIterator<TibNeeg> litr = list_tn.listIterator();
		while(litr.hasNext()) {
			addItemToComboBox((TibNeeg) litr.next());
	      }
	}

	/**
	 * Add an Item (TiBNeeg) to combo box
	 * @param tn - Item to add
	 */
	protected void addItemToComboBox(TibNeeg tn){
		this.combo.addItem(tn);
	}
	
	
	/* ++++++++ Class Listener ++++++++ */
	private class ButtonListener implements ActionListener {
		  public void actionPerformed (ActionEvent event) {
		    Object source = event.getSource();

		    if (source == button_add) {
		    	/* Get informations from form */
		    	String npe = fiel_npe.getText();
		    	String xeem = fiel_xeem.getText();
		    	npe = npe.trim();
		    	xeem = xeem.trim();
		    	
		    	TibNeeg meNyuam = (TibNeeg) combo.getSelectedItem();
		    	
		    	/* Launch the modification */
		        cltr_ui.createTxivTshiab(npe, xeem, meNyuam, null);
		        hideDial();
		    }
		  }
	 }
	
	
	
}
