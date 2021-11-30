package com.optum.fs.rest.service.util.threads;

import java.util.LinkedList;

public class ProducerConsumer {
    private LinkedList list = new LinkedList();
    private final int capacity = 2;
    private int val = 0;

    public void produce() {
        while (true) {
            synchronized (this) {
                try {
                    while (list.size() == capacity)
                        wait();
                    System.out.println("Producer Produced a value of " + val);
                    list.add(val++);
                    notify();
                    Thread.sleep(1000);

                } catch (InterruptedException ex) {
                    System.out.println(ex.getCause());
                }
            }
        }
    }

    public void consume() {
        while (true) {
            synchronized (this) {
                try {
                    while (list.size() == 0)
                        wait();
                    System.out.println("Consumer consumed a value of " + list.removeFirst());
                    notify();
                    Thread.sleep(1000);

                } catch (InterruptedException ex) {
                    System.out.println(ex.getCause());
                }
            }
        }
    }
}
