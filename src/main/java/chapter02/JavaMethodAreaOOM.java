package chapter02;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

/**
 * 方法区内存溢出
 * VM Args
 * -XX:PermSize=10M
 * -xx:MaxPermSize=10M
 * 
 * @author Charlie
 * @description 
 * 方法区用于存放Class的相关信息，如类名、 访问修饰符、 常量池、 字段描述、 方法描述
    等。 对于这些区域的测试，基本的思路是运行时产生大量的类去填满方法区，直到溢出。 虽
    然直接使用Java SE API也可以动态产生类（如反射时的GeneratedConstructorAccessor和动态
    代理等），但在本次实验中操作起来比较麻烦。 在代码清单2-8中，笔者借助CGLib[1]直接操
    作字节码运行时生成了大量的动态类。
    值得特别注意的是，我们在这个例子中模拟的场景并非纯粹是一个实验，这样的应用经
    常会出现在实际应用中：当前的很多主流框架，如Spring、 Hibernate，在对类进行增强时，
    都会使用到CGLib这类字节码技术，增强的类越多，就需要越大的方法区来保证动态生成的
    Class可以加载入内存。 另外，JVM上的动态语言（例如Groovy等）通常都会持续创建类来实
    现语言的动态性，随着这类语言的流行，也越来越容易遇到与代码清单2-8相似的溢出场
    景。
 */
public class JavaMethodAreaOOM {

    public static void main(String[] args) {
        while (true) {
            Enhancer enhancer = new Enhancer();
            enhancer.setSuperclass(OOMObject.class);
            enhancer.setUseCache(false);
            enhancer.setCallback(new MethodInterceptor() {
                @Override
                public Object intercept(Object arg0, Method arg1, Object[] arg2,
                        MethodProxy arg3) throws Throwable {
                    return arg3.invokeSuper(arg0, arg2);
                }
            });
            enhancer.create();
        }
    }

    static class OOMObject {
    }

}
