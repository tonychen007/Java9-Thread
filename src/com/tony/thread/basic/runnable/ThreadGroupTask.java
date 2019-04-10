package com.tony.thread.basic.runnable;

import java.util.Random;

public class ThreadGroupTask implements Runnable {
    @Override
    public void run() {
        int result;
        Random random = new Random(Thread.currentThread().getId());

        while (true) {
            result = 1000 / ((int) (random.nextDouble() * 1000000000));
            if (Thread.currentThread().isInterrupted()) {
                System.out.printf("%d: %d: Interrupted.\n", result, Thread.currentThread().getId());
                return;
            }
        }
    }
}
