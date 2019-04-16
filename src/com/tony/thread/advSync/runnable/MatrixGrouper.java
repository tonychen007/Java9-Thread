package com.tony.thread.advSync.runnable;

import com.tony.thread.advSync.mo.MatrixResults;

public class MatrixGrouper implements Runnable {
    private final MatrixResults results;

    public MatrixGrouper(MatrixResults results) {
        this.results = results;
    }

    @Override
    public void run() {
        int finalResult = 0;

        System.out.printf("Grouper: Processing results...\n");
        int data[] = results.getData();
        for (int number : data) {
            finalResult += number;
        }
        System.out.printf("Grouper: Total result: %d.\n", finalResult);
    }
}
