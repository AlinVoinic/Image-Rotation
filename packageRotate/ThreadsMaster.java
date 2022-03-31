package packageRotate;

public class ThreadsMaster extends DataReader{

	@Override
	public void abstractMethod() {
	}
	
	public static void threadsMaster() {
		Buffer buffer = new Buffer();
		
		Thread threadProducer = new Thread(new Producer(buffer)); //creare thread Producer
		Thread threadConsumer = new Thread(new Consumer(buffer)); //creare thread Consumer
		
		threadProducer.start();	//pornire thread Producer
		threadConsumer.start();	//pornire thread Consumer
		
		try {
			threadProducer.join();	//asteptare thread Producer
			threadConsumer.join();	//asteptare thread Consumer
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public static void varargs(String ...args) {
		System.out.println("| Numar de argumente folosite pentru aceasta metoda: " + args.length);
	}

}
