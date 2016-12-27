package chapter03;

/**
 * 大对象直接进入老年代
 * VM Args
 * -verbose:gc
 * -Xms20M                                最小堆内存
 * -Xmx20M                                最大堆内存
 * -Xmn10M                                最大新生代内存
 * -XX:PretenureSizeThreshold=3145728     3MB以上的对象直接进入老年代
 * -XX:+printGCDetails
 * @author Charlie
 * @description
 * Parallel Scavenge收集器不认识这个参数，Parallel Scavenge收集器一般并不需要设置()
 */
public class PretenureSizeThreshold {

    private static final int _1MB = 1024 * 1024;

    public static void main(String[] args) {
        byte[] allocation = new byte[4 * _1MB];
    }

}
