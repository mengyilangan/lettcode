package limiting;

import java.util.concurrent.atomic.AtomicInteger;

//可以达到阻塞队列的效果
// private BlockingQueue<String> tokenQueue;

/**
 * @author mylg
 * @date 28/2/24
 */
public class TokenBucket {

    private AtomicInteger tokens = new AtomicInteger(0);

    private int speeds = 0;

    public static class Producer implements Runnable {
        private final AtomicInteger tokens;

        private final int times;

        private final int max;

        public Producer(AtomicInteger tokens, int times, int max) {
            this.tokens = tokens;
            this.times  = times;
            this.max    = max;
        }


        /**
         * 超了如何快速恢复
         */
        @Override
        public void run() {
            int i = 0;
            while (i < times) {
                while (this.tokens.get() > max) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                i++;
            }
        }
    }

    /**
     *
     */
    public static class Consumer implements Runnable {

        private final AtomicInteger tokens;

        public Consumer(AtomicInteger tokens) {
            this.tokens = tokens;
        }

        @Override
        public void run() {
            while (tokens.decrementAndGet() < 0) {
                tokens.incrementAndGet();
                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            //干活~~~~~
        }
    }


}
