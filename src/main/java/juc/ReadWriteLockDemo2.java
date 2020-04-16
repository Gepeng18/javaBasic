package juc;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantReadWriteLock;

// 可重入锁
class ReadWriteLock {
    //是否占用
    private boolean writeLocked = false;
    private int readCount = 0;

    //使用锁
    public synchronized void readLock() throws InterruptedException {
        //有人写我就不能读
        while (writeLocked) {
            wait();
        }
        readCount++;
    }

    //释放锁
    public synchronized void readUnlock() {
        readCount--;
        notifyAll();
    }

    //使用锁
    public synchronized void writeLock() throws InterruptedException {
        //有人写 或者 有人读 我都不能读
        while (writeLocked||readCount>0) {
            wait();
        }
        writeLocked = true;
    }

    //释放锁
    public synchronized void writeUnlock() {
        writeLocked = false;
        notifyAll();
    }
}
class MyCache2
{
    private volatile Map<String,Object> map = new HashMap<>();
    private ReadWriteLock readWriteLock = new ReadWriteLock();

    public void put(String key,Object value) throws InterruptedException {
        readWriteLock.writeLock();
        try
        {
            System.out.println(Thread.currentThread().getName()+"\t ---写入数据"+key);
            //暂停一会儿线程毫秒
            try { TimeUnit.MILLISECONDS.sleep( 300 ); } catch (InterruptedException e) { e.printStackTrace(); }
            map.put(key,value);
            System.out.println(Thread.currentThread().getName()+"\t ---写入完成");
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            readWriteLock.writeUnlock();
        }
    }
    public void get(String key) throws InterruptedException {
        readWriteLock.readLock();
        try
        {
            System.out.println(Thread.currentThread().getName()+"\t 读取数据");
            try { TimeUnit.MILLISECONDS.sleep( 300 ); } catch (InterruptedException e) { e.printStackTrace(); }
            Object result = map.get(key);
            System.out.println(Thread.currentThread().getName()+"\t 读取完成"+result);
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            readWriteLock.readUnlock();
        }
    }
}

public class ReadWriteLockDemo2 {
    public static void main(String[] args)
    {
        MyCache2 myCache2 = new MyCache2();

        for (int i = 1; i <=5; i++)
        {
            final int tempInt = i;
            new Thread(() -> {
                try {
                    myCache2.put(tempInt+"",tempInt+"");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            },String.valueOf(i)).start();
        }


        for (int i = 1; i <=5; i++)
        {
            final int tempInt = i;
            new Thread(() -> {
                try {
                    myCache2.get(tempInt+"");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            },String.valueOf(i)).start();
        }

    }
}
