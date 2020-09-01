package 并发编程;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * @author yuanxindong
 * @date 2020/7/30 9:07 下午
 */
public class CompletableFutureDemo {
  public static void main(String[] args) throws ExecutionException, InterruptedException {
    //
    System.out.println(runAsyncDemo().get());
    System.out.println(supplyAsyncDemo().get());
  }

  static CompletableFuture<Void> runAsyncDemo() {
    CompletableFuture<Void> voidCompletableFuture = CompletableFuture.runAsync(CompletableFutureDemo::getMessage);
    return voidCompletableFuture;
  }

  static CompletableFuture<String> supplyAsyncDemo() {
    CompletableFuture<String> stringCompletableFuture1 =
        CompletableFuture.supplyAsync(CompletableFutureDemo::getMessage);
    return stringCompletableFuture1;
  }


 static  String getMessage() {
    return "return message";
  }


}
