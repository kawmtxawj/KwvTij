package ui;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import model.TibNeeg;
import model.YawmSuab;

/**
 * This class is a Panel consist to display a TibNeeg and his children.
 * This class is called recursively
 * @author Anukun
 *
 */
public class UIRecusivePan extends JPanel{

	/**
	 * Default UID
	 */
	private static final long serialVersionUID = 1L;
	private JPanel panel_parent;
	private TibNeeg kuv_tn;
	private YawmSuab yawmSuab;
	private UIOption option;
	//private ArrayList<TibNeeg> covMeNyuam;
	
	private Dimension parent_dimension ;
	private int nomber_feuille;
	
	/**
	 * Constructor
	 * @param panel_parent
	 * @param root
	 */
	public UIRecusivePan(JPanel panel_parent, TibNeeg root, YawmSuab yS, UIOption opt) {
		this.yawmSuab = yS;
		this.option = opt;
		this.panel_parent = panel_parent;
		this.kuv_tn = root;
		this.nomber_feuille = yawmSuab.nomberFeuille(kuv_tn);
		
		//this.panel_parent.setPreferredSize(new Dimension(1300, 800));
		int family_tree_width = 130*this.nomber_feuille;
		int family_tree_height = 100*yawmSuab.heightTree(kuv_tn);
			
		parent_dimension = new Dimension(family_tree_width , family_tree_height);
		this.panel_parent.setPreferredSize(parent_dimension);
		
		
		//System.out.println("Height : "+ yawmSaub.heightTree(kuv_tn));
		
		
		this.panel_parent.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		this.panel_parent.setLayout(new GridBagLayout());
   		GridBagConstraints c = new GridBagConstraints();
   		
   		
		buidPanel_parent(c);
		
		build_axes(c);
		
		buildpanel_children(c);
	}

	

	/**
	 * Building of panel parent
	 */
	private void buidPanel_parent(GridBagConstraints c) {
		if(kuv_tn != null){
			
       		c.fill = GridBagConstraints.HORIZONTAL;
       		//c.ipady = 10;      //make this component tall
       		c.anchor = GridBagConstraints.PAGE_START;
       		c.weightx = 1;
       		c.gridwidth = this.nomber_feuille;
       		c.gridx = 0;
       		c.gridy = 0;
       		
       		this.panel_parent.add(new UIDisplay_Tibneeg(kuv_tn, this.yawmSuab, parent_dimension), c);
       		
       		
		}// END IF
	}// END Constructor
	
	private void build_axes(GridBagConstraints c) {
		
		JPanel line = new JPanel(){
			
			@Override
			public void setPreferredSize(Dimension preferredSize) {
				// TODO Auto-generated method stub
				int widht = this.getWidth();
				//super.setPreferredSize(new Dimension(widht, 30));
				//super.setPreferredSize(new Dimension(100, 30));
				super.setPreferredSize(preferredSize);
			}
			
			@Override
			public void paint(Graphics g) {
				int pan_tree_width = panel_parent.getWidth();
				super.paintComponent(g); 
	            Graphics2D g2d = (Graphics2D) g.create();
	            
		     	g2d.setColor(Color.BLACK);
		     	//g2d.setStroke(new BasicStroke(2, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
		     	
		     	if(kuv_tn.isMuajMeNyuam()){
			     	// Get width from number of children
			     	ArrayList<TibNeeg> meNyuam = (ArrayList<TibNeeg>) kuv_tn.getCovTub();
			     	if(meNyuam.size() == 1){
			     		// Axe from parent to his only child 
			     		int haft = (int) pan_tree_width/2;
			     		g2d.drawLine( haft, 0, haft, 30);
			     	}else{
			     		// Axe from parent to child
			     		int haft = (int) pan_tree_width/2;
			     		g2d.drawLine( haft, 0, haft, 10);
			     		
			     		// Axe cover all children
			     		int space_each_child = (int)(pan_tree_width/nomber_feuille);
			     		
			     		int space_first_child = space_each_child;
			     		int nomber_feuille_first_child = yawmSuab.nomberFeuille(meNyuam.get(0));
			     		if(nomber_feuille_first_child > 1){
			     			space_first_child = nomber_feuille_first_child*space_each_child;
			     		}
			     		
			     		int space_last_child = space_each_child;
			     		int nomber_feuille_last_child = yawmSuab.nomberFeuille(meNyuam.get(meNyuam.size()-1));  
			     		if( nomber_feuille_last_child > 1){
			     			space_last_child = nomber_feuille_last_child*space_each_child;
			     		}
			     		g2d.drawLine((space_first_child/2), 10, (nomber_feuille*space_each_child)-(space_last_child/2), 10);
			     		
			     		// Axes from axe cover all children to each child
			     		g2d.drawLine( space_first_child/2, 10, space_first_child/2, 30);					// First child
			     		int last_trait = (nomber_feuille*space_each_child)-(space_last_child/2);
			     		g2d.drawLine( last_trait, 10, last_trait, 30);									// Last child
			     		
			     		int i = 1;
			     		int space_accurate = space_first_child;											// Space first child
			     		while(i<meNyuam.size()-1){
			     			int space_child_current = space_each_child; 
			     			int nomber_feuille_current = yawmSuab.nomberFeuille(meNyuam.get(i));
			     			if(nomber_feuille_current > 1){
			     				space_child_current = nomber_feuille_current*space_each_child;
			     			}
			     			space_accurate += space_child_current;		
			     			int pointX1 = space_accurate - (space_child_current/2);
			     			g2d.drawLine( pointX1, 10, pointX1, 30);
			     			i++;
			     		}
			     		
			     	}
			     	g2d.dispose();
			     	
		     	}// END Muaj MeNyuam
		     	
				//super.paint(g);
			}
		};
		
		int widht = this.getWidth();
		//line.setPreferredSize(new Dimension(parent_dimension.width, 20));
		line.setPreferredSize(new Dimension(widht, 30));
		
		
		
		line.setBorder(BorderFactory.createEtchedBorder());
		
		//c.ipadx = 10;
		c.gridx = 0;
   		c.gridy = 1;
   		
   		this.panel_parent.add(line, c);
	}

	
	
