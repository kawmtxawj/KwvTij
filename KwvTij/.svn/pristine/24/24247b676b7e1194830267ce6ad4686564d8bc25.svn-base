package model;

import java.util.ArrayList;
import java.util.ListIterator;

import control.Control_UI;

public class ShowHierarchy {
	
	private static String firstSpace = "        "; 	// 8 espaces
	private static String kab_ver = "|";
	private static String kab_hor = "-";
	private ArrayList<String> spaceUaNtejNpe ;	
	//private ArrayList<TibNeeg> meNyuam;			// file for read through tree
	
	
	/**
	 * Contructor of Show hierarchy
	 * @param con - the controller 
	 */
	public ShowHierarchy() {
		this.spaceUaNtejNpe = new ArrayList<String>(125); // Initial to 125 items 
		//this.meNyuam = new ArrayList<TibNeeg>(256); // Initial to 256 Tus meNyuam 
	}
	
	protected void displayNpeXeem(String line){
		System.out.println(line);
	}
	
	protected void addFirstSpace(){
		this.spaceUaNtejNpe.add(firstSpace);
	}
	
	/**
	 * Get all space possible before Npe
	 * @return space - Space before Npe
	 */
	protected String getAllFirstSpace(){
		String space = "";
		ListIterator<String> litr = this.spaceUaNtejNpe.listIterator();
		while(litr.hasNext()){
			space = space.concat((String)litr.next());
			space = space.concat(kab_ver);
		}
		return space;
	}
	
	/*
	protected void getInFileCovMeNyuam(TibNeeg tn) {
		int i=0;
		while(i<tn.countCovTub()){
			meNyuam.add(tn.getCovTub().get(i));
			
			System.out.println(" >> "+ i +" $ "+ tn.getCovTub().get(i).getNpe());
			i++;
		}
	}
	
	
	protected void removeMeNyuamFromFile(int ind) {
		this.meNyuam.remove(ind);
	}
	*/
	
	protected void addIbQhoFisrtSpace(){
		this.spaceUaNtejNpe.add(firstSpace);
	}
	
	protected void removeIbQhoFisrtSpace(){
		if(!this.spaceUaNtejNpe.isEmpty()){
			this.spaceUaNtejNpe.remove(0);
		}
	}
	
	
	/**
	 * Show hierarchy, pib ntawm tus yawg parameter
	 * @param tn_no - tus yawg uas pib show mus lawm hauv
	 */
	public void showTusYawgNoDown(TibNeeg tn_no){
		ArrayList<TibNeeg> covNyuam;			// file for read through tree
		covNyuam = new ArrayList<TibNeeg>(12);  // Limit 12 tug me nyuam
		
		String line = new String("");
		line = line.concat(getAllFirstSpace());	// Get all first space
		line = line.concat(kab_hor);			// Trait un ntej lub Npe
		line = line.concat(tn_no.getNpeXeem()); // Npe tus Yawg no
		displayNpeXeem(line);					// Display line courant

		if(tn_no.isMuajMeNyuam()){ 			// Yog muaj me nyuam
			
			// Get all me nyuam
			int i=0;
			while(i<tn_no.countCovTub()){
				covNyuam.add(tn_no.getCovTub().get(i));
				i++;
			}
			
			// Recusive cov menyuam
			ListIterator<TibNeeg> litr = covNyuam.listIterator();
			while(litr.hasNext()) {
		         TibNeeg tn = (TibNeeg) litr.next();
		         addIbQhoFisrtSpace();
		         showTusYawgNoDown(tn);
		      }
			
			/*
			ListIterator<TibNeeg> litr = this.meNyuam.listIterator();
			while(litr.hasNext()) {
		         TibNeeg tn = (TibNeeg) litr.next();
		         addIbQhoFisrtSpace();						// Add ib level (Phaj) tib neeg
		         show(tn);	// Recusive
		      }
		      */
			/*
			int i=0;
			while(i<this.meNyuam.size()){
				//addIbQhoFisrtSpace();						// Add ib level (Phaj) tib neeg
				show(this.meNyuam.get(i));					// Recusive
				removeMeNyuamFromFile(i);
				i++;
				
				System.out.println("++ "+i);
			}
			*/
			
			
		}
			removeIbQhoFisrtSpace();			// Return 1 Level (Phaj)
	}
	
}
