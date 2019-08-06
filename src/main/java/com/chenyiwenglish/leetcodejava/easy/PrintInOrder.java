package com.chenyiwenglish.leetcodejava.easy;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class PrintInOrder {

    public static void main(String[] args) {

    }

    static class Foo {

        private CountDownLatch one = new CountDownLatch(1);
        private CountDownLatch two = new CountDownLatch(1);

        public void first(Runnable printFirst) throws InterruptedException {
            // printFirst.run() outputs "first". Do not change or remove this line.
            printFirst.run();
            one.countDown();
        }

        public void second(Runnable printSecond) throws InterruptedException {
            one.await(10, TimeUnit.SECONDS);
            // printSecond.run() outputs "second". Do not change or remove this line.
            printSecond.run();
            two.countDown();
        }

        public void third(Runnable printThird) throws InterruptedException {
            two.await(10, TimeUnit.SECONDS);
            // printThird.run() outputs "third". Do not change or remove this line.
            printThird.run();
        }
    }
}
