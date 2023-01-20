package ui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class UICaseTrait extends JPanel {

	private Image trait;
	private BufferedImage traitImage;
	
	public UICaseTrait() {
		try {
			this.traitImage = ImageIO.read(new File("../icons/trait.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		Graphics2D graphics = (Graphics2D) g.create(); 
				
		Dimension dimension = new Dimension(20,20);
		
				
		BufferedImage imgTortue = new BufferedImage(dimension.width, dimension.height, 3); 
		Graphics2D graphImgTortue = imgTortue.createGraphics();
		
		Image imgTemp = createImage(this.getWidth(), this.getHeight());
		Graphics gTemp = imgTemp.getGraphics();
		gTemp.drawImage(this.traitImage, 0, 0, null);
		gTemp.drawImage(imgTortue, (dimension.width), dimension.height, null);
		// Affichage de l'image
		
		g.drawImage(imgTemp, 0, 0, null);
		
	}
	
}
