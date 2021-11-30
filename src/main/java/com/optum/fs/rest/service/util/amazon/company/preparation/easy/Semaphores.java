package com.optum.fs.rest.service.util.amazon.company.preparation.easy;

import java.util.concurrent.Semaphore;

public class Semaphores {
    Semaphore run2, run3;

    public Semaphores() {
        run2 = new Semaphore(0);
        run3 = new Semaphore(0);
    }

    public void first(Runnable printFirst) throws InterruptedException {
        printFirst.run();
        run2.release();
    }

    public void second(Runnable printSecond) throws InterruptedException {
        run2.acquire();
        printSecond.run();
        run3.release();
    }

    public void third(Runnable printThird) throws InterruptedException {
        run3.acquire();
        printThird.run();
    }

    public static void main(String[] args) {
        Semaphores semaphores = new Semaphores();
    }
}
