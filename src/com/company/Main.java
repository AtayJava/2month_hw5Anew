package com.company;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;

public class Main {

    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(3, true);
        CountDownLatch cdl = new CountDownLatch(10);
        CountDownLatch cdl2 = new CountDownLatch(1);

        Uploader uploader = new Uploader(cdl2);
        uploader.start();

        try {
            uploader.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        for (int i = 1; i <= 10; i++) {
            new Downloader("User " + i, semaphore, cdl).start();
        }

        try {
            cdl.await();
        } catch (InterruptedException er) {
            er.printStackTrace();
        }

        System.out.println("Файл был удален!!!");


    }
}
