package com.example.demo;

import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

/**
 * <p>Title: </p>
 * <p>Description: ThreadLocal 测试</p>
 * @author cwh
 * @date 2020/12/17 16:20
 */
public class ThreadLocalTest {
    public static void main(String[] args) {
        ThreadLocal<String> local = new ThreadLocal<>();
        IntStream.range(0,5).forEach(a ->new Thread(()->{
            local.set(Thread.currentThread().getName());
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+"：的local值为："+local.get());
        }).start());
    }

}
