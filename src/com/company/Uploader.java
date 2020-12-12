package com.company;

import java.util.concurrent.CountDownLatch;

public class Uploader extends Thread {
    private CountDownLatch countDownLatch;

    public Uploader(CountDownLatch countDownLatch) {
        this.countDownLatch = countDownLatch;
    }

    public void run() {
        try {
            System.out.println("Файл загружается на сервер");
            sleep(1000);
            for (int i = 1; i < 2; i++) {
                System.out.println("⚫");
                sleep(1000);
                System.out.println("⚫⚫");
                sleep(1000);
                System.out.println("⚫⚫⚫");
                sleep(1000);
                System.out.println("⚫⚫⚫⚫");
                sleep(1000);
                System.out.println("⚫⚫⚫");
                sleep(1000);
                System.out.println("⚫⚫");
                sleep(1000);
                System.out.println("⚫");
                sleep(1000);
                System.out.println("Файл загрузился на сервер");
                sleep(2000);


            }

        } catch (Exception e) {
            System.out.println("Error 404");
        }


    }

}