	private void buildpanel_children(GridBagConstraints c) {
		//c.anchor = GridBagConstraints.PAGE_START; //bottom of space
   		
   		JPanel pan_child1 = null;
   		JPanel pan_child2 = null;
   		JPanel pan_child3 = null;
   		JPanel pan_child4 = null;
   		JPanel pan_child5 = null;
   		JPanel pan_child6 = null;
   		JPanel pan_child7 = null;
   		JPanel pan_child8 = null;
   		JPanel pan_child9 = null;
   		JPanel pan_child10 = null;
   		JPanel pan_child11 = null;
   		JPanel pan_child12 = null;
   		JPanel pan_child13 = null;
   		JPanel pan_child14 = null;
   		JPanel pan_child15 = null;
   		
   		   		
   		if(kuv_tn.getCovTub().size() >=1){
       		
       		//System.out.println("First chied leaf = "+this.yawmSaub.nomberFeuille(kuv_tn.getCovTub().get(0)));
       		c.weightx=  (double) this.yawmSuab.nomberFeuille(kuv_tn.getCovTub().get(0))/nomber_feuille;
       		c.gridx = 0;
       		c.gridy = 2;
       		c.gridwidth=1;
       		
       		pan_child1 = new JPanel();
       		//pan_child1.setBorder(BorderFactory.createEtchedBorder());
       		this.panel_parent.add(pan_child1, c);
   		}
   		
   		if(kuv_tn.getCovTub().size() >=2){
       		c.weightx= (double) this.yawmSuab.nomberFeuille(kuv_tn.getCovTub().get(1))/nomber_feuille;
       		c.gridx = 1;
       		c.gridy = 2;
       		//c.gridwidth=1;
       		pan_child2 = new JPanel();
       		this.panel_parent.add(pan_child2, c);
   		}
   		
   		if(kuv_tn.getCovTub().size() >=3){
       		c.weightx= (double) this.yawmSuab.nomberFeuille(kuv_tn.getCovTub().get(2))/nomber_feuille;
       		c.gridx = 2;
       		c.gridy = 2;
       		//c.gridwidth=1;
       		pan_child3 = new JPanel();
       		this.panel_parent.add(pan_child3, c);
       		
   		}
   		
   		if(kuv_tn.getCovTub().size() >=4){
       		c.weightx= (double) this.yawmSuab.nomberFeuille(kuv_tn.getCovTub().get(3))/nomber_feuille;
       		c.gridx = 3;
       		c.gridy = 2;
       		//c.gridwidth=1;
       		pan_child4 = new JPanel();
       		this.panel_parent.add(pan_child4, c);
       		
   		}
   		
   		if(kuv_tn.getCovTub().size() >=5){
       		c.weightx= (double) this.yawmSuab.nomberFeuille(kuv_tn.getCovTub().get(4))/nomber_feuille;
       		c.gridx = 4;
       		c.gridy = 2;
       		//c.gridwidth=1;
       		pan_child5 = new JPanel();
       		this.panel_parent.add(pan_child5, c);
       		
   		}
   		
   		if(kuv_tn.getCovTub().size() >=6){
       		c.weightx= (double) this.yawmSuab.nomberFeuille(kuv_tn.getCovTub().get(5))/nomber_feuille;
       		c.gridx = 5;
       		c.gridy = 2;
       		pan_child6 = new JPanel();
       		this.panel_parent.add(pan_child6, c);
   		}
   		
   		if(kuv_tn.getCovTub().size() >=7){
       		c.weightx= (double) this.yawmSuab.nomberFeuille(kuv_tn.getCovTub().get(6))/nomber_feuille;
       		c.gridx = 6;
       		c.gridy = 2;
       		pan_child7 = new JPanel();
       		this.panel_parent.add(pan_child7, c);
   		}
   		
   		if(kuv_tn.getCovTub().size() >=8){
       		c.weightx= (double) this.yawmSuab.nomberFeuille(kuv_tn.getCovTub().get(7))/nomber_feuille;
       		c.gridx = 7;
       		c.gridy = 2;
       		pan_child8 = new JPanel();
       		this.panel_parent.add(pan_child8, c);
   		}
   		
   		if(kuv_tn.getCovTub().size() >=9){
       		c.weightx= (double) this.yawmSuab.nomberFeuille(kuv_tn.getCovTub().get(8))/nomber_feuille;
       		c.gridx = 8;
       		c.gridy = 2;
       		pan_child9 = new JPanel();
       		this.panel_parent.add(pan_child9, c);
   		}
   		
   		if(kuv_tn.getCovTub().size() >=10){
       		c.weightx= (double) this.yawmSuab.nomberFeuille(kuv_tn.getCovTub().get(9))/nomber_feuille;
       		c.gridx = 9;
       		c.gridy = 2;
       		pan_child10 = new JPanel();
       		this.panel_parent.add(pan_child10, c);
   		}
   		
   		if(kuv_tn.getCovTub().size() >=1){
   			new UIRecusivePan(pan_child1, kuv_tn.getCovTub().get(0), this.yawmSuab, this.option);
   		}
   		if(kuv_tn.getCovTub().size() >=2){
   			new UIRecusivePan(pan_child2, kuv_tn.getCovTub().get(1), this.yawmSuab, this.option);
   		}
   		if(kuv_tn.getCovTub().size() >=3){
   			new UIRecusivePan(pan_child3, kuv_tn.getCovTub().get(2), this.yawmSuab, this.option);
   		}
   		if(kuv_tn.getCovTub().size() >=4){
   			new UIRecusivePan(pan_child4, kuv_tn.getCovTub().get(3), this.yawmSuab, this.option);
   		}
   		if(kuv_tn.getCovTub().size() >=5){
   			new UIRecusivePan(pan_child5, kuv_tn.getCovTub().get(4), this.yawmSuab, this.option);
   		}
   		if(kuv_tn.getCovTub().size() >=6){
   			new UIRecusivePan(pan_child6, kuv_tn.getCovTub().get(5), this.yawmSuab, this.option);
   		}
   		if(kuv_tn.getCovTub().size() >=7){
   			new UIRecusivePan(pan_child7, kuv_tn.getCovTub().get(6), this.yawmSuab, this.option);
   		}
   		if(kuv_tn.getCovTub().size() >=8){
   			new UIRecusivePan(pan_child8, kuv_tn.getCovTub().get(7), this.yawmSuab, this.option);
   		}
   		if(kuv_tn.getCovTub().size() >=9){
   			new UIRecusivePan(pan_child9, kuv_tn.getCovTub().get(8), this.yawmSuab, this.option);
   		}
   		if(kuv_tn.getCovTub().size() >=10){
   			new UIRecusivePan(pan_child10, kuv_tn.getCovTub().get(9), this.yawmSuab, this.option);
   		}
   		
	}

	
	/* Getter & setter */
	public JPanel getPanel_parent() {
		return panel_parent;
	}

	public void setPanel_parent(JPanel panel_parent) {
		this.panel_parent = panel_parent;
	}

	/*
	public ArrayList<TibNeeg> getCovMeNyuam() {
		return covMeNyuam;
	}

	public void setCovMeNyuam(ArrayList<TibNeeg> covMeNyuam) {
		this.covMeNyuam = covMeNyuam;
	}
*/
	
	public TibNeeg getKuv_tn() {
		return kuv_tn;
	}

	public void setKuv_tn(TibNeeg kuv_tn) {
		this.kuv_tn = kuv_tn;
	}
	
	
}
