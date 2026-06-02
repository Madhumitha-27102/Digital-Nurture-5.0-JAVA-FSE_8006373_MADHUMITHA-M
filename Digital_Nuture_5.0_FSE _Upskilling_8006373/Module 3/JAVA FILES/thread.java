package Practice;

class MyThread1 implements Runnable
{
    public void run()
    {
        for(int i = 1; i <= 5; i++)
        {
            System.out.println("Thread 1 is running: " + i);
        }
    }
}

class MyThread2 implements Runnable
{
    public void run()
    {
        for(int i = 1; i <= 5; i++)
        {
            System.out.println("Thread 2 is running: " + i);
        }
    }
}

public class thread
{
    public static void main(String[] args)
    {
        Thread t1 = new Thread(new MyThread1());
        Thread t2 = new Thread(new MyThread2());

        t1.start();
        t2.start();
    }
}
