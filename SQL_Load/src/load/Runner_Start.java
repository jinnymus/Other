package load;

public class Runner_Start {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		for (int i = 0; i < 2; i++) {
			Runner runner = new Runner(i);
			new Thread(runner).start();
		}
	}

}
