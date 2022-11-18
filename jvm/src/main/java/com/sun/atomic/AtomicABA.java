package com.sun.atomic;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * 原子类对象引用，AtomicStampedReference解决ABA问题，
 * 更新之前，需要传入之前的版本号，如果版本号不对，则无法更新
 *
 */
public class AtomicABA {
    public static void main(String[] args) {
        AutoRef autoRef = new AutoRef();
        new Thread(autoRef).start();
    }
}

class AutoRef implements Runnable{

    AtomicInteger a  =  new AtomicInteger();
    AtomicStampedReference<AtomicInteger> at = new AtomicStampedReference<AtomicInteger>(a,1);

    @Override
    public void run() {
        AtomicInteger b  =  new AtomicInteger();
        at.compareAndSet(a,b,1,2);
        System.out.println(at.getStamp());
    }
}