package com.tony.thread.threadExecutor.main;

import com.tony.thread.threadExecutor.mo.RejectedTaskController;
import com.tony.thread.threadExecutor.runnable.RejectTask;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class RejectTaskTest {
    private final ThreadPoolExecutor executor;

    public RejectTaskTest() {
        executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
        RejectedTaskController controller = new RejectedTaskController();
        executor.setRejectedExecutionHandler(controller);
    }

    public void executeTask(RejectTask task) {
        System.out.printf("RejectTaskTest: A new task has arrived\n");
        executor.execute(task);
        System.out.printf("RejectTaskTest: Pool Size: %d\n", executor.getPoolSize());
        System.out.printf("RejectTaskTest: Active Count: %d\n", executor.getActiveCount());
        System.out.printf("RejectTaskTest: Task Count: %d\n", executor.getTaskCount());
        System.out.printf("RejectTaskTest: Completed Tasks: %d\n", executor.getCompletedTaskCount());
    }

    public void endServer() {
        executor.shutdown();
    }

    public static void main(String[] args) {
        RejectTaskTest server = new RejectTaskTest();
        System.out.printf("Main: Starting.\n");

        for (int i = 0; i < 20; i++) {
            RejectTask task = new RejectTask("Task " + i);
            server.executeTask(task);
        }

        System.out.printf("Main: Shuting down the Executor.\n");
        server.endServer();

        System.out.printf("Main: Sending another Task.\n");
        RejectTask task = new RejectTask("Rejected task");
        server.executeTask(task);
        System.out.printf("Main: End.\n");
    }
}
