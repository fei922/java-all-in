package com.leo.singleton;

/**
 * Created by zhoufeirj on 2018/8/3.
 *
 * 懒汉模式，类加载的时候不创建对象，需要的时候再创建
 *      优点：需要的时候再创建，不会占用内存
 *      缺点：如果初始化对象(构造函数)执行时间比较长，多线程进来，可能会导致创建的对象不唯一
 */
public class LazySingleton {
    private static LazySingleton lazySingletonInstance = null;

    private LazySingleton(){

    }

    public static LazySingleton getInstance() {
        if (lazySingletonInstance == null){
            lazySingletonInstance = new LazySingleton();
        }
        return lazySingletonInstance;
    }

    public static void main(String[] args) {
        System.out.println(LazySingleton.getInstance());

        LazySingleton lazy1 = LazySingleton.getInstance();
        LazySingleton lazy2 = LazySingleton.getInstance();
        System.out.println("单例模式: 懒汉模式对象具有唯一性？" + (lazy1 == lazy2 ? "是！" : "不是！") );
    }
}
