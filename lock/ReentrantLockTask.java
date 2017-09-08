package Thread.lock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by jing_xu on 2017/9/7.
 */
public class ReentrantLockTask {
    ReentrantLock lock = new ReentrantLock();
    public   Runnable createTask(){
        return new Runnable() {
            @Override
            public void run() {
                while (true) {
                    try {
                        lock.lockInterruptibly();
                        System.out.println("locked " + Thread.currentThread().getName());
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        System.out.println(Thread.currentThread().getName() + " is interrupted");
                    } finally {
                        lock.unlock();
                        System.out.println("unlocked " + Thread.currentThread().getName());
                    }
                    break;
                }
            }
        };
    }
}
