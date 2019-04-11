package com.tony.thread.sync.mo;

import java.util.Date;
import java.util.LinkedList;
import java.util.Queue;

public class EventStorage {
    private final int maxSize = 10;
    private Queue<Date> storage = new LinkedList<>();

    public synchronized void set() {
        while (storage.size() == maxSize) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        storage.offer(new Date());
        System.out.printf("Set: %d\n", storage.size());
        notifyAll();
    }

    public synchronized void get() {
        while (storage.size() == 0) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        String element = storage.poll().toString();
        System.out.printf("Get: %d: %s\n", storage.size(), element);
        notifyAll();
    }
}
