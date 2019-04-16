package com.tony.thread.advSync.mo;

public class MatrixResults {
    private final int data[];

    public MatrixResults(int size) {
        data = new int[size];
    }

    public void setData(int position, int value) {
        data[position] = value;
    }

    public int[] getData() {
        return data;
    }
}
