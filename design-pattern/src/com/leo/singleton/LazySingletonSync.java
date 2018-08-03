package com.leo.singleton;

import java.util.Random;

/**
 * Created by zhoufeirj on 2018/8/3.
 *
 * 懒汉模式，类加载的时候不创建对象，需要的时候再创建
 *      优点：需要的时候再创建，不会占用内存
 *      缺点：如果初始化对象(构造函数)执行时间比较长，多线程进来，可能会导致创建的对象不唯一
 */
public class LazySingletonSync {
    private static LazySingletonSync lazySingletonInstance = null;

    private int randomInt ;

    private LazySingletonSync(){
        try{
//            Thread.sleep(100);
            randomInt = (int)(Math.random()*10);
        }catch (Exception e){
            System.out.println("exception...");
        }
    }

    /**
     * 加上synchronized关键字，可以保证同步，创建唯一对象
     *
     */
//    public  static LazySingletonSync getInstance() {
    public synchronized static LazySingletonSync getInstance() {
        if (lazySingletonInstance == null){
            lazySingletonInstance = new LazySingletonSync();
        }
        return lazySingletonInstance;
    }


    public int getRandomInt() {
        return randomInt;
    }

    public static void main(String[] args) {

        System.out.println("如果初始化对象(构造函数)执行时间比较长，多线程进来，可能会导致创建的对象不唯一。通过判断输出随机数字是否相同，判断对象是否是否是同一个" );
        Thread thread1 = new Thread(new TestLazySingleton());
        Thread thread2 = new Thread(new TestLazySingleton());

        thread1.start();
        thread2.start();
    }

}

class TestLazySingleton implements Runnable{

    @Override
    public void run() {
        LazySingletonSync lazy1 = LazySingletonSync.getInstance();
        System.out.println(lazy1.getRandomInt());
    }
}
