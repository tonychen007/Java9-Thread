package com.tony.thread.sync.runnable;

import com.tony.thread.sync.mo.Buffer;
import com.tony.thread.sync.mo.FileMock;

public class ProducerCondition implements Runnable {
    private FileMock fileMock;
    private Buffer buffer;

    public ProducerCondition(FileMock fileMock, Buffer buffer) {
        this.fileMock = fileMock;
        this.buffer = buffer;
    }

    @Override
    public void run() {
        buffer.setPendingLines(true);
        while (fileMock.hasMoreLines()) {
            String line = fileMock.getLine();
            buffer.insert(line);
        }
        buffer.setPendingLines(false);
    }
}
