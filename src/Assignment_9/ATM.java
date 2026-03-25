package Assignment_9;

import java.util.Scanner;

class BankAccount
{
    private int balance = 1000;

    public synchronized void deposit(int amount)
    {
        System.out.println(Thread.currentThread().getName() + " trying to deposit...");
        balance += amount;
        System.out.println("Deposited: " + amount + " | New Balance: " + balance);
        notify();
    }

    public synchronized void withdraw(int amount)
    {
        System.out.println(Thread.currentThread().getName() + " trying to withdraw...");
        while (balance < amount)
        {
            System.out.println("Insufficient balance. Waiting for deposit...");
            try
            {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        balance -= amount;
        System.out.println("Withdrawn: " + amount + " | Remaining Balance: " + balance);
    }
}

class DepositThread extends Thread
{
    private BankAccount account;
    private int amount;

    public DepositThread(BankAccount account, int amount)
    {
        this.account = account;
        this.amount = amount;
    }

    public void run()
    {
        account.deposit(amount);
    }
}

class WithdrawThread extends Thread
{
    private BankAccount account;
    private int amount;

    public WithdrawThread(BankAccount account, int amount)
    {
        this.account = account;
        this.amount = amount;
    }

    public void run()
    {
        account.withdraw(amount);
    }
}

public class ATM
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        BankAccount account = new BankAccount();

        System.out.println("********    ATM System    ********");

        while (true)
        {
            System.out.println("\n1. Deposit\n2. Withdraw\n3. Exit");
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();

            if (choice == 3)
                break;

            System.out.print("Enter amount: ");
            int amount = sc.nextInt();

            if (choice == 1)
            {
                DepositThread dt = new DepositThread(account, amount);
                dt.setPriority(Thread.MAX_PRIORITY);
                dt.setName("Deposit-Thread");
                dt.start();

            }
            else if (choice == 2)
            {
                WithdrawThread wt = new WithdrawThread(account, amount);
                wt.setPriority(Thread.MIN_PRIORITY);
                wt.setName("Withdraw-Thread");
                wt.start();

            }
            else
            {
                System.out.println("Invalid choice!");
            }
        }

        sc.close();
        System.out.println("ATM session ended.");
    }
}
