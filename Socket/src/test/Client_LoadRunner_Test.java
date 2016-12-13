package test;


public class Client_LoadRunner_Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Client_LoadRunner client = new Client_LoadRunner("127.0.0.1", 6666);
		client.start();
	}

}
