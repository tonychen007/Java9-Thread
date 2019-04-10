package com.tony.thread.basic.runnable;

import java.util.Date;
import java.util.concurrent.TimeUnit;

public class NetworkLoader implements Runnable {
    @Override
    public void run() {
        System.out.printf("Network loading has finished: %s\n", new Date());
        try {
            TimeUnit.SECONDS.sleep(4);
        } catch (InterruptedException e) {

        }
    }
}
