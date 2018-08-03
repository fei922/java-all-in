package com.leo.singleton;

/**
 * Created by zhoufeirj on 2018/8/3.
 *
 * 饿汉模式：类加载的时候就创建对象。
 *      优点：保证对象唯一
 *      缺点：一上来就创建，可能造成内存浪费
 */
public class EagerSingleton {

    private static EagerSingleton eagerSingleton = new EagerSingleton();

    // 构造函数私有化，防止使用new创建新的对象，保证对象唯一
    private EagerSingleton() {

    }

    public static EagerSingleton getInstance() {
        return eagerSingleton;
    }

    public static void main(String[] args) {
        System.out.println(EagerSingleton.getInstance());

        EagerSingleton eager1 = EagerSingleton.getInstance();
        EagerSingleton eager2 = EagerSingleton.getInstance();
        System.out.println("单例模式: 饿汉模式对象具有唯一性？" + (eager1 == eager2 ? "是！" : "不是！") );
    }
}
