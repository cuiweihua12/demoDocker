package com.example.demo.threads;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public enum Locker {
    INSTANCE;
    private static final ReadWriteLock READ_WRITE_LOCK = new ReentrantReadWriteLock();
    public Lock writeLock(){
        return READ_WRITE_LOCK.writeLock();
    }
}
