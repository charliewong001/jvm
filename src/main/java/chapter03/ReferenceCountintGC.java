package chapter03;

/**
 * 
 * @author Charlie
 * @description
 * 虚拟机并没有因
      为这两个对象互相引用就不回收它们，
      这也从侧面说明虚拟机并不是通过引用计数算法来判断对象是否存活的
 */
public class ReferenceCountintGC {
    public Object instance = null;
    private static final int _1MB = 1024 * 1024;

    /**
     * 这个成员属性的唯一意义就是占点内存，以便能在GC日志中看清楚是否被回收过
     */
    private byte[] bigSize = new byte[2 * _1MB];

    public static void testGC() {
        ReferenceCountintGC objA = new ReferenceCountintGC();
        ReferenceCountintGC objB = new ReferenceCountintGC();
        objA.instance = objB;
        objB.instance = objA;
        objA = null;
        objB = null;
        //假设在这行发生GC,objA和objB是否能被回收？
        System.gc();
    }

    public static void main(String[] args) {
        testGC();
    }

}
