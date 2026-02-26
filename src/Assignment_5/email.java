package Assignment_5;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class email
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("************    WELCOME TO VERIFIER    ************");
        System.out.println("1. Email");
        System.out.println("2. Date");
        System.out.print("Enter your choice (1-2): ");
        int ch = sc.nextInt();
        switch(ch)
        {
            case 1: email();
                break;
            case 2: date();
                break;
            default: System.out.println("\nInvalid Input!");
        }
    }

    static void email()
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("\nEnter Email-ID: ");
        String email = sc.nextLine();

        Pattern pattern = Pattern.compile("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(email);

        if(matcher.matches())
            System.out.println("\n"+email+" is a Valid Email-ID!");
        else
            System.out.println("\n"+email+" is not a Valid Email-ID!");
    }

    static void date()
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("\nEnter Date (dd/mm/yyyy): ");
        String date = sc.nextLine();

        Pattern pattern = Pattern.compile("^(?:(?:(?:0[1-9]|[12][0-9]|3[01])/(?:0[13578]|1[02])|(?:0[1-9]|[12][0-9]|30)/(?:0[469]|11)|(?:0[1-9]|1[0-9]|2[0-8])/02)/(?:19|20)\\d{2}|29/02/(?:19(?:0[48]|[2468][048]|[13579][26])|20(?:0[48]|[2468][048]|[13579][26])|2000))$");
        Matcher matcher = pattern.matcher(date);

        if(matcher.matches())
            System.out.println("\n"+date+" is a Valid Date!");
        else
            System.out.println("\n"+date+" is not a Valid Date!");
    }
}
