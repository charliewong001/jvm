package chapter02;

import java.util.ArrayList;
import java.util.List;

/**
 * VM Args
 * -XX:PermSize=10M 初始方法区大小
 * -XX:MaxPermSize=10M 最大方法区大小
 * @author Charlie
 * @description 在jdk1.6的虚拟机中运行会出现java.lang.OutOfMemoryError: PermGen space
 * 因为在jdk1.6及其以下版本的hotspot虚拟机实现中,字符串常量池放在方法区中
 * String.intern();
 * 如果字符串常量池中存在此字符串，则取常量池中的字符串，并返回此字符串的引用
 * 如果字符串常量池中不存在，则创建此字符串并放入常量池中，并返回引用
 */
public class RuntimeConstantPoolOOM {

    public static void main(String[] args) {
        List<String> list = new ArrayList<String>();
        int i = 0;
        while (true) {
            list.add(String.valueOf(i++).intern());
        }
    }

}
