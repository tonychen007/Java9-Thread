package com.tony.thread.advSync.runnable;

import com.tony.thread.advSync.mo.MatrixMock;
import com.tony.thread.advSync.mo.MatrixResults;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class MatrixSearcher implements Runnable {
    private final int firstRow;
    private final int lastRow;
    private final MatrixMock mock;
    private final MatrixResults results;
    private final int number;
    private final CyclicBarrier barrier;

    public MatrixSearcher(int firstRow, int lastRow, MatrixMock mock,
                          MatrixResults results, int number, CyclicBarrier barrier) {
        this.firstRow = firstRow;
        this.lastRow = lastRow;
        this.mock = mock;
        this.results = results;
        this.number = number;
        this.barrier = barrier;
    }

    @Override
    public void run() {
        int counter;

        System.out.printf("%s: Processing lines from %d to %d.\n", Thread.currentThread().getName(), firstRow, lastRow);
        for (int i = firstRow; i < lastRow; i++) {
            int row[] = mock.getRow(i);
            counter = 0;
            for (int j = 0; j < row.length; j++) {
                if (row[j] == number) {
                    counter++;
                }
            }
            // test only, turn off change i == -1
            if (i == -1) {
                int num = barrier.getNumberWaiting();
                System.out.println("number of barrier waiting:" + num);
                Thread.currentThread().interrupt();
            }
            results.setData(i, counter);
        }
        System.out.printf("%s: Lines processed.\n", Thread.currentThread().getName());

        try {
            barrier.await();
            System.out.println("After barrier wait:" + Thread.currentThread().getName());
        } catch (InterruptedException e) {
            System.out.println("barrier interrupted:" + Thread.currentThread().getName());
        } catch (BrokenBarrierException e) {
            System.out.println("barrier broken:" + Thread.currentThread().getName());
        }
    }
}
