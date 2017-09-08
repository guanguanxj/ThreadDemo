package Thread.cyclicbarrier;

/**
 * Created by jing_xu on 2017/9/8.
 */
public class Competion implements Runnable{
    private int count = 1;
    @Override
    public void run() {
        count++;
        System.out.printf("所有马匹到达终点。准备开始第%d场比赛\n", count);
    }
}
