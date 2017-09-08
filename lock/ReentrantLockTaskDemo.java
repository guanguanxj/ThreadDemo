package Thread.lock;

/**
 * Created by jing_xu on 2017/9/7.
 */
public class ReentrantLockTaskDemo {
    public static void main(String[] args) throws InterruptedException {
        ReentrantLockTask task = new ReentrantLockTask();
        Thread first = new Thread(task.createTask(),"firstThread");
        Thread second = new Thread(task.createTask(),"secondThread");
        first.start();
        second.start();
        Thread.sleep(600);
        second.interrupt();
    }
}
