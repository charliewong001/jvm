package chapter04;

import java.util.ArrayList;
import java.util.List;

public class Heap {

    static class OOMObject {
        public byte[] placeholder = new byte[64 * 1024];
    }

    /**
     * 测试内存监控
     * @param num
     * @throws InterruptedException
     */
    public static void fillHeap(int num) throws InterruptedException {
        Thread.sleep(10000);
        List<OOMObject> list = new ArrayList<OOMObject>();
        for (int i = 0; i < num; i++) {
            //稍作延时,令监视曲线的变化更加明显
            Thread.sleep(50);
            list.add(new OOMObject());
        }
        System.gc();
    }

    public static void main(String[] args) throws Exception {
        fillHeap(1000);
    }

}
