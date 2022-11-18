package com.sun.thread.thread.synchronized01;


/**
 * 线程安全的单例模式
 */
public class ThreadDemo04 {
    public static void main(String[] args) {

    }
}

class demo04 {

    public demo04(){

    };

    public demo04 insTence = null;

    //方式一
    private static synchronized demo04 getInstance(demo04 insTence){
        if (insTence == null){
            insTence = new demo04();
        }
        return insTence;
    }
    //方法二:效率稍差
    private static  demo04 getInstance1(demo04 insTence){
        synchronized(demo04.class){
            if (insTence == null){
                insTence = new demo04();
            }
            return insTence;
        }

    }

    //方法三，效率较好
    private static  demo04 getInstance3(demo04 insTence){
        if(insTence == null){
            synchronized(demo04.class){
                if (insTence == null){
                    insTence = new demo04();
                }
            }
        }
        return insTence;

    }

}