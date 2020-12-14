package com.example.demo.threads;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;

public class Wanger {
	public static  int count = 0;
	
	public static int getCount() {
		return count;
	}
	
	public static  void addCount() {
		Lock lock = Locker.INSTANCE.writeLock();
		lock.lock();
		try {
			count++;
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			lock.unlock();
		}
	}
	
	public static void main(String[] args) {
		ExecutorService executorService = new ThreadPoolExecutor(10, 1000,
		        60L, TimeUnit.SECONDS,
		        new ArrayBlockingQueue<Runnable>(10));


		for (int i = 0; i < 1000; i++) {
			Runnable r = new Runnable() {

				@Override
				public void run() {
					Wanger.addCount();
				}
			};
			executorService.execute(r);
		}
		executorService.shutdown();
		System.out.println(Wanger.count);
	}
}