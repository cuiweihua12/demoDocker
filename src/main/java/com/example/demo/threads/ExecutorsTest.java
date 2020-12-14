package com.example.demo.threads;

import java.util.concurrent.*;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 *
 * @author cwh
 * @date 2020/12/10 10:31
 */
public class ExecutorsTest {
    public static void main(String[] args) {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(2, 2, 1, TimeUnit.SECONDS, new LinkedBlockingQueue<>(10));
        Thread thread =null;
        for (int i = 0; i < 10; i++) {
            int finalI = i;
            thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println(finalI);
                }
            });
            executor.execute(thread);
        }
    }
}

