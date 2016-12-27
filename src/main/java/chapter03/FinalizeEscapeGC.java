package chapter03;

/**
 * 
 * @author Charlie
 * @description
 * 通过重写finalize方法，将自己存入一个root引用链,从而逃避回收
 * 因为finalize方法只会被jvm调用一次,所以也只能逃避回收一次
 * 注意：finalize此方法永远不要重写
 */
public class FinalizeEscapeGC {

    public static FinalizeEscapeGC SAVE_HOOK = null;

    public void isAlive() {
        System.out.println("yes,i am still alive :)");
    }

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("finalize method execute...");
        FinalizeEscapeGC.SAVE_HOOK = this;
    }

    public static void main(String[] args) throws Exception {
        SAVE_HOOK = new FinalizeEscapeGC();
        SAVE_HOOK = null;
        //对象第一次成功拯救自己
        System.gc();
        //因为finalize方法优先级很低，所以暂停0.5秒等待它
        Thread.sleep(500);
        if (SAVE_HOOK != null) {
            SAVE_HOOK.isAlive();
        } else {
            System.out.println("no,i am dead :(");
        }

        //下面这段代码与上面完全相同,但是这次却自救失败
        SAVE_HOOK = null;
        System.gc();
        //因为finalize方法优先级很低，所以暂停0.5秒等待它
        Thread.sleep(500);
        if (SAVE_HOOK != null) {
            SAVE_HOOK.isAlive();
        } else {
            System.out.println("no,i am dead :(");
        }
    }
}
