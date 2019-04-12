package com.tony.thread.sync.mo;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class PrintQueue {
    private Lock queueLock;

    public PrintQueue(boolean fairMode) {
        this.queueLock = new ReentrantLock(fairMode);
    }

    public void printJob() {
        queueLock.lock();
        try {
            Long duration = (long) (Math.random() * 1000);
            System.out.println(Thread.currentThread().getName() + ":PrintQueue: Printing a Job during " + (duration / 1000.0f) + " seconds");
            Thread.sleep(duration);
        } catch (InterruptedException e) {
            e.printStackTrace(System.out);
        } finally {
            queueLock.unlock();
        }
    }
}
