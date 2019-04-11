package com.tony.thread.sync.main;

import com.tony.thread.sync.mo.EventStorage;
import com.tony.thread.sync.runnable.Consumer;
import com.tony.thread.sync.runnable.Producer;

public class ProducerConsumer {
    public static void main(String[] args) {
        EventStorage storage = new EventStorage();
        Producer producer = new Producer(storage);
        Consumer consumer = new Consumer(storage);

        Thread producerThread = new Thread(producer, "producer-Thread");
        Thread consumerThread = new Thread(consumer, "consumer-Thread");

        producerThread.start();
        consumerThread.start();
    }
}
