package com.tony.thread.sync.runnable;

import com.tony.thread.sync.mo.Position;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.StampedLock;

public class ReaderStampedLock implements Runnable {
    private final Position position;
    private final StampedLock lock;

    public ReaderStampedLock(Position position, StampedLock lock) {
        this.position = position;
        this.lock = lock;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            long stamp = lock.readLock();
            try {
                System.out.printf("Reader: %d - (%d,%d)\n", stamp, position.getX(), position.getY());
                TimeUnit.MILLISECONDS.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlockRead(stamp);
                System.out.printf("Reader: %d - Lock released\n", stamp);
            }
        }
    }
}
