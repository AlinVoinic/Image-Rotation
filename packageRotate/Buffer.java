package packageRotate;

import packageTest.Start;

public class Buffer extends Start{
	int []bufferArray = new int[Start.getImageHeight()];

	boolean fullBuffer = true;
	// daca fullBuffer = true, Producer pune vector in buffer si Consumer asteapta
	// daca fullBuffer = false, Consumer ia din buffer vectorul si Producer asteapta
	
	int producerCounter = 0; //numarul coloanei trimise de Producer
	int consumerCounter = 0; //numarul coloanei prelucrate de Consumer
	
	public synchronized void put(int value[]) {
		while(fullBuffer == false) {
			try {
				wait();
			} catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		bufferArray = value; //punem in vector coloana citita
		fullBuffer = false;
		System.out.println("Producer trimite coloana: " + producerCounter + ".");
		
		try {
			Thread.sleep(10);
		} catch(InterruptedException e) {
			e.printStackTrace();
		}
		
		producerCounter++; //incrementam contorul
		notifyAll();		
	}
	

	public synchronized int[] get() {
		while (fullBuffer == true) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		fullBuffer = true;
		int temp[] = bufferArray;
		notifyAll();			
		System.out.println("Consumer primeste coloana: " + consumerCounter + ".");
		
		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		consumerCounter++; //incrementare contor
		return temp;	
	}
}
