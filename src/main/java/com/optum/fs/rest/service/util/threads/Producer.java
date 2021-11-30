package com.optum.fs.rest.service.util.threads;

import java.util.concurrent.BlockingQueue;

public class Producer implements Runnable{
    private final BlockingQueue sharedQueue;
        public Producer(BlockingQueue blockingQueue){
            this.sharedQueue = blockingQueue;
        }
    @Override
    public void run() {
        for(int i=0;i<10;i++){
            System.out.println(" Producer produced "+i);
            sharedQueue.add(i);
        }
    }
}
