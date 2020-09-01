package 并发编程;

import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;
import java.util.function.BiConsumer;
import java.util.function.Function;

/**
 * @author yuanxindong
 * @date 2020/7/30 10:22 下午
 */
public class WhenCompleteDemo {
  public static void main(String[] args) throws InterruptedException {
    // 启动异步编程的一个线程任务
    CompletableFuture<Void> future =
        CompletableFuture.runAsync(
            () -> {
              try {
                TimeUnit.SECONDS.sleep(1);
              } catch (InterruptedException e) {
              }

              if (new Random().nextInt() % 2 >= 0) {
                int i = 12 / 0;
              }
              System.out.println("run end ...");
            });

    // 接受正常任务结果
    future.whenComplete(
        new BiConsumer<Void, Throwable>() {
          @Override
          public void accept(Void t, Throwable action) {
            System.out.println("执行完成！");
          }
        });

    // 接受异常任务结果
    future.exceptionally(
        new Function<Throwable, Void>() {
          @Override
          public Void apply(Throwable t) {
            System.out.println("执行失败！" + t.getMessage());
            return null;
          }
        });

    TimeUnit.SECONDS.sleep(2);
  }

  private static void print(String message) {
    System.out.println(message);
  }
}
