package packageRotate;

import packageTest.Start;

public class Producer extends Start implements Runnable{
	Buffer buffer; //element de tip Buffer pentru stocarea coloanei

	Producer(Buffer buffer) { // Constructor Producer
		this.buffer = buffer; 
	} 
	
	@Override
	public void run() {
		//initializare matrice de pixeli
		int [][] picture = new int [Start.getImageWidth()][Start.getImageHeight()]; 
		
		//Aflare valoare RGB pentru fiecare pixel din poza si stocare in matrice 
		for (int i = 0; i < Start.getImageWidth(); i++) {
			for (int j = 0; j < Start.getImageHeight(); j++) {
				picture[i][j] = Start.getPicture().getRGB(i, j);
			}
		}
		
		long startTime = System.currentTimeMillis(); //moment incepere trimitere date
		
		for (int i = 0; i < Start.getImageWidth(); i++) { 
			buffer.put(picture[i]); 				 //punem in buffer imaginea sub forma de matrice de pixeli
		}
		
		long finalTime = System.currentTimeMillis(); //moment incheiere trimitere date
		long workingTime = finalTime - startTime;	 //timpul petrecut pentru trimiterea datelor
		
		System.out.println("\n ---Coloana a fost trimisa---");
		System.out.println("| Start time: " + startTime + " ms");
		System.out.println("| Final time: " + finalTime + " ms");
		System.out.println("| Work time: " + workingTime + " ms");

	}
	
	public void abstractMethod() {}
}
