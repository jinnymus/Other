package tools;


public class Statistic {

    public int  	 countRequests	= 0;
    private int  	 countRequestsIncrement	= 0;
    public int       countThread	= 0;
    public Logger logger;
    
    public Statistic()
    {
        Logger logger = new Logger();
        logger.setType("none");
        this.logger = logger;
    }
  
    public String getCountRequestsByString()
    {
    	logger.debug("[Statistic] getCountRequests:   " + this.countRequests);
    	return Integer.toString(this.countRequests);
    }

    public String getCountThreadByString()
    {
    	logger.debug("[Statistic] getCountThread:   " + this.countThread);
    	return Integer.toString(this.countThread);
    }  
    
    public int getCountRequests()
    {
    	logger.debug("[Statistic] getCountRequests:   " + this.countRequests);
    	return this.countRequests;
    }

    public int getCountThread()
    {
    	logger.debug("[Statistic] getCountThread:   " + this.countThread);
    	return this.countThread;
    }    
    
    public void upperCountRequests()
    {
    	logger.debug("[Statistic] upperCountRequests");
    	this.countRequestsIncrement += 1;
    }

    public void upperCountThread()
    {
    	logger.debug("[Statistic] upperCountThread");
    	this.countThread += 1;
    } 
    
    public void clearCountRequests()
    {
    	this.countRequests=this.countRequestsIncrement;
    	this.countRequestsIncrement=0;
    }

    public void clearCountThread()
    {
    	this.countThread=0;
    } 
    
    public void downCountRequests()
    {
    	this.countRequests -= 1;
    }

    public void downCountThread()
    {
    	this.countThread -= 1;
    }    
}
