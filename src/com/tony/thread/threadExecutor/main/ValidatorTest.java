package com.tony.thread.threadExecutor.main;

import com.tony.thread.threadExecutor.mo.UserValidator;
import com.tony.thread.threadExecutor.runnable.ValidatorTask;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ValidatorTest {
    public static void main(String[] args) {
        String result;
        List<ValidatorTask> taskList = new ArrayList<>();
        String username = "test";
        String password = "test";

        UserValidator ldapValidator = new UserValidator("LDAP");
        UserValidator dbValidator = new UserValidator("DataBase");
        ValidatorTask ldapTask = new ValidatorTask(ldapValidator, username, password);
        ValidatorTask dbTask = new ValidatorTask(dbValidator, username, password);

        taskList.add(ldapTask);
        taskList.add(dbTask);

        ExecutorService executor = (ExecutorService) Executors.newCachedThreadPool();
        try {
            result = executor.invokeAny(taskList);
            System.out.printf("Main: Result: %s\n", result);
        } catch (InterruptedException | ExecutionException e) {
        }
        executor.shutdown();
        System.out.printf("Main: End of the Execution\n");
    }
}
