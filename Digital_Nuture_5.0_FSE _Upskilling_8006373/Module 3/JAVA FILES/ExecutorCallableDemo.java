import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ExecutorCallableDemo {

    static class MyTask implements Callable<Integer> {

        private int num;

        public MyTask(int num) {
            this.num = num;
        }

        @Override
        public Integer call() {
            int sum = 0;
            for (int i = 1; i <= num; i++) {
                sum += i;
            }
            System.out.println("Task completed for n = " + num);
            return sum;
        }
    }

    public static void main(String[] args) {

        ExecutorService executor = Executors.newFixedThreadPool(3);

        Future<Integer> f1 = executor.submit(new MyTask(10));
        Future<Integer> f2 = executor.submit(new MyTask(20));
        Future<Integer> f3 = executor.submit(new MyTask(30));

        try {
       
            System.out.println("Result 1 = " + f1.get());
            System.out.println("Result 2 = " + f2.get());
            System.out.println("Result 3 = " + f3.get());

        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

        executor.shutdown();
    }
}