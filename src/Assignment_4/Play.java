package Assignment_4;

import java.util.*;

interface Player
{
    public void setName(String name);
    public void getName();
    public void setStatistics(Statistics stat);
    public void getStatistic();
}

interface Game
{
    public void playGame();
}

class Statistics
{
    int matches, goals, regWin, natWin, intWin;
    Statistics(int matches, int goals, int regWin, int natWin, int intWin)
    {
        this.matches = matches;
        this.goals = goals;
        this.regWin = regWin;
        this.natWin = natWin;
        this.intWin = intWin;
    }
}

class football implements Player, Game
{
    String name;
    int matches, goals, regWin, natWin, intWin;

    football(String name, Statistics stats)
    {
        setName(name);
        setStatistics(stats);
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public void setStatistics(Statistics stat)
    {
        this.matches = stat.matches;
        this.goals = stat.goals;
        this.regWin = stat.regWin;
        this.natWin = stat.natWin;
        this.intWin = stat.intWin;
    }

    public void getName()
    {
        System.out.println("\nPlayer: "+name);
    }

    public void getStatistic()
    {
        System.out.println("Total matches played: "+matches);
        System.out.println("Total Goals Scored: "+goals);
        double avg = goals/matches;
        System.out.println("Average Goals: "+avg);
        System.out.println("Number of Regional Wins: "+regWin);
        System.out.println("Number of National Wins: "+natWin);
        System.out.println("Number of International Wins: "+intWin);
    }

    public void playGame()
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("\nType of Match Played?\n1. Regional\n2. National\n3. International\n\nEnter your choice: ");
        int ch = sc.nextInt();
        System.out.print("Goals scored in this match: ");
        int b = sc.nextInt();
        System.out.println("Was this a win?\n0. No\n1. Yes");
        int win = sc.nextInt();
        if(win != 0 && win != 1)
        {
            System.out.println("Invalid Input!");
            return;
        }

        switch(ch)
        {
            case 1:{
                matches++;
                if(win==1)
                    regWin++;
                goals+=b;
            }
            break;
            case 2:{
                matches++;
                if(win==1)
                    natWin++;
                goals+=b;
            }
            break;
            case 3:{
                matches++;
                if(win==1)
                    intWin++;
                goals+=b;
            }
            break;
            default: System.out.println("Invalid Input!");
        }
        getName();
        getStatistic();
    }
}

class cricket implements Player, Game
{
    String name;
    int matches, wickets, regWin, natWin, intWin;

    cricket(String name, Statistics stats)
    {
        setName(name);
        setStatistics(stats);
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public void setStatistics(Statistics stat)
    {
        this.matches = stat.matches;
        this.wickets = stat.goals;
        this.regWin = stat.regWin;
        this.natWin = stat.natWin;
        this.intWin = stat.intWin;
    }

    public void getName()
    {
        System.out.println("\nPlayer: "+name);
    }

    public void getStatistic()
    {
        System.out.println("Total matches played: "+matches);
        System.out.println("Total Wickets Taken: "+wickets);
        double avg = wickets/matches;
        System.out.println("Average Wickets: "+avg);
        System.out.println("Number of Regional Wins: "+regWin);
        System.out.println("Number of National Wins: "+natWin);
        System.out.println("Number of International Wins: "+intWin);
    }

    public void playGame()
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("\nType of Match Played?\n1. Regional\n2. National\n3. International\n\nEnter your choice: ");
        int ch = sc.nextInt();
        System.out.print("Wickets taken in this match: ");
        int b = sc.nextInt();
        System.out.println("Was this a win?\n0. No\n1. Yes");
        int win = sc.nextInt();
        if(win != 0 && win != 1)
        {
            System.out.println("Invalid Input!");
            return;
        }

        switch(ch)
        {
            case 1:{
                matches++;
                if(win==1)
                    regWin++;
                wickets+=b;
            }
            break;
            case 2:{
                matches++;
                if(win==1)
                    natWin++;
                wickets+=b;
            }
            break;
            case 3:{
                matches++;
                if(win==1)
                    intWin++;
                wickets+=b;
            }
            break;
            default: System.out.println("Invalid Input!");
        }
        getName();
        getStatistic();
    }
}

class basketball implements Player, Game
{
    String name;
    int matches, baskets, regWin, natWin, intWin;

