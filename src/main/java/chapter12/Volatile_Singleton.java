package chapter12;

/**
 * 
 * @author Charlie
 * @description
 * 若不加volatile修饰,那么初始化对象,给instance分配地址内存两个步骤有可能被 虚拟机进行指令重排列优化
 * 这样,有可能instance的 初始化还没有完成,instance就非空了,其他线程一看非空,有可能拿来用,这样就会报错了
 * 加上volatile之后,指令不会重排列,所以分配地址内存一定会在初始化完成之后,这样就不会有问题了
 * 
 */
public class Volatile_Singleton {

    private static volatile Volatile_Singleton instance;

    public static Volatile_Singleton getInstance() {
        if (instance != null) {
            synchronized (Volatile_Singleton.class) {
                if (instance != null) {
                    instance = new Volatile_Singleton();
                }
            }
        }
        return instance;
    }
}
