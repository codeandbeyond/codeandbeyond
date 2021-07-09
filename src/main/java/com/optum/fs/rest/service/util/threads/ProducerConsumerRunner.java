package com.optum.fs.rest.service.util.threads;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.function.Consumer;

public class ProducerConsumerRunner {
    public static void main(String[] args) throws InterruptedException {
//        ProducerConsumer producerConsumer = new ProducerConsumer();
//        Thread t1 = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                producerConsumer.produce();
//            }
//        });
//        Thread t2 = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                producerConsumer.consume();
//            }
//        });
//        t1.start();
//        t2.start();
//        t1.join();
//        t2.join();
        BlockingQueue blockingQueue = new LinkedBlockingQueue<>();
        Producer producer = new Producer(blockingQueue);
        com.optum.fs.rest.service.util.threads.Consumer consumer = new com.optum.fs.rest.service.util.threads.Consumer(blockingQueue);

        Runnable target;
        Thread prodThread = new Thread(producer);
        Thread conThread = new Thread(consumer);
        prodThread.start();
        conThread.start();

    }
}
