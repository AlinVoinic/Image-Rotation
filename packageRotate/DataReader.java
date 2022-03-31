package packageRotate;

import java.util.Scanner;

/*
 * Clasa abstracta: - citirea informatiilor necesare: 
 * 						- nume fisier intrare
 * 						- nume fisier iesire
 * 						- path-ul fisierului de intrare
 */

public abstract class DataReader implements Interface{
	private static String path; 		//path-ul pentru fisiere
	private static String outputName;	//numele fisierului de iesire
	private static String inputName;	//numele fisierului de intrare
	
	// Getter si Setter pentru path
	public static String getPath() {
		return path;
	}
	
	public static void setPath(String name) {
		path = name;
	}
	
	// Getter si Setter pentru outputName
	public static String getOutputName() {
		return outputName;
	}
	
	public static void setOutputName(String name) {
		outputName = name;
	}
	
	// Getter si Setter pentru inputName
	public static String getInputName() {
		return inputName;
	}
	
	public static void setInputName(String name) {
		inputName = name;
	}
	
	public void interfaceMessage() { 
		System.out.println("| Message from abstract class.");
	}
	
	
	 // Metoda pentru citirea informatiilor necesare in cazul in care datele 
	 // sunt introduse de la tastatura si nu prin linie de comanda
	public static void readData() {
		System.out.println("---Insert data about image---");
		
		Scanner in = new Scanner(System.in);				//declarare obiect de tip scanner
		
		System.out.println("Insert image path: ");
		String pathName = in.nextLine();					//citire de la tastatura path fisier
		
		System.out.println("Insert image name: ");
		String pictureInName = in.nextLine();				//citire de la tastatura nume fisier intrare
		
		System.out.println("Insert rotated image name: ");
		String pictureOutName = in.nextLine();				//citire de la tastatura nume fisier iesire
		
		in.close();											//inchidere scanner
		
		setPath(pathName);									//setare path
		setInputName(pictureInName);						//setare fisier de intrare
		setOutputName(pictureOutName);						//setaer fisier de iesire
	}
	
	abstract public void abstractMethod();
}
