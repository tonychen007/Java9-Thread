package com.tony.thread.sync.main;

import com.tony.thread.sync.mo.PricesInfo;
import com.tony.thread.sync.runnable.Reader;
import com.tony.thread.sync.runnable.Writer;

public class ReadWriteLockTest {
    public static void main(String[] args) {
        PricesInfo pricesInfo = new PricesInfo();
        Reader readers[] = new Reader[5];
        Thread threadsReader[] = new Thread[5];
        Writer writer = new Writer(pricesInfo);
        Thread threadWriter = new Thread(writer);

        for (int i = 0; i < 5; i++) {
            readers[i] = new Reader(pricesInfo);
            threadsReader[i] = new Thread(readers[i]);
        }
        for (int i = 0; i < 5; i++) {
            threadsReader[i].start();
        }
        threadWriter.start();
    }
}
