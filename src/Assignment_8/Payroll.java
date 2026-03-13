package Assignment_8;

import java.util.*;

public class Payroll
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        int count=1001;
        String Key;
        Map<String, Employee> employees = new HashMap<>();

        System.out.println("********    Enter 10 Employee details    ********");
        for(int i=0 ; i<10 ; i++)
        {
            boolean flag = true;
            Key = UUID.randomUUID().toString();
            int id = count++;

            while(flag)
            {
                if(employees.containsKey(Key))
                    Key = UUID.randomUUID().toString();
                else
                    flag = false;
            }

            System.out.println("\nEmployee - "+(i+1));

            System.out.println("Key: "+Key);

            System.out.println("Id: "+id);

            System.out.print("Name: ");
            String name = sc.next();

            String desig = "";
            System.out.println("Designation: ");
            System.out.println("1. Director  2. HR  3. Manager  4. Worker");
            System.out.print("Enter your choice: ");
            int ch = sc.nextInt();
            switch(ch)
            {
                case 1: desig = "Director";
                    break;
                case 2: desig = "HR";
                    break;
                case 3: desig = "Manager";
                    break;
                case 4: desig = "Worker";
                    break;
                default: System.out.println("Invalid Input!");
            }

            System.out.print("Overtime Hours: ");
            double hrs = sc.nextDouble();

            employees.put(Key, new Employee(name, desig, id, hrs));
        }

        System.out.println("\n\n********    Salary Details    ********");
        System.out.println("\nBase Pay:\n1. Director - 100000  \n2. HR - 80000  \n3. Manager - 65000  \n4. Worker - 50000");
        System.out.println("\nOvertime Pay:\n1. Director - 1000 per hr  \n2. HR - 750 per hr  \n3. Manager - 600 per hr  \n4. Worker - 450 per hr");

        System.out.println("\n\n********    Stored Employee Details    ********");
        for(Map.Entry<String, Employee> entry : employees.entrySet())
        {
            System.out.println("\nEmp-Key: "+entry.getKey());
            System.out.println("Emp-ID: "+entry.getValue().empId);
            System.out.println("Emp-Name: "+entry.getValue().name);
            System.out.println("Emp-Designation: "+entry.getValue().designation);
            System.out.println("Emp-Salary: "+entry.getValue().salary);
        }
    }
}

class Employee
{
    int empId;
    String name, designation;
    double salary=0, hrs=0;

    Employee(String name, String designation, int empId, double hrs)
    {
        this.name = name;
        this.designation = designation;
        this.empId = empId;
        this.hrs = hrs;

        empPayroll();
    }

    void empPayroll()
    {
        if(designation.equals("Director"))
        {
            double base = 100000;
            double overpay = 1000;
            salary = base + (overpay*hrs);
        }
        if(designation.equals("HR"))
        {
            double base = 80000;
            double overpay = 750;
            salary = base + (overpay*hrs);
        }
        if(designation.equals("Manager"))
        {
            double base = 65000;
            double overpay = 600;
            salary = base + (overpay*hrs);
        }
        if(designation.equals("Worker"))
        {
            double base = 50000;
            double overpay = 450;
            salary = base + (overpay*hrs);
        }
    }
}
