package com.tony.thread.sync.main;

public class DeadLockTest {
    private static final Object objA = new Object();
    private static final Object objB = new Object();

    public static void main(String[] args) {
        Thread th1 = new Thread(() -> {
            while (true) {
                synchronized (objA) {
                    synchronized (objB) {

                    }
                }
            }
        });

        Thread th2 = new Thread(() -> {
            while (true) {
                synchronized (objB) {
                    synchronized (objA) {

                    }
                }
            }
        });

        th1.start();
        th2.start();
    }
}
