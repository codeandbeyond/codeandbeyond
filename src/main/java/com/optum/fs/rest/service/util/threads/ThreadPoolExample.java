package com.optum.fs.rest.service.util.threads;



import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ThreadPoolExample {
    public static void main(String[] args) {
        ExecutorService workerThreads = Executors.newFixedThreadPool(2);
        try {
            workerThreads.submit(new Task(0, "prim.txt"));
            workerThreads.submit(new Task(1, "jobs.txt"));
            workerThreads.shutdown();

            workerThreads.awaitTermination(60, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}

final class Task implements Runnable {
    private int taskId;
    private String fileName;

    public Task(int taskId, String fileName) {
        this.taskId = taskId;
        this.fileName = fileName;
    }

    @Override
    public void run() {
        ClassLoader classLoader = ClassLoader.getSystemClassLoader();
        // File file = new File(classLoader.getResource(this.fileName).getFile());
        try {
            System.out.println(Files.readAllLines(Paths.get(new URI(classLoader.getResource(this.fileName).toString()))) + " by " + Thread.currentThread().getName());

        } catch (IOException i) {
            System.out.println(i);
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }
}
