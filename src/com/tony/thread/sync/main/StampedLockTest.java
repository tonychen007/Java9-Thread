package com.tony.thread.sync.main;

import com.tony.thread.sync.mo.Position;
import com.tony.thread.sync.runnable.OptimisticReader;
import com.tony.thread.sync.runnable.ReaderStampedLock;
import com.tony.thread.sync.runnable.WriterStampedLock;

import java.util.concurrent.locks.StampedLock;

public class StampedLockTest {
    public static void main(String[] args) {
        Position position = new Position();
        StampedLock lock = new StampedLock();

        Thread threadWriter = new Thread(new WriterStampedLock(position, lock));
        Thread threadReader = new Thread(new ReaderStampedLock(position, lock));
        Thread threadOptReader = new Thread(new OptimisticReader(position, lock));

        //threadWriter.start();
        threadReader.start();
        threadOptReader.start();
        try {
            //threadWriter.join();
            threadReader.join();
            threadOptReader.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
