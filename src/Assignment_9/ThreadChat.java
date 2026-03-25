package Assignment_9;

import java.util.*;

class ChatDemo
{
    boolean flag = true;

    public synchronized void chatThread_1 (String message)
    {
        while(!flag)
        {
            try
            {
                wait();
            } catch(Exception e) {
                System.out.println("User-1 Error - "+e);
            }
        }

        try{ Thread.sleep(500); } catch(Exception e) {}

        System.out.println("User-1: "+message);
        flag = false;
        notify();
    }

    public synchronized void chatThread_2 (String message)
    {
        while(flag)
        {
            try
            {
                wait();
            } catch(Exception e) {
                System.out.println("User-2 Error - "+e);
            }
        }

        try{ Thread.sleep(500); } catch(Exception e) {}

        System.out.println("User-2: "+message);
        flag = true;
        notify();
    }
}

class UserThread1 extends Thread
{
    ChatDemo cd;

    UserThread1(ChatDemo cd)
    {
        this.cd = cd;
    }

    String[] text = {"TA-1", "TA-2", "TA-3", "TA-4", "TA-5"};

    public void run()
    {
        for(String t: text)
        {
            cd.chatThread_1(t);
        }
    }
}

class UserThread2 extends Thread
{
    ChatDemo cd;

    UserThread2(ChatDemo cd)
    {
        this.cd = cd;
    }

    String[] text = {"TB-1", "TB-2", "TB-3", "TB-4", "TB-5"};

    public void run()
    {
        for(String t: text)
        {
            cd.chatThread_2(t);
        }
    }
}

public class ThreadChat
{
    public static void main(String[] args)
    {
        ChatDemo cd = new ChatDemo();

        UserThread1 u1 = new UserThread1(cd);
        UserThread2 u2 = new UserThread2(cd);

        u1.start();
        u2.start();
    }
}
