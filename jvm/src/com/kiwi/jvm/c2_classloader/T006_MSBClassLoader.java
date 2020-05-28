package com.kiwi.jvm.c2_classloader;


import com.kiwi.jvm.Hello;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
/** 自定义classLoader
 * 假设我们的classLoader需要从c:/test这个目录下加载class
 * */
public class T006_MSBClassLoader extends ClassLoader {


    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        File f = new File("c:/test/", name.replace(".", "/").concat(".class"));
        try {
            FileInputStream fis = new FileInputStream(f);
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            int b = 0;

            while ((b=fis.read()) !=0) {
                baos.write(b);
            }

            byte[] bytes = baos.toByteArray();
            baos.close();
            fis.close();//可以写的更加严谨

            return defineClass(name, bytes, 0, bytes.length);
        } catch (Exception e) {
            e.printStackTrace();
        }
        //throws ClassNotFoundException
        return super.findClass(name);
    }

    public static void main(String[] args) throws Exception {
        ClassLoader l = new T006_MSBClassLoader();
        //这里实际上还是通过app加载器加载的这个类
        Class clazz = l.loadClass("com.kiwi.jvm.Hello");
        Class clazz1 = l.loadClass("com.kiwi.jvm.Hello");

        System.out.println(clazz == clazz1);

        Hello h = (Hello) clazz.newInstance();
        h.m();

        System.out.println(l.getClass().getClassLoader());
        System.out.println(l.getParent());

//        System.out.println(getSystemClassLoader());
    }
}