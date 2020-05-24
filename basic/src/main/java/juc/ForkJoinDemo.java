package juc;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;


class MyTask extends RecursiveTask<Integer>
{
    private static final Integer ADJUST_VALUE = 10;
    private int start;
    private int end;
    private int result;

    public MyTask(int start, int end)
    {
        this.start = start;
        this.end = end;
    }

    @Override
    protected Integer compute()
    {
        if ((end - start) <= ADJUST_VALUE) {
            for (int i = start; i <= end; i++) {
                result = result + i;
            }
        } else {
            int middle = (start + end) / 2;
            MyTask task1 = new MyTask(start, middle);
            MyTask task2 = new MyTask(middle + 1, end);
            task1.fork();
            task2.fork();
            result = task1.join() + task2.join();
        }
        return result;
    }
}


/**
 * <p>
 * 分支合并框架
 * <p>
 * ForkJoinPool
 * ForkJoinTask
 * RecursiveTask
 * <p>
 * 如何拆解成小任务需要在任务执行的过程中动态拆分。
 * 这样，大任务可以拆成小任务，小任务还可以继续拆成更小的任务，
 * 最后把任务的结果汇总合并，得到最终结果，这种模型就是Fork/Join模型。
 */
public class ForkJoinDemo
{
    public static void main(String[] args) throws Exception
    {
        MyTask myTask = new MyTask(0, 10);
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        ForkJoinTask<Integer> forkJoinTask = forkJoinPool.submit(myTask);

        System.out.println(forkJoinTask.get());

        forkJoinPool.shutdown();


    }
}

