package model;
import java.io.File;
import javax.swing.filechooser.FileFilter;

/** Classe permettant de creer un filtre pour les fichiers d'enregistrement/chargement du sudoku */
public class KuajFile extends FileFilter {


	// Attributs
	/** Description */
	private String description;
	/** Extension */
	private String extension;
	
	//Constructeur 
	/**
	 * constructeur a partir de la description et de l'extension acceptee
	 * @param description La description du filtre
	 * @param extension L'extension du filtre
	 */
	public KuajFile(String description, String extension) {
		this.description = description;
		this.extension = extension;
	}
	
	// Getters&Setters
	/** Retourne la description */
	public String getDescription(){
		return this.description;
	}
	
	// Getters&Setters
	/** Retourne l'extension */
	public String getExtension(){
		return this.extension;
	}

	/**
	 * Implementation de la methode abstraite d'acception de fichier
	 */
	public boolean accept(File file) {
		if(file.isDirectory()) 
			return true; 

		String nomFichier = file.getName().toLowerCase(); 
		return nomFichier.endsWith(this.extension);
	}

}