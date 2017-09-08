package Thread.lock;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/** ReentrantReadWriteLock 学习心得
 * 读：共享锁，写：独占锁
 * 可以同时多条线程进行读操作，但是读的时候不允许写，只有一条线程可以进行写操作。写的时候也不允许进行读操作。
 * Created by jing_xu on 2017/9/7.
 */
public class ReentrantWirteReadLockDemo {
    private ReadWriteLock lock = new ReentrantReadWriteLock();
    private static int cache = 0;

    public void readCache() {
        try {
            lock.readLock().lock();
            System.out.printf("准备读取数据,获取读取锁。缓存数据内容为：%d\n", cache);
            // 模拟读取线程花费一定时间读取数据。
            Thread.sleep(1000);
            System.out.printf("数据读取完成。缓存数据内容为：%d\n", cache);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.readLock().unlock();
        }
    }

    public void writeCache() {
        try {
            lock.writeLock().lock();
            System.out.printf("准备写入数据,获取写入锁。缓存数据内容为：%d\n" , cache);
            // 模拟写入线程花费一定时间写入数据。
            Thread.sleep(1000);
            cache++;
            System.out.printf("写入完毕。缓存内容为：%d\n" , cache);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.writeLock().unlock();
        }
    }
}
