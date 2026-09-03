/* Elias Pond
   Eustis Setup
   COP3503 Computer Science 2
   EustisSetup.java
*/

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

class EustisSetup
{
    private String name;
    private int skillLevel;
    private double ticketMultiplier;

    public void printMessages()
    {
        System.out.println("The semester started in the month of August.");
        System.out.println("The current year is 2026.");
        System.out.println("I am a CS2 student this semester!");
        System.out.println("I am so excited to learn more algorithms and advanced data structures!");
        System.out.println("Marvel Studios is going to release the movie Avengers: Doomsday in December!");
    }

    public int computeTickets(int gamesWon, double arcadeTicketMultiplier, int streakBonus)
    {
        double tickets = (gamesWon * 25 * arcadeTicketMultiplier) + streakBonus;

        int ticketsInt = (int)Math.round(tickets);
        
        return ticketsInt;
    }

    //constructor with parameters
    public EustisSetup(String name, int skillLevel, double ticketMultiplier)
    {
        this.name = name;

        if (skillLevel < 1)
        {
            this.skillLevel = 1;
        }
        else if (skillLevel > 50)
        {
            this.skillLevel = 50;
        }
        else
        {
            this.skillLevel = skillLevel;
        }

        if (ticketMultiplier < 0)
        {
            this.ticketMultiplier = 0.0;
        }
        else
        {
            this.ticketMultiplier = ticketMultiplier;
        } 
    }

    // empty constructor to account for 3-argument constructor
    public EustisSetup()
    {

    }


    public String toString()
    {
        return "ArcadePlayer{name = '" + this.name + "', level = " + this.skillLevel + ", multiplier = " + this.ticketMultiplier + "}";
    }

    public void category()
    {
        File file = new File("arcade.in");

        // initialize counter and RPR variables
        int counter = 0;
        double maxRPR = 0.0;
        String maxRPRTitle = "";
        double sumRPR = 0.0;

        // initalize earner types
        int needsRepair = 0;
        int lowEarner = 0;
        int steady = 0;
        int popular = 0;
        int superstar = 0;

        try (Scanner scanner = new Scanner(file))
        {
            while (scanner.hasNextLine())
            {
                //counts total iterations
                counter++;

                //reads lines of arcade.in
                String line = scanner.nextLine();

                //adds the requested blank spaces
                String[] pieces = line.split(" "); 

                //replace underscores with blank space and initializes pieces
                String title = pieces[0].replace('_', ' ');
                double price = Double.parseDouble(pieces[1]);
                double revenue = Double.parseDouble(pieces[2]);

                // rpr and sum or rpr values
                double rpr = revenue / price;
                sumRPR = sumRPR + rpr;

                // if statement checker for max RPR
                if(rpr > maxRPR)
                {
                    maxRPR = rpr;
                    maxRPRTitle = title;
                }

                // print statements for game, price, revenue, and rpr
                System.out.println("-----------------------------------");
                System.out.println("Game: " + title);
                System.out.printf("Price: %.2f%n", price);
                System.out.printf("Revenue: %.2f%n", revenue);
                System.out.printf("RPR: %.2f%n", rpr);
                System.out.println("-----------------------------------");

                // if-else chain to count different types of earners
                if(rpr < 0.75)
                {
                    needsRepair++;
                }
                else if(rpr >= 0.75 && rpr < 1.0)
                {
                    lowEarner++;
                }
                else if(rpr >= 1.0 && rpr < 1.5)
                {
                    steady++;
                }
                else if(rpr >= 1.5 && rpr < 2.5)
                {
                    popular++;
                }
                else if(rpr >= 2.5)
                {
                    superstar++;
                }
            }
        }
        catch (FileNotFoundException e)
        {
            System.out.println("error: file not found!");
        }

        double avgRPR = sumRPR/counter;

        // post-loop print statements
        System.out.println("Machines loaded: " + counter);
        System.out.printf("Average RPR: %.2f\n", avgRPR);
        System.out.printf("Top RPR: %s (%.2f)\n", maxRPRTitle, maxRPR);
        System.out.println("Needs Repair: " + needsRepair + " | Low Earner: " + lowEarner + " | Steady: " + steady + " | Popular: " + popular + " | Superstar: " + superstar);  
    }
}