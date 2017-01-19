package chapter12;

public class VolatileTest2 {
    public static volatile boolean stop;

    public void shutdown() {
        stop = true;
    }

    public void doWork() {
        while (!stop) {
            System.out.println("do work!");
        }
    }
}
