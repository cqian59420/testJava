package threadutil;

import java.util.concurrent.CountDownLatch;

// 利用它可以实现类似计数器的功能。比如有一个任务A，它要等待其他4个任务执行完毕之后才能执行，此时就可以利用CountDownLatch来实现这种功能了。
public class CountDownLatchTest {

    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(2);


        new Thread(() -> {
            System.out.println("thread 1 start running");
            try {
                Thread.sleep(3000);
                System.out.println("thread 1 finish");
                countDownLatch.countDown();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(() -> {
            System.out.println("thread 2 start running");
            try {
                Thread.sleep(3000);
                System.out.println("thread 2 finish");
                countDownLatch.countDown();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();


        System.out.println(" main Thread Running");
        countDownLatch.await();
        System.out.println("main thread finish");
    }

}
/*

        main Thread Running
        thread 1 start running
        thread 2 start running
        thread 2 finish
        thread 1 finish
        main thread finish
*/
