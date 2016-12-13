package tools;

public class Logger {

	public String type = new String();
	
	public void info(String message)
	{
		if (this.type.equals("info"))
		{
			System.out.println("[" + this.type +"] " + message);
		}
	}
	
	public void stat(String message)
	{
		if (this.type.equals("stat"))
		{
			System.out.println("[" + this.type +"] " + message);
		}
	}
	
	public void error(String message)
	{
		System.out.println("[" + this.type +"] " + message);
	}
	
	public void debug(String message)
	{
		if (this.type.equals("debug"))
		{
			System.out.println("[" + this.type +"] " + message);
		}
	}
	
	public void setType(String type)
	{
		this.type = type;
	}
	
}
