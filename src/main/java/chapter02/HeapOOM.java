package chapter02;

import java.util.ArrayList;
import java.util.List;

/**
 * VM Args：jvm参数
 * -verbose:gc 输出虚拟机中gc的详细情况 
 * -Xms20m 最小堆内存 
 * -Xmx20m 最大堆内存
 * -XX:+HeapDumpOnOutOfMemoryError JVM会在遇到OutOfMemoryError时拍摄一个“堆转储快照”,并将其保存在一个文件中
 * @author Charlie
 * @description 测试堆内存溢出
 */
public class HeapOOM {

    static class OOMObject {
    }

    public static void main(String[] args) {
        List<OOMObject> list = new ArrayList<OOMObject>();
        while (true) {
            list.add(new OOMObject());
        }
    }

}
