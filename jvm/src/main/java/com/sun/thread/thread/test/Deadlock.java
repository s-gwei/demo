package com.sun.thread.thread.test;

public class Deadlock {
    public static void main(String[] args) {
     StringBuffer s1 = new StringBuffer();
     StringBuffer s2 = new StringBuffer();
      new Thread(new Runnable() {
          @Override
          public void run() {
              synchronized (s1){
                  s1.append("1");
                  s2.append("a");
                  try {
                      Thread.sleep(100);
                  } catch (InterruptedException e) {
                      e.printStackTrace();
                  }
                  synchronized (s2){
                      s1.append("2");
                      s2.append("b");
                      System.out.println(s1);
                      System.out.println(s2);
                  }
              }
          }
      }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (s2){
                    s1.append("3");
                    s2.append("c");
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized (s1){
                        s1.append("4");
                        s2.append("d");
                        System.out.println(s1);
                        System.out.println(s2);
                    }
                }
            }
        }).start();
    }
}

