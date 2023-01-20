package control;

import java.util.ArrayList;

import model.ManageFile;
import model.TibNeeg;
import model.YawmSuab;
import ui.KaoFrame;

public class Control_UI {
	
	private static Control_UI instance;
	private YawmSuab yawmSuab;
	private ManageFile manageFile;
		
	private KaoFrame frame;
	
	/**
	 * Contructor
	 */
	public Control_UI() {
		
		TibNeeg vamSawm = new TibNeeg("Vam Sawm", "Vaj");// Thawj tug yawg
		this.yawmSuab = new YawmSuab(vamSawm);
		this.frame = new KaoFrame("Kao's window", this);
		this.manageFile = new ManageFile(this.frame, this);
	}
	
	/**
	 * Get all Tib Neeg ntawm tshob Tree
	 * @return all Tib Neeg
	 */
	public ArrayList<TibNeeg> getThsobTree() {
		return yawmSuab.getTagNrhoTshobTree();
	}
	
	

	public void openFile() {
		this.manageFile.openFileFamilyTree();
	}

	
	public void saveFile() {
		this.manageFile.save();
	}
	
	public void saveFileAs() {
		this.manageFile.saveAs();
	}
	
	public void launch() {
		this.frame.show();
	}
	
	public void showHierarchy() {
		this.yawmSuab.showHierarchy();
	}
	public YawmSuab getYawmSaub() {
		return this.yawmSuab;
	}

	public void setYawgKoobTop(TibNeeg ykTop) {
		this.yawmSuab.setYawgKoobTop(ykTop);
		
	}
	
	public static synchronized Control_UI getInstance() {
		if(instance == null) {
			instance = new Control_UI();
		}
		return instance;
	}

	/**
	 * Show dialog for creation of Txiv Tshiab
	 */
	public void creatTxivTshiabDialog() {
		this.yawmSuab.creatTxivTshiabDialog(this);
	}
	
	/**
	 * Call to create Txiv tshiab and link to his Txiv and his me nyuam
	 * @param npe - His npe 
	 * @param xeem - His xeem
	 * @param meNyuam - His me nyuam to link to 
	 * @param tx - His txiv to link to
	 */
	public void createTxivTshiab(String npe, String xeem, TibNeeg meNyuam, TibNeeg tx) {
		this.yawmSuab.createTxivTshiab( npe, xeem, meNyuam, tx);
	}
	
	public KaoFrame getFrame() {
		return frame;
	}

	public void deleteTibNeegDialog(String npe, String xeem, TibNeeg meNyuam, TibNeeg tx) {
		this.yawmSuab.deleteTibNeegDialog(this);
	}

	/**
	 * Launch Dialog to delete Tib Neeg
	 * @param cltr_ui - Control
	 */
	public void deleteTibNeegDialog(Control_UI cltr_ui) {
		this.yawmSuab.deleteTibNeegDialog(cltr_ui);
	}
	
	public void deleteTibNeeg(TibNeeg tn) {
		this.yawmSuab.deleteTibNeeg(tn);
	}

	public void modifyTibNeegDialog(Control_UI cltr_ui) {
		this.yawmSuab.modifyTibNeegDialog(cltr_ui);
		
	}

	public void modifyTibNeeg(TibNeeg tn, String npe, String xeem, String tebChawYug) {
		this.yawmSuab.modifyTibNeeg(tn, npe, xeem, tebChawYug);
		
	}

	public void ntxivTibNeegDialog(Control_UI cltr_ui) {
		this.yawmSuab.ntxivTibNeegDialog(cltr_ui);
	}

	public void ntxivTibNeeg(TibNeeg txiv, String npe, String xeem,
			String tebChawYug) {
		this.yawmSuab.ntxivTibNeeg(txiv, npe, xeem, tebChawYug);
	}

	


}
