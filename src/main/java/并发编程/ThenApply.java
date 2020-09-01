package 并发编程;

import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * @author yuanxindong
 * @date 2020/7/30  10:53 下午
 */
public class ThenApply {
  public static void main(String[] args) throws Exception {
      thenApply();
    //
  }
    private static void thenApply() throws Exception {
        CompletableFuture<Long> future = CompletableFuture.supplyAsync(new Supplier<Long>() {
            @Override
            public Long get() {
                long result = new Random().nextInt(100);
                System.out.println("result1="+result);
                return result;
            }
        }).thenApply(new Function<Long, Long>() {
            @Override
            public Long apply(Long t) {
                long result = t*5;
                System.out.println("result2="+result);
                return result;
            }
        });

        long result = future.get();
        System.out.println(result);
    }
}
