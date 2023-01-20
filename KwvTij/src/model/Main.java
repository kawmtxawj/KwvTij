package model;

import control.Control_UI;

public class Main {
	

	 public static void main(String args[]) {
		 
		 /*
		 Date today = new Date();
	     System.out.println(today);
	     
	     TibNeeg vamSawm = new TibNeeg("Vam Sawm", "Vaj");
	     TibNeeg neejTsom = new TibNeeg("Neej Tsom", "Vaj");
	     
	     neejTsom.setTxiv(vamSawm);
	     vamSawm.ntxivTub(neejTsom);
	     
	     TibNeeg yeeg = new TibNeeg("Yeeg", "Vaj");
	     TibNeeg tub2 = new TibNeeg("Tub2", "Vaj");
	     yeeg.setTxiv(neejTsom);
	     neejTsom.ntxivTub(yeeg);
	     tub2.setTxiv(neejTsom);
	     neejTsom.ntxivTub(tub2);
	     
	     TibNeeg kaus = new TibNeeg("Kaus", "Vaj");
	     
	     kaus.setTxiv(vamSawm);
	     vamSawm.ntxivTub(kaus);
	     
	     TibNeeg laujpov = new TibNeeg("Lauj Pov", "Vaj");
	     TibNeeg keej = new TibNeeg("Keej", "Vaj");
	     
	     laujpov.setTxiv(kaus);
	     keej.setTxiv(kaus);
	     kaus.ntxivTub(laujpov);
	     kaus.ntxivTub(keej);
	     
	     TibNeeg tub_x1 = new TibNeeg("Xeeb Ntxwv 1", "Vaj");
	     tub_x1.setTxiv(laujpov);
	     laujpov.ntxivTub(tub_x1);
	     */
	     
	      /*
	     System.out.println(kaus.getNpe()+" "+kaus.getXeem());
	     System.out.println(kaus.getNpe()+" Txiv lub npe hu : "+kaus.getTxiv().getNpe()+" "+kaus.getTxiv().getXeem());
	     
	     System.out.println(vamSawm.getNpe()+" muaj "+ vamSawm.countCovTub()+" yug tub ");
	     ArrayList<TibNeeg> covTub = (ArrayList<TibNeeg>) vamSawm.getCovTub();
	     for(int i=0;i<covTub.size();i++){
	    	 System.out.println(covTub.get(i).getNpe() +"\n");
	    	 
	     }
	    
	     System.out.println("------------>");
	     
	     Controller cltr = new Controller();
	     cltr.save(vamSawm);
	     cltr.open();
	     cltr.displayCovTub();
	  
	     
*/
		 
	     //Controller cltr = new Controller(vamSawm);
	     //ShowHierarchy hiera = new ShowHierarchy(cltr);
	     //hiera.show(cltr.getTusYawgKawg());
	     
	     Control_UI con_ui = new Control_UI();
	     con_ui.launch();
	     
	     
	 }
}
