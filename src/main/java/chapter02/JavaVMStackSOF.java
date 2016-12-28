package chapter02;

/**
 * VM Args:虚拟机参数
 * -Xss128K虚拟机栈的大小为128K
 * @author Charlie
 * @description 测试虚拟机栈(VMStack)StackOverflowError栈内存溢出
 * 测试代码中,递归调用方法,导致栈深度不断增大，最终触发虚拟机的最大允许栈深度，导致StackOverflowError
 * 在方法调用时，会创建一个栈帧压入虚拟机栈，一个方法的调用伴随着栈帧在虚拟机栈中从入栈到出栈的过程。
 * 下面的代码，创建了一个无限递归的方法，就会有无限的方法被调用，也就会在虚拟机栈中压入无限个栈帧
 * 导致虚拟机栈的内存不够用所以栈内存溢出
 */
public class JavaVMStackSOF {

    private int stackLength = 1;

    public void stackLeak() {
        stackLength++;
        stackLeak();
    }

    public static void main(String[] args) throws Throwable {
        JavaVMStackSOF sof = new JavaVMStackSOF();
        try {
            sof.stackLeak();
        } catch (Throwable e) {
            System.out.println("stack length:" + sof.stackLength);
            throw e;
        }
    }

}