    basketball(String name, Statistics stats)
    {
        setName(name);
        setStatistics(stats);
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public void setStatistics(Statistics stat)
    {
        this.matches = stat.matches;
        this.baskets = stat.goals;
        this.regWin = stat.regWin;
        this.natWin = stat.natWin;
        this.intWin = stat.intWin;
    }

    public void getName()
    {
        System.out.println("\nPlayer: "+name);
    }

    public void getStatistic()
    {
        System.out.println("Total matches played: "+matches);
        System.out.println("Total Baskets Scored: "+baskets);
        double avg = baskets/matches;
        System.out.println("Average Baskets: "+avg);
        System.out.println("Number of Regional Wins: "+regWin);
        System.out.println("Number of National Wins: "+natWin);
        System.out.println("Number of International Wins: "+intWin);
    }

    public void playGame()
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("\nType of Match Played?\n1. Regional\n2. National\n3. International\n\nEnter your choice: ");
        int ch = sc.nextInt();
        System.out.print("Baskets scored in this match: ");
        int b = sc.nextInt();
        System.out.println("Was this a win?\n0. No\n1. Yes");
        int win = sc.nextInt();
        if(win != 0 && win != 1)
        {
            System.out.println("Invalid Input!");
            return;
        }

        switch(ch)
        {
            case 1:{
                matches++;
                if(win==1)
                    regWin++;
                baskets+=b;
            }
            break;
            case 2:{
                matches++;
                if(win==1)
                    natWin++;
                baskets+=b;
            }
            break;
            case 3:{
                matches++;
                if(win==1)
                    intWin++;
                baskets+=b;
            }
            break;
            default: System.out.println("Invalid Input!");
        }
        getName();
        getStatistic();
    }
}

public class Play
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Player Name: ");
        String name = sc.nextLine();

        System.out.println("\n********    IIIT KALYANI SPORTS ARENA    ********");
        System.out.println("1. Football");
        System.out.println("2. Cricket");
        System.out.println("3. Basketball");
        System.out.print("Enter the sport you want add data for (1-3): ");
        int ch = sc.nextInt();

        switch(ch)
        {
            case 1:{
                System.out.print("\nEnter total number of matches played: ");
                int matches = sc.nextInt();
                System.out.print("Enter total number of Goals: ");
                int goals = sc.nextInt();
                System.out.print("Enter total wins in Regional Level: ");
                int regWin = sc.nextInt();
                System.out.print("Enter total wins in National Level: ");
                int natWin = sc.nextInt();
                System.out.print("Enter total wins in International Level: ");
                int intWin = sc.nextInt();

                if(regWin+natWin+intWin > matches)
                {
                    System.out.println("Total wins cannot be more than matches played!!!!");
                    break;
                }

                football player1 = new football(name, new Statistics(matches, goals, regWin, natWin, intWin));
                player1.getName();
                player1.getStatistic();

                System.out.println("\nPlayed Another game? (1-Yes)");
                int g = sc.nextInt();
                if(g==1)
                    player1.playGame();
            }
            break;
            case 2: {
                System.out.print("\nEnter total number of matches played: ");
                int matches = sc.nextInt();
                System.out.print("Enter total number of Wickets: ");
                int wickets = sc.nextInt();
                System.out.print("Enter total wins in Regional Level: ");
                int regWin = sc.nextInt();
                System.out.print("Enter total wins in National Level: ");
                int natWin = sc.nextInt();
                System.out.print("Enter total wins in International Level: ");
                int intWin = sc.nextInt();

                if(regWin+natWin+intWin > matches)
                {
                    System.out.println("Total wins cannot be more than matches played!!!!");
                    break;
                }

                cricket player2 = new cricket(name, new Statistics(matches, wickets, regWin, natWin, intWin));
                player2.getName();
                player2.getStatistic();

                System.out.println("\nPlayed Another game? (1-Yes)");
                int g = sc.nextInt();
                if(g==1)
                    player2.playGame();
            }
            break;
            case 3: {
                System.out.print("\nEnter total number of matches played: ");
                int matches = sc.nextInt();
                System.out.print("Enter total number of Baskets: ");
                int baskets = sc.nextInt();
                System.out.print("Enter total wins in Regional Level: ");
                int regWin = sc.nextInt();
                System.out.print("Enter total wins in National Level: ");
                int natWin = sc.nextInt();
                System.out.print("Enter total wins in International Level: ");
                int intWin = sc.nextInt();

                if(regWin+natWin+intWin > matches)
                {
                    System.out.println("Total wins cannot be more than matches played!!!!");
                    break;
                }

                basketball player3 = new basketball(name, new Statistics(matches, baskets, regWin, natWin, intWin));
                player3.getName();
                player3.getStatistic();

                System.out.println("\nPlayed Another game? (1-Yes)");
                int g = sc.nextInt();
                if(g==1)
                    player3.playGame();
            }
            break;
            default: System.out.println("Invalid Choice!");
        }
    }
}