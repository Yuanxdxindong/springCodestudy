import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * @author yuanxindong
 * @date 2020/7/30 15:06
 */
public class CompletableFutureDemo implements Callable {
    @Override
    public Object call() throws Exception {
        return "result";
    }

    static final ExecutorService executorService = Executors.newCachedThreadPool();

    public static void main(String[] args) throws Exception {
        List<CompletableFuture<Long>> completableFutures = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            completableFutures.add(
                    CompletableFuture.supplyAsync(new Supplier<Long>() {
                        @Override
                        public Long get() {
                            long result = new Random().nextInt(100);
                            System.out.println("result1=" + result);
                            return result;
                        }
                    }, executorService).thenApply(new Function<Long, Long>() {
                        @Override
                        public Long apply(Long t) {
                            long result = t * 5;

                            System.out.println("result2=" + result);
                            return result;
                        }
                    })
            );
        }

        Map<String, String> stringStringMap = new HashMap<>();
        stringStringMap.put("1","2");
        Arrays.asList().stream().findFirst();
        CompletableFuture.allOf(completableFutures.toArray(new CompletableFuture[completableFutures.size()])).join();
    }

    // private static void thenApply() throws Exception {
    //
    //     long result = future.get();
    //     System.out.println(result);
    // }

    private static void thenApplyV2() throws Exception {
        CompletableFuture<Long> future = CompletableFuture.supplyAsync(new Supplier<Long>() {
            @Override
            public Long get() {
                try {
                    List<String> a = null;
                    String s = a.stream().findFirst().get();
                } catch (Exception e) {
                    System.out.println("异常了");
                }
                long result = new Random().nextInt(100);
                System.out.println("result1=" + result);
                return result;
            }
        }).thenApply(new Function<Long, Long>() {
            @Override
            public Long apply(Long t) {
                long result = t * 5;
                System.out.println("result2=" + result);
                return result;
            }
        });

        long result = future.get();
        System.out.println(result);
    }

    public static String getMessage() {

        return "message";
    }

    public static String getMessageV2() {

        return "messageV2";
    }
}
