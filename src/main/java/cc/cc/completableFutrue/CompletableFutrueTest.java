package cc.cc.completableFutrue;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

/**
 * @author zhangchaochao
 * @version 1.0
 * @date 2021-09-24 13:19
 */

public class CompletableFutrueTest {

    public static void main(String[] args) {
        CompletableFutrueTest.test1();
    }

    public static void test1() {

        List<CompletableFuture> list = new ArrayList<>();

        for(int i=0; i<10; i++) {
            final int index = i;
            CompletableFuture ccff = CompletableFuture.supplyAsync(() -> {
                return index * 10;
            }).thenAcceptAsync(ii -> {
                final int result = ii + 1;
                System.out.println("result"+ii+" --> " + result);
            }).exceptionally((throwable) -> {
                System.out.println("throwable error !");
                return null;
            });
            list.add(ccff);
        }
        CompletableFuture[] arr = new CompletableFuture[list.size()];
        list.toArray(arr);
        try {
            CompletableFuture.allOf(arr).get();
        } catch (Exception e) {
            e.printStackTrace();
        }

        int index = 0;
        for(int i=0; i<50; i++) {
            index += i;
        }
        System.out.println("index result -> " + index);

        int index2 = 0;
        for(int i=0; i<5000; i++) {
            index2 += i;
        }
        System.out.println("index2 result -> " + index2);

        sleep(5000L);
    }

    public static void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
