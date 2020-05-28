package com.kiwi.jvm.c2_classloader;

/**
 * 父加载器与加载器的加载器不是一个概念,
 * AppClassLoader加载器的parent是ExtClassLoader,
 * AppClassLoader的加载器是BootstrapClassLoader，打印null
 *
 */
public class T001_AppClassLoaderTest {

    public static void main(String[] args) {
        ClassLoader classLoader = Test.class.getClassLoader();
        System.out.println(classLoader);
        System.out.println(classLoader.getParent());
        System.out.println(classLoader.getClass().getClassLoader());
    }

    private static class Test {

    }

}
