package Thread.cyclicbarrier;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/** CyclicBarrier 学习心得
 *
 * CyclicBarrier内部通过ReentrantLock独占锁实现，任意线程调用await(),会通过cb的独占锁
 * 对操作进行通过同步，注意是“同步”，也就是当前只能一个线程占有await内的操作。
 * 在方法调用的过程中，如果不满足条件 if(index==0)是false,则trip.await();阻塞当前线程
 * 如果满足条件 即index==0，或者时间到了，唤醒所有在该锁上等待的线程 trip.signalAll();
 * 并且重置障碍锁的状态，用以实现循环使用。
 *
 * Created by jing_xu on 2017/9/8.
 */
public class CyclicBarrierDemo {
    public static void main(String[] args) throws InterruptedException {
        Competion competion = new Competion();
        ExecutorService executorService = Executors.newCachedThreadPool();
        CyclicBarrier cyclicBarrier = new CyclicBarrier(5,competion);
        int j=0;
        while (j<2) {
            for (int i = 0; i < 5; i++) {
                executorService.execute(new Horse(i, cyclicBarrier));
            }
            Thread.sleep(2000);
            System.out.println("稍作休息，准备进入下一场比赛");
            Thread.sleep(2000);
            j++;
        }
        executorService.shutdown();
    }
}
