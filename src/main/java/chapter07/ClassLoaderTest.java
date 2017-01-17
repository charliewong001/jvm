package chapter07;

import java.io.IOException;
import java.io.InputStream;

/**
 * 
 * @author Charlie
 * @description
 * 自定义类加载器
 * 比较两个类是否“相等”，只有在这两个类是由同一个类加载器加载的前提下才有意
 * 义，否则，即使这两个类来源于同一个Class文件，被同一个虚拟机加载，只要加载它们的类
 * 加载器不同，那这两个类就必定不相等
 */
public class ClassLoaderTest {

    public static void main(String[] args) throws InstantiationException,
            IllegalAccessException, ClassNotFoundException {
        ClassLoader myLoader = new ClassLoader() {
            @Override
            public Class<?> loadClass(String name)
                    throws ClassNotFoundException {
                try {
                    String fileName = name.substring(name.lastIndexOf(".") + 1)
                            + ".class";
                    InputStream is = getClass().getResourceAsStream(fileName);
                    if (is == null) {
                        return super.loadClass(name);
                    }
                    byte[] b = new byte[is.available()];
                    is.read(b);
                    return defineClass(name, b, 0, b.length);
                } catch (IOException e) {
                    throw new ClassNotFoundException(name);
                }
            }
        };

        Object obj = myLoader.loadClass("chapter07.ClassLoaderTest")
                .newInstance();
        System.out.println(obj.getClass());
        System.out.println(obj instanceof chapter07.ClassLoaderTest);
    }
}
