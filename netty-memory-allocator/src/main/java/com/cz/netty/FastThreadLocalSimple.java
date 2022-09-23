package com.cz.netty;

import io.netty.util.concurrent.DefaultThreadFactory;
import io.netty.util.concurrent.FastThreadLocal;
import io.netty.util.concurrent.FastThreadLocalThread;
import io.netty.util.concurrent.ThreadPerTaskExecutor;

/**
 * @author chenzhang
 * @date 2022/9/4 5:31 下午
 */
public class FastThreadLocalSimple {
    public static void main(String[] args) throws InterruptedException {
        new FastThreadLocalThread(new Runnable() {
            @Override
            public void run() {
                FastThreadLocal fastThreadLocal = new FastThreadLocal();
                fastThreadLocal.set("hello baby");
                System.out.println(fastThreadLocal.get());
                fastThreadLocal.remove();
                fastThreadLocal.set("hello baby2");
                System.out.println(fastThreadLocal.get());
            }
        }).start();


        new ThreadPerTaskExecutor(new DefaultThreadFactory("121")).execute(new Runnable() {
            @Override
            public void run() {
                FastThreadLocal fastThreadLocal = new FastThreadLocal();
                fastThreadLocal.set("hello baby3");
                System.out.println(fastThreadLocal.get());
                fastThreadLocal.remove();
                fastThreadLocal.set("hello baby4");
                System.out.println(fastThreadLocal.get());
            }
        });

        Thread.sleep(60000);
    }
}
