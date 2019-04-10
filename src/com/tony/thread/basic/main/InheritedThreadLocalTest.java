package com.tony.thread.basic.main;

class ParentThread extends Thread {
    public static java.lang.ThreadLocal threadLocal = new java.lang.ThreadLocal();

    public static InheritableThreadLocal inheritedThreadLocal = new InheritableThreadLocal() {
        @Override
        protected Object initialValue() {
            return "parent inheritedThreadLocal";
        }

        @Override
        protected Object childValue(Object parentValue) {
            return "child threadvalue";
        }
    };

    @Override
    public void run() {
        System.out.println("parent threadLocal:" + threadLocal.get());
        System.out.println("parent inheritedThreadLocal:" + inheritedThreadLocal.get());
        threadLocal.set("parent thl");
        inheritedThreadLocal.set("parent ithl");
        System.out.println("parent threadLocal:" + threadLocal.get());
        System.out.println("parent inheritedThreadLocal:" + inheritedThreadLocal.get());

        ChildThread ch = new ChildThread();
        ch.start();
    }
}

class ChildThread extends Thread {
    @Override
    public void run() {
        System.out.println("child threadLocal:" + ParentThread.threadLocal.get());
        System.out.println("child inheritedThreadLocal:" + ParentThread.inheritedThreadLocal.get());
        ParentThread.inheritedThreadLocal.set("child ithl");
        System.out.println("child inheritedThreadLocal:" + ParentThread.inheritedThreadLocal.get());
    }
}

public class InheritedThreadLocalTest {
    public static void main(String[] args) {
        Thread th = new ParentThread();
        th.start();
    }
}
