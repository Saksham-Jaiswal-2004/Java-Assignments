package Assignment_3;
import java.util.*;

public class company
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        System.out.println("********    WELCOME TO ADMIN DASHBOARD    ********");
        System.out.println("Add Employee: ");
        System.out.println("1. Manager ");
        System.out.println("2. Officer ");
        System.out.println("3. Clerk ");
        System.out.print("Enter your choice (1-3): ");
        int ch = sc.nextInt();

        switch(ch)
        {
            case 1: manager emp1 = new manager();
            break;
            case 2: officer emp2 = new officer();
            break;
            case 3: clerk emp3 = new clerk();
            break;
            default: System.out.println("Invalid Choice!");
        }
    }
}

class Employee
{
    long Id;
    String name;
    double Basic, DailyRate, Days, OverTime, DA, HRA;
    int Role;

    Employee(String Name, double DailyRate, int Days, double OverTime, int Role)
    {
        Id = (int)(Math.random()*((99999 - 10000) + 1)) + 10000;
        this.name = Name;
        this.DailyRate = DailyRate;
        this.Days = Days;
        this.OverTime = OverTime;
        this.Role = Role;
    }

    Employee(String Name, double Basic, int Role)
    {
        Id = (int)(Math.random()*((99999 - 10000) + 1)) + 10000;
        this.name = Name;
        this.Role = Role;
        this.Basic = Basic;
    }

    double salary()
    {
        double sal=0.0;

        if(Role==3)
        {
            sal = (DailyRate*Days) + OverTime;
        }
        else if(Role==1)
        {
            DA = 0.05*Basic;
            HRA = 0.04*Basic;
            sal = Basic + DA + HRA;
        }
        else if(Role==2)
        {
            DA = 0.02*Basic;
            HRA = 0.02*Basic;
            sal = Basic + DA + HRA;
        }

        return sal;
    }

    void displayEmp()
    {
        if(Role==1)
        {
            System.out.println("\nEmployee ID: "+Id);
            System.out.println("Employee Name: "+name);
            System.out.println("Employee Role: Manager");
            System.out.println("Employee Basic Pay: "+Basic);
            System.out.println("Employee DA: "+DA);
            System.out.println("Employee HRA: "+HRA);
            System.out.println("Employee Total Salary: "+salary());
        }
        if(Role==2)
        {
            System.out.println("\nEmployee ID: "+Id);
            System.out.println("Employee Name: "+name);
            System.out.println("Employee Role: Officer");
            System.out.println("Employee Basic Pay: "+Basic);
            System.out.println("Employee DA: "+DA);
            System.out.println("Employee HRA: "+HRA);
            System.out.println("Employee Total Salary: "+salary());
        }
        if(Role==3)
        {
            System.out.println("\nEmployee ID: "+Id);
            System.out.println("Employee Name: "+name);
            System.out.println("Employee Role: Clerk");
            System.out.println("Employee Daily Rate: "+DailyRate);
            System.out.println("Employee No. of Days Worked: "+Days);
            System.out.println("Employee Over Time: "+OverTime);
            System.out.println("Employee Total Salary: "+salary());
        }
    }
}

class manager extends Employee
{
    manager()
    {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter Manager Details:");
        System.out.print("Name: ");
        String name = sc.nextLine();
        System.out.print("Basic Pay: ");
        double basic = sc.nextDouble();

        super(name, basic, 1);
        super.displayEmp();
    }
}

class officer extends Employee
{
    officer()
    {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter Officer Details:");
        System.out.print("Name: ");
        String name = sc.nextLine();
        System.out.print("Basic Pay: ");
        double basic = sc.nextDouble();

        super(name, basic, 2);
        super.displayEmp();
    }
}

class clerk extends Employee
{

    clerk()
    {
        Scanner sc = new Scanner(System.in);


        System.out.println("Enter Clerk Details: ");
        System.out.print("Name: ");
        String name = sc.nextLine();
        System.out.print("Daily Rate: ");
        double dailyRate = sc.nextDouble();
        System.out.print("Days Worked:");
        int days = sc.nextInt();
        System.out.print("Overtime Pay: ");
        double overTime = sc.nextDouble();

        super(name, dailyRate, days, overTime, 3);
        super.displayEmp();
    }
}