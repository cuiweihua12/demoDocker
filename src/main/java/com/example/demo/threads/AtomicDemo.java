package com.example.demo.threads;

import java.util.ArrayList;

/**
 * @author ：mmzsblog
 * @description：并发中的原子性问题
 * @date ：2020/2/25 14:05
 */
public class AtomicDemo {

    public static final int THREAD_COUNT = 100;
    static BankAccount depositAccount = new BankAccount();

    public static void main(String[] args) throws Exception {

        ArrayList<Thread> threads = new ArrayList<>();
        for (int i = 0; i < THREAD_COUNT; i++) {
            Thread thread = new DepositThread();
            thread.start();
            threads.add(thread);
        }

        for (Thread thread : threads) {
            thread.join();
        }

        System.out.println("Now the balance is " + depositAccount.getBalance() + "元");
    }

    static class DepositThread extends Thread {
        @Override
        public void run() {
            for (int j = 0; j < 1000; j++) {
                depositAccount.deposit(1);   // 每次存款1元
            }
        }
    }
}
