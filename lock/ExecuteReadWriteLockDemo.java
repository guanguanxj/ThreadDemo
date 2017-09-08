package Thread.lock;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by jing_xu on 2017/9/7.
 */
public class ExecuteReadWriteLockDemo {
    public static void main(String[] args){
        ExecutorService es = Executors.newCachedThreadPool();
        final ReentrantWirteReadLockDemo wrLock = new ReentrantWirteReadLockDemo();
        final ReentrantWirteReadLockDemo rlock = new ReentrantWirteReadLockDemo();
        int i=0,j=0;
        while (i<3) {
            es.execute(new Runnable() {
                @Override
                public void run() {
                    rlock.readCache();
                }
            });
            i++;
        }
        while (j<3) {
            es.execute(new Runnable() {
                @Override
                public void run() {
                    wrLock.writeCache();
                }
            });
            j++;
        }
        es.shutdown();
    }
}
