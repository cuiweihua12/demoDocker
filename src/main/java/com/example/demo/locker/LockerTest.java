package com.example.demo.locker;

import com.example.demo.threads.Locker;

/**
 * <p>Title: </p>
 * <p>Description: </p>
 *
 * @author cwh
 * @date 2020/12/10 13:28
 */
public class LockerTest {
    public static void main(String[] args) {
        System.out.println();
        synchronized (Locker.class){
            System.out.println("12");
        }
        System.out.println();
        LockerTest.test();
    }

    public static synchronized void   test(){
        System.out.println(1);
    }
}
