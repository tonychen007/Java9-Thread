package com.tony.thread.sync.mo;

import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class PricesInfo {
    private double price1;
    private double price2;
    private ReadWriteLock lock;

    public PricesInfo() {
        price1 = 1.0;
        price2 = 2.0;
        lock = new ReentrantReadWriteLock();
    }

    public double getPrice1() {
        lock.readLock().lock();
        double value = price1;
        lock.readLock().unlock();
        return value;
    }

    public double getPrice2() {
        lock.readLock().lock();
        double value = price2;
        lock.readLock().unlock();
        return value;
    }

    public void setPrices(double price1, double price2) {
        lock.writeLock().lock();
        System.out.printf("%s: PricesInfo: Write Lock Adquired.\n", new Date());

        try {
            TimeUnit.SECONDS.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        this.price1 = price1;
        this.price2 = price2;
        System.out.printf("%s: PricesInfo: Write Lock Released.\n", new Date());
        lock.writeLock().unlock();
    }
}
