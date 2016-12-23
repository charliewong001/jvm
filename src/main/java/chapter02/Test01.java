package chapter02;

public class Test01 implements Runnable {

    private String name = "name";
    public static int age = 18;

    @Override
    public void run() {
        System.out.println("name = " + name + Thread.currentThread().getName());
        System.out.println("age = " + age + Thread.currentThread().getName());
        age = 17;
    }

    public static void main(String[] args) {
        Thread t1 = new Thread(new Test01());
        Thread t2 = new Thread(new Test01());
        t1.start();
        t2.start();
    }

}
