package chapter03;

/**
 * 对象优先在Eden分配
 * VM Args
 * -verbose:gc
 * -Xms20M                最小堆内存
 * -Xmx20M                最大堆内存
 * -Xmn10M                最大新生代内存
 * -XX:SurvivorRatio=8      新生代中Eden区域和Suvivor区域的空间比是8:1，即Eden区8M,两个Suvivor区分别为1M
 * -XX:+printGCDetails收集器日志参数，告诉虚拟机在发生垃圾收集行为时打印内存回收日志，
 * 并且在进程退出的时候输出当前的内存各区域分配情况
 * @author Charlie
 * @description
 */
public class EdenAllocate {

    private static final int _1MB = 1024 * 1024;

    public static void main(String[] args) {
        byte[] allocation1, allocation2, allocation3, allocation4;
        allocation1 = new byte[2 * _1MB];
        allocation2 = new byte[2 * _1MB];
        allocation3 = new byte[2 * _1MB];
        allocation4 = new byte[4 * _1MB];//出现一次Minor GC
    }

}
