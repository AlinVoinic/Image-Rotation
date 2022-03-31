package packageTest;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import packageRotate.ThreadsMaster;

public class Start extends ThreadsMaster{
	private static int imageHeight;
	private static int imageWidth;
	public static BufferedImage picture = null;

	// Getter si Setter pentru imageHeight
	public static int getImageHeight() {
		return imageHeight;
	}

	public static void setImageHeight(int imageHeight) {
		Start.imageHeight = imageHeight;
	}

	// Getter si Setter pentru imageWidth
	public static int getImageWidth() {
		return imageWidth;
	}

	public static void setImageWidth(int imageWidth) {
		Start.imageWidth = imageWidth;
	}

	// Getter si Setter pentru Picture
	public static BufferedImage getPicture() {
		return picture;
	}

	public static void setPicture(BufferedImage picture) {
		Start.picture = picture;
	}

	public void abstractMethod() {
		System.out.println("Mesaj din metoda abstracta in Start.");
	}
	
	
	public static void main(String[] args) {
		if(args.length != 3) {
			// verific daca am argumente in linia de comanda
			// Daca nu sunt introduse argumente pentru toate cele 3 informatii
			// necesare, se ajunge la modul de introducere de la tastatura

			//System.out.println("Insuficient number of arguments");
			System.out.println("Insert data from keyboard \n");
		    readData();
		} else {
			// Daca avem toate argumentele in linia de comanda, le vom folosi direct

			String pathName = null;
			String pictureInName = null;
			String pictureOutName= null;
			
			pathName = args[0]; 		//introducere path din linie de comanda
			pictureInName = args[1];	//introducere nume fisier intrare din linie de comanda
			pictureOutName = args[2];	//introducere nume fisier iesire din linie de comanda
			
			setPath(pathName);				//setare path
			setInputName(pictureInName);	//setare nume fisier intrare
			setOutputName(pictureOutName);	//setare nume fisier iesire
		}
		
		//Afisare informatii introduse de la tastatura sau din linie de comanda
		System.out.println("\n -----Picture Info-----");
		System.out.println("| The path is: " + getPath() + "\t\t\t\t   |");
		System.out.println("| Picture name: " + getInputName() + ".bmp" + "\t\t\t   |");
		System.out.println("| Rotated picture name: " + getOutputName() + ".bmp" + "\t\t   |");
		System.out.println("+------------------------+ \n");
		
		//Aflam dimensiunile pozei (numar de linii si numar de coloane)
		try {
			File pictureInFile = null;
			pictureInFile = new File(getPath() + "\\" + getInputName() + ".bmp");
			picture = ImageIO.read(pictureInFile);
			
			setImageWidth(picture.getWidth());		//setare width (numar coloane)
			setImageHeight(picture.getHeight());	//setare height (numar linii)
			
			System.out.println("Inaltime (numar de linii) = " + getImageHeight());
			System.out.println("Latime (numar de coloane) = " + getImageWidth() + "\n");
		} catch(IOException e) {
			System.out.println("Error: " + e);
		}
		
		//Apelam functia care se ocupa de crearea si inceperea thread-urilor
		threadsMaster();
		
		//Testare metoda abstracta
		System.out.println("\n -----Metoda din clasa abstracta-----");
		ThreadsMaster object = new ThreadsMaster();
		object.interfaceMessage();
		
		//Testare Varargs
		System.out.println("\n -----Varargs-----");
		ThreadsMaster.varargs("Test1", "Test2", "Test3");

	}
}
