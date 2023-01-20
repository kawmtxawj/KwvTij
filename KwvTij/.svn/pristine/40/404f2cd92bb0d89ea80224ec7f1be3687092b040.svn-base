package ui;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.ListIterator;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

import model.TibNeeg;
import control.Control_UI;

/**
 * Dialog to delete a TibNeeg that existed in the family tree
 * @author Kao Vang
 *
 */
public class DialogDeleteTibNeeg extends JDialog{
	
	/**
	 * Default serial UID
	 */
	private static final long serialVersionUID = 1L;
	
	private Control_UI cltr_ui;
	private ButtonListener listener;
	
	/* Components in this dialog*/
	private JPanel panel_main;
	public JPanel panel_show_meNyuam;
	public JLabel label_show_meNyuam;
	private JPanel panel_combo;
	private JPanel panel_button;
	private JComboBox<TibNeeg> combo;
	private JButton button_delete;
	
	
	/**
	 * Contructor of a dialog box allows to delete a Tib Neeg 
	 * @param frame - the frame that dialog will display on
	 */
	public DialogDeleteTibNeeg(Control_UI con_ui) {
		this.cltr_ui = con_ui;
		
		this.setTitle("Create tus yawg koob top tshiab");
		this.setSize(new Dimension(500, 250));
		this.setLocationRelativeTo(cltr_ui.getFrame().getWindow());
		
		
		/* Create all components */
		panel_main = new JPanel();
		panel_main.setBorder(BorderFactory.createTitledBorder("Delete"));		// Border 
		panel_main.setLayout(new BoxLayout(panel_main, BoxLayout.PAGE_AXIS));	// 
		
		panel_combo = new JPanel();
		panel_button = new JPanel();
				
		panel_combo.add(new JLabel("Xav tus yawg uas yuav delete :"));
		combo = new JComboBox<>();
		ComboboxListener comboListener = new ComboboxListener();
		combo.addItemListener(comboListener);
		
		addAllTibNeegToCombo();
		panel_combo.add(combo);
		
		panel_show_meNyuam = new JPanel();
		//panel_show_meNyuam.setPreferredSize(new Dimension(450, 100));
		panel_show_meNyuam.setSize(450, 100);
		panel_show_meNyuam.setBorder(BorderFactory.createTitledBorder("Cov me nyuam"));		// Border
		label_show_meNyuam = new JLabel();
		label_show_meNyuam.setText("Warning !");
		panel_show_meNyuam.add(label_show_meNyuam);
		
		listener = new ButtonListener();
		button_delete = new JButton("Delete");
		button_delete.addActionListener(listener);
		panel_button.add(button_delete);
		
		panel_main.add(panel_combo);
		panel_main.add(panel_button);
		panel_main.add(panel_show_meNyuam);
		
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

		    if (source == button_delete) {
		    	/* Get informations from form */
		    	TibNeeg tn = (TibNeeg) combo.getSelectedItem();
		    	
		    	/* Launch the modification */
		    	cltr_ui.deleteTibNeeg(tn);
		        hideDial();
		    }
		  }
	 }
	
	private class ComboboxListener implements ItemListener {

		@Override
		public void itemStateChanged(ItemEvent e) {
			if (e.getStateChange() == ItemEvent.SELECTED) {
				 if (e.getSource() == combo) {
					 TibNeeg tn_selected = (TibNeeg) combo.getSelectedItem();
					 System.out.println("Combo selected : [ "+tn_selected+" ]");
					 String info = "Ua twb zoo saib: Yog koj delete [ "+ tn_selected +" ], nws cov me nyuam thiab nws cov xeeb ntxwv puas leej mag delete tag nrho.\n";
					 info = info.concat("");
					 
					 combo_changed(info);
					 
					 //panel_show_meNyuam.remove(label_show_meNyuam);
					 //label_show_meNyuam.setText("Test ");
					 //panel_show_meNyuam.repaint();
					 //System.out.println(""+info);
					 
					 System.out.println("--> "+tn_selected.getTebChawTuag());
					 //A modify
				 }
			}
		}
	}
	
	public void combo_changed(String info) {
		//panel_show_meNyuam.setToolTipText(info);
		
		//panel_main.add(new JLabel(info));
		//panel_show_meNyuam.add(new JLabel(info));
		panel_main.repaint();
		
	}
	
}
