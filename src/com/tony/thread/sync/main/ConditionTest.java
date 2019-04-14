package com.tony.thread.sync.main;

import com.tony.thread.sync.mo.Buffer;
import com.tony.thread.sync.mo.FileMock;
import com.tony.thread.sync.runnable.ConsumerCondition;
import com.tony.thread.sync.runnable.ProducerCondition;

public class ConditionTest {
    public static void main(String[] args) {
        FileMock mock = new FileMock(100, 10);
        Buffer buffer = new Buffer(20);

        ProducerCondition producer = new ProducerCondition(mock, buffer);
        Thread producerThread = new Thread(producer, "Producer");

        ConsumerCondition consumers[] = new ConsumerCondition[3];
        Thread consumersThreads[] = new Thread[3];
        for (int i = 0; i < 3; i++) {
            consumers[i] = new ConsumerCondition(buffer);
            consumersThreads[i] = new Thread(consumers[i], "Consumer " + i);
        }

        producerThread.start();
        for (int i = 0; i < 3; i++) {
            consumersThreads[i].start();
        }
    }
}
