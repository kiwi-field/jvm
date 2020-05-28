package com.kiwi.jvm.c2_classloader;

public class T002_ClassLoaderLevel {
    public static void main(String[] args) {
        System.out.println(String.class.getClassLoader());
        System.out.println(sun.awt.HKSCS.class.getClassLoader());
        System.out.println(sun.net.spi.nameservice.dns.DNSNameService.class.getClassLoader());
        System.out.println(T002_ClassLoaderLevel.class.getClassLoader());

        System.out.println(sun.net.spi.nameservice.dns.DNSNameService.class.getClassLoader().getClass().getClassLoader());
        System.out.println(T002_ClassLoaderLevel.class.getClassLoader().getClass().getClassLoader());

        System.out.println(new T006_MSBClassLoader().getParent());
        // 系统（System）类加载器 也称应用程序加载器是指 Sun公司实现的sun.misc.Launcher$AppClassLoader。
        System.out.println(ClassLoader.getSystemClassLoader());
    }
}
