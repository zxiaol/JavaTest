package com.yibuyao.waitBlock;

import java.util.Objects;

public class Main {

    private final static Object lock = new Object();

    public static void main(String[] args) throws Exception{
	// write your code here

       // verifyBlock();

        verifyWait();
    }

    private static void verifyWait() throws Exception{

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {

                try{

                    synchronized (lock){

                        lock.wait();
                    }


                }catch (InterruptedException e){


                }


            }
        }, ("waitting thread"));

        thread.start();

        Thread.sleep(20);

        synchronized (lock) {
            System.out.println("stay locker");
            // 保持锁
            while (true)
                ;
        }
    }

    private static void verifyBlock() throws Exception{

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {

                try{

                    Thread.sleep(10);

                    synchronized (lock){

                        System.out.println("blocking thread is in running ");
                    }

                }catch (InterruptedException e){

                    System.out.println("get exception");

                }

            }
        },"Block thread");

        thread.start();

        synchronized (lock){

            while (true){

                System.out.println("main thread");
            }
        }
    }
}
