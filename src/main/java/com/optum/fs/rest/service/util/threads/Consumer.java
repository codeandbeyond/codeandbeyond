package com.optum.fs.rest.service.util.threads;

import java.util.concurrent.BlockingQueue;

public class Consumer implements Runnable{
    private final BlockingQueue sharedQueue;

    public Consumer(BlockingQueue sharedQueue){
        this.sharedQueue =sharedQueue;
    }
    @Override
    public void run() {
        while (true) {
            try {
                System.out.println("Consumer consumed " + sharedQueue.take());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
