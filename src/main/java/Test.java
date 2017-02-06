
import java.lang.reflect.Field;

import sun.misc.Unsafe;

public class Test {

    public static void main(String[] args)
            throws NoSuchFieldException, SecurityException,
            IllegalArgumentException, IllegalAccessException {
        long start = System.nanoTime();
        Field theUnsafe = Unsafe.class.getDeclaredField("theUnsafe");
        theUnsafe.setAccessible(true);
        Unsafe unSafe = (Unsafe) theUnsafe.get(null);
        long addr = unSafe.allocateMemory(10000000);
        for (int i = 0; i < 10000000; i++) {
            unSafe.putAddress(addr + i, 12345678911L);
        }
        long end = System.nanoTime();
        System.out.println(end - start);

    }

}
