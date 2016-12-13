package ru.Kalistratov.Kirill;

public class SoftwareDeveloperInTest {
	
	String Birth = "04.01.1983";
	Gender gender = Human.Man;
	String Citizenship = "Russia";
	String Phone = "+79680362213";
	String Mail = "Kalistratov.Kirill.a@gmail.com";
	Education HigherEducation = new Education("Moscow State University of Radiotechnics,"
			+ " Electronics and Automation", "2002 - 2008", "Engineer");
	String Language = English.PreIntermediate;
	
	public SoftwareDeveloperInTest()
	{
		Integer WorkTime = 8;
		Boolean BusinellTravel = true;
	}
	
	public Trainings ProfessionalTrainings()
	{	
		Trainings trainings = new Trainings();
		trainings.add(2014,"English.PreIntermediate","Denis' School");
		trainings.add(2013,"UNIX (Linux/FreeBSD) - Provide a high availability "
				+ "(clustering) solution","Computer Training Center at Bauman "
						+ "Moscow State Techincal University");
		return trainings;
	}

	public Achievements BellIntegrator (Position SeniorQA)
	{
		String WorkPeriod = "09.2014 - Now"; 

		Task task = Position.getTask(SeniorQA);
		task.add("Development a method of load testing, reporting on testing");
		task.add("Development and optimization scripts, conducting load testing: HP LoadRunner");
		task.add("Development stubs and clients: Java, WebServices, MQ, Database");
		task.add("Development scripts: unix shell, perl, java, sql, pl/sql");
		task.add("Monitoring and analyzing system resources, jvm");
		
		Achievements achievements = task.createAchievements();
		achievements.add("Conducted load testing for implementation of the website sberbank.ru"
				+ " on the platform BackBase with the participation of Microsoft,"
				+ " Amazon, Nginx, Backbase, IBM");
		achievements.add("Developed program for creating a Socket level load testing "
				+ "processing SmartVista, WAY4");
		
		return achievements;
	}

	public Achievements KasperskyLab (Position SeniorQA)
	{
		String WorkPeriod = "12.2011 — 09.2014";
		
		Task task = Position.getTask(SeniorQA);
		task.add("Automated functional and load testing of all services "
				+ "cloud server solutions: FreeBSD, Linux");
		task.add("Development scripts and tools for testing: shell, perl, java, c#");
		task.add("Modification of existing client-server solutions for load testing: c ++, c");
		task.add("Development of additional tools to ensure the testing process ");
		task.add("Adimister testing infrastructure, Vmware ESXi, vSphere");
		
		Achievements achievements = task.createAchievements();
		achievements.add("Designed, developed and implemented the infrastructure"
				+ " for automated testing (functional, monitoring, load) based on ESXi.");
		achievements.add("80% of strong logical errors were found by infrastructure");

		return achievements;
	}
	
	public Achievements AplanaSoftware (Position SeniorQAforLoadTesting)
	{
		String WorkPeriod = "10.2010 — 11.2011";
		
		Task task = Position.getTask(SeniorQAforLoadTesting);
		task.add("Conducting load testing: Web/HTTP, Webservices, ODBC");
		task.add("Development scripts: LoadRunner");
		task.add("Development stubs, clients and tools: WebServices, Java, C#");
		task.add("Analysis of results and reporting on testing.");
		
		Achievements achievements = task.createAchievements();
		achievements.add("Implemented knowledge base (wiki) to share experiences"
				+ " in testing and development.");

		return achievements;
	}
	
	public Achievements Megafon (Position SeniorQA)
	{
		String WorkPeriod = "09.2008 — 10.2010";
		
		Task task = Position.getTask(SeniorQA);
		task.add("Project management of testing and installation of new versions and the introduction"
				+ " of new software functionality BSS-systems.");
		task.add("Project management 'Service Guide'");
		task.add("Development test -plans and -cases");
		task.add("Making a report of testing");
		task.add("Optimization, performance monitoring, analysis, "
				+ "Troubleshooting Software BSS-systems");
		task.add("Preparing, configure and support of test environments, Solaris, HPux, Linux.");
		task.add("Development scripts: pl/sql, perl");
		task.add("Testing systems interfaces: USSD, IVR, SMS, STK, WAP, WWW.");
		
		Achievements achievements = task.createAchievements();
		achievements.add("Implemented a load testing for system 'Service Guide'");

		return achievements;
	}
		
	public Achievements BioLinkSolutions (Position LeadQA)
	{
		String WorkPeriod = "02.2006 — 08.2008";
		
		Task task = Position.getTask(LeadQA);
		task.add("Project management of testing and installation"
				+ " of new versions and the introduction"
				+ " of new software functionality BioTime, BioFortress, IDenium.");
		task.add("Conduction functional testing");
		task.add("Development test -plans and -cases");
		task.add("Making a report of testing");
		task.add("Preparing, configure and support of test environments, Windows AD");
		task.add("Development scripts: sql, vbs, cmd");
		task.add("Leading a senior qa");
		
		Achievements achievements = task.createAchievements();
		achievements.add("Implemented an automated functional testing"
				+ " based on Quality Center 9");

		return achievements;
	}
	
}
