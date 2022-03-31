package packageRotate;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

import packageTest.Start;

public class Consumer extends Start implements Runnable{
	Buffer buffer; //element de tip Buffer pentru stocarea coloanei
	
	int [][] picture = new int[Start.getImageWidth()][Start.getImageHeight()];
	BufferedImage flippedPicture = new BufferedImage (Start.getImageWidth(), Start.getImageHeight(), BufferedImage.TYPE_INT_RGB);
	
	Consumer(Buffer buffer) {
		this.buffer = buffer;
	}

	@Override
	public void run() {
		for (int i = 0; i < Start.getImageWidth(); i++)
			picture[i] = buffer.get(); //stocare coloana primita de la Producer
		
		long startTime = System.currentTimeMillis(); //moment incepere modificare coloana
		
		for (int i = 0; i < Start.getImageWidth() / 2; i++) {
			for (int j = i; j < Start.getImageHeight() - i - 1; j++) {
				Color temp = new Color(picture[i][j]);
				//algoritm pentru rotirea matricei 90 de grade la dreapta
				flippedPicture.setRGB(i, j, picture[j][Start.getImageWidth() - 1 - i]);
				flippedPicture.setRGB(j, Start.getImageHeight() - i - 1, 
						picture[Start.getImageWidth() - 1 - i][Start.getImageHeight() - j - 1]);
				flippedPicture.setRGB(Start.getImageWidth() - 1 - i, Start.getImageHeight() - j - 1, 
						picture[Start.getImageWidth() - 1 - j][i]);
				flippedPicture.setRGB(Start.getImageWidth() - 1 - j, i, temp.getRGB());
			}
		}
		
		long finalTime = System.currentTimeMillis();	//moment incheiere modificare coloana
		long workingTime = finalTime - startTime;		//timpul petrecut pentru modificare coloanei
		
		System.out.println("\n ---Coloana a fost modificata---");
		System.out.println("| Start time: " + startTime + " ms");
		System.out.println("| Final time: " + finalTime + " ms");
		System.out.println("| Work time: " + workingTime + " ms");
		
		long startTime2 = System.currentTimeMillis();	//moment incepere scriere vector in noua imagine
		try {
			File pictureOutFile = null;
			pictureOutFile = new File(getPath() + "\\" + getOutputName() + ".bmp");
			ImageIO.write(flippedPicture, "bmp", pictureOutFile);
		} catch(IOException e) {
			System.out.println("Error: " + e);
		}
		
		long finalTime2 = System.currentTimeMillis();	//moment incheiere scriere vector in noua imagine
		long workingTime2 = finalTime2 - startTime2;	//timpul petrecut pentru scrierea vectorului in noua imagine
		
		System.out.println("\n ---Coloana a fost scrisa---");
		System.out.println("| Start time: " + startTime2 + " ms");
		System.out.println("| Final time: " + finalTime2 + " ms");
		System.out.println("| Work time: " + workingTime2 + " ms");
	}

}
