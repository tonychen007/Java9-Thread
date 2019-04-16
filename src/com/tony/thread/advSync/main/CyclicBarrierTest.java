package com.tony.thread.advSync.main;

import com.tony.thread.advSync.mo.MatrixMock;
import com.tony.thread.advSync.mo.MatrixResults;
import com.tony.thread.advSync.runnable.MatrixGrouper;
import com.tony.thread.advSync.runnable.MatrixSearcher;

import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierTest {
    public static void main(String[] args) {
        final int ROWS = 10000;
        final int NUMBERS = 10000;
        final int SEARCH = 5;
        final int PARTICIPANTS = 5;
        final int LINES_PARTICIPANT = 2000;

        MatrixMock mock = new MatrixMock(ROWS, NUMBERS, SEARCH);
        MatrixResults results = new MatrixResults(ROWS);
        MatrixGrouper grouper = new MatrixGrouper(results);
        CyclicBarrier barrier = new CyclicBarrier(PARTICIPANTS, grouper);
        MatrixSearcher searchers[] = new MatrixSearcher[PARTICIPANTS];

        for (int i = 0; i < PARTICIPANTS; i++) {
            searchers[i] = new MatrixSearcher(i * LINES_PARTICIPANT,
                    (i * LINES_PARTICIPANT) + LINES_PARTICIPANT,
                    mock, results, 5, barrier);
            Thread thread = new Thread(searchers[i]);
            thread.start();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {}
        }
        System.out.printf("Main: The main thread has finished.\n");
    }
}
