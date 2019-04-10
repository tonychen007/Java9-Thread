package com.tony.thread.runnable;

import java.util.Date;
import java.util.concurrent.TimeUnit;

public class DataSourceLoader implements Runnable {
    @Override
    public void run() {
        System.out.printf("Data sources loading has finished: %s\n", new Date());
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {

        }
    }
}
