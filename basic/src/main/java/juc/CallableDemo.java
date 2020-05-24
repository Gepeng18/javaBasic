package juc;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;


class MyThread implements Callable<Integer>
{
    @Override
    public Integer call() throws Exception
    {
        System.out.println("*******come in Callable");
        //暂停一会儿线程
        try { TimeUnit.SECONDS.sleep( 4 ); } catch (InterruptedException e) { e.printStackTrace(); }
        System.out.println("子线程执行完毕");
        return 1024;
    }
}


/**
 * java
 * 多线程中，第3种获得多线程的方式
 *
 * 1    get方法一般请放在最后一行
 */
public class CallableDemo
{
    public static void main(String[] args) throws InterruptedException, ExecutionException
    {
        FutureTask futureTask = new FutureTask(new MyThread());
        //只会调用一次，因为任务已经执行完成
        System.out.println("这是主函数");
        new Thread(futureTask,"A").start();
        new Thread(futureTask,"B").start();
        Thread.sleep(10000);
        System.out.println(Thread.currentThread().getName()+"*****计算完成");

        System.out.println(futureTask.get());
    }
}
