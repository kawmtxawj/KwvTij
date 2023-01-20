package ui;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import model.TibNeeg;
import model.YawmSuab;

public class UIFamilyTree extends JPanel{

	/**
	 * Default UID
	 */
	private static final long serialVersionUID = 1L;
	private TibNeeg root;
	private YawmSuab yawmSuab;
	private UIOption option;
	
	/**
	 * Constant
	 */
	public static Color LABEL_DEFAULT_BACKGROUND = Color.GRAY;
	public static Color LABEL_ENTER_BACKGROUND = Color.BLUE;
	
	
	/**
	 * Constructor
	 * @param yawmSuab
	 */
	public UIFamilyTree(YawmSuab yawmSuab, UIOption opt) {
		this.setBorder(BorderFactory.createTitledBorder(" Family Tree "));
		
		this.option = opt;
		setYawmSaub(yawmSuab);
		setRoot(yawmSuab.getYawgKoobTop());
		
		this.add(buildTree());
		
	}
	
	/**
	 * Build family tree panel
	 * @return
	 */
    public JScrollPane buildTree() {
    	JPanel pan_family_tree = new JPanel();
		new UIRecusivePan(pan_family_tree, root, this.yawmSuab, this.option);
		
		JScrollPane scroller_main_pan = new JScrollPane (pan_family_tree);
		scroller_main_pan.setPreferredSize (new Dimension (900, 660));
		
		return scroller_main_pan ;
	}
	
    /**
     * Refresh panel family tree
     */
	public void refresh_tree(){ 
		this.removeAll();
		this.root = this.yawmSuab.getYawgKoobTop();
		this.add(buildTree());
		this.revalidate();
		this.repaint();
	}
    
	/* Getting & setting */
	
	public TibNeeg getRoot() {
		return root;
	}

	public void setRoot(TibNeeg root) {
		this.root = root;
	}

	public YawmSuab getYawmSaub() {
		return yawmSuab;
	}

	public void setYawmSaub(YawmSuab yawmSuab) {
		this.yawmSuab = yawmSuab;
	}
	
}
