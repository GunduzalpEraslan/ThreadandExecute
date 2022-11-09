import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {


        Counter counter = new Counter();
        ExecutorService pool = Executors.newFixedThreadPool(4);
        for (int i =0; i < 10000 ; i++) {
            pool.execute(counter);
        }
    }
}