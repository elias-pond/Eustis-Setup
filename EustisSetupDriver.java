/*	INSERT STUDENT NAME
	Eustis Setup
	COP3503 Computer Science 2
	EustisSetupDriver.java
	Compile: javac EustisSetupDriver.java
	Run: java EustisSetupDriver [CASE]
*/

public class EustisSetupDriver
{
	public static void main(String args[])
	{
		int testCase = Integer.parseInt(args[0]);
		EustisSetup obj = new EustisSetup();
		
		switch(testCase)
		{
			case 1:
			
				obj.printMessages();
				break;
				
			case 2:
			
				//scenario 1
				int tickets = obj.computeTickets(0, 1.0, 0);
				System.out.println("The number of tickets is " + tickets);
				
				//scenario 2
				tickets = obj.computeTickets(4, 1.0, 0);
				System.out.println("The number of tickets is " + tickets);
				
				//scenario 3
				tickets = obj.computeTickets(6, 1.25, 0);
				System.out.println("The number of tickets is " + tickets);
				
				//scenario 4
				tickets = obj.computeTickets(5, 1.5, 10);
				System.out.println("The number of tickets is " + tickets);

				//scenario 5
				tickets = obj.computeTickets(8, 2.0, 25);
				System.out.println("The number of tickets is " + tickets);				
				break;
				
			case 3:
				
				//scenario 1
				EustisSetup p1 = new EustisSetup("Nova", 12, 1.5);
				
				//scenario 2
				EustisSetup p2 = new EustisSetup("Blitz", 1, 1.0);
				
				//scenario 3
				EustisSetup p3 = new EustisSetup("Pixel", 60, 2.0);
				
				//scenario 4
				EustisSetup p4 = new EustisSetup("Comet", -4, 1.25);
				
				//scenario 5
				EustisSetup p5 = new EustisSetup("Echo", 25, -3.5);
				
				EustisSetup arcade [] = {p1, p2, p3, p4, p5};
				
				for (EustisSetup p : arcade)
					System.out.println(p.toString());

				break;
				
			case 4:
			
				obj.category();
				break;
				
			default:
				System.out.println("Invalid Test Case...");
		}
	}
}