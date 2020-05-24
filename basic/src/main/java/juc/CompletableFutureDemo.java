package juc;

import java.util.concurrent.CompletableFuture;


public class CompletableFutureDemo
{
    public static void main(String[] args) throws Exception
    {
        /*CompletableFuture<Void> completableFuture = CompletableFuture.runAsync(() -> {
            System.out.println(Thread.currentThread().getName() + "没有返回，update mysql ok");
        });
        completableFuture.get();*/

        //异步回调
        CompletableFuture<Integer> completableFuture2 = CompletableFuture.supplyAsync(()->{
            System.out.println(Thread.currentThread().getName()+"\t completableFuture2");
            //int age = 10/0;
            return 1024;
        });

        completableFuture2.whenComplete((t, u) -> {
            System.out.println("****t: " + t);
            System.out.println("****u: " + u);
        }).exceptionally(f -> {
            System.out.println("***excption:" + f.getMessage());
            return 4444;
        }).get();

        /*completableFuture2.whenComplete((t,u)->{
            System.out.println("-------t="+t);
            System.out.println("-------u="+u);
        }).exceptionally(f->{
            System.out.println("-----exception:"+f.getMessage());
            return 444;
        }).get();*/


    }
}
