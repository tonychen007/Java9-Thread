package com.tony.thread.sync.runnable;

import com.tony.thread.sync.mo.Buffer;

import java.util.Random;

public class ConsumerCondition implements Runnable {
    private Buffer buffer;

    public ConsumerCondition(Buffer buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        while (buffer.hasPendingLines()) {
            String line = buffer.get();
            processLine(line);
        }
    }

    private void processLine(String line) {
        try {
            Random random = new Random();
            Thread.sleep(random.nextInt(100));
        } catch (InterruptedException e) {
        }
    }
}
