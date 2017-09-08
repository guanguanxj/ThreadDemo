package Thread.cyclicbarrier;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * Created by jing_xu on 2017/9/8.
 */
public class Horse implements Runnable{
    private int id;
    private CyclicBarrier cb;

    public Horse(int id, CyclicBarrier cb) {
        this.id = id;
        this.cb = cb;
    }
    @Override
    public void run() {
        try {
            System.out.printf("%d号出发\n",id);
            Thread.sleep((new Random()).nextInt(900)+1000);//模拟马儿跑的时长 范围：1000-1900ms
            System.out.printf("%d号到达终点\n",id);
            cb.await();
            System.out.printf("%d号准备进行下一场比赛\n",id);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
    }
}
