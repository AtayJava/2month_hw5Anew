package com.company;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Semaphore;

public class Downloader extends Thread {
    private Semaphore semaphore;
    private CountDownLatch countDownLatch;

    public Downloader(String name, Semaphore semaphore, CountDownLatch countDownLatch) {
        super(name);
        this.semaphore = semaphore;
        this.countDownLatch = countDownLatch;
    }

    public void run() {
        try {
            System.out.println(this.getName() + " ожидает загрузку ");
            semaphore.acquire();
            System.out.println(this.getName() + " скачивает файл ");
            sleep(2000);
            System.out.println(this.getName() + " завершил загрузку ");
            semaphore.release();

            countDownLatch.countDown();
            countDownLatch.await();


        } catch (Exception e) {
            System.out.println("Exception");
        }
    }


}
