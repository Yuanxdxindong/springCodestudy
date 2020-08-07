import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @author yuanxindong
 * @date: 2020/7/29 13:18
 */
public class demoDad implements Callable {
 static final    ExecutorService executorService = Executors.newCachedThreadPool();

   public String getName(){
        return  "dad";
    }

    @Override
    public Object call() throws Exception {
       return "value";
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        demoDad thread =  new demoDad();
        Future submit = executorService.submit(thread);
        Object o = submit.get();
        System.out.println(o.toString());
    }
}