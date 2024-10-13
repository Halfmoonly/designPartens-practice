
JDK的动态代理是在运行时生效，编译期无法确定具体的目标对象类型，因此可以做到1份代理逻辑，适配多种不同的目标接口，而这些接口之间没有继承关系，更加具备通用性和灵活性

JDK的动态代理必须实现InvocationHandler接口完成代理业务逻辑的处理；如果自定义的InvocationHandler逻辑内含有menthod.invoke(target,args)逻辑，则目标对象类型必须与目标接口类型一致

首先，我们编写并运行动态代理示例代码：
```java
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

// 定义一个接口
interface MyService {
    void doSomething();
}

// 实现接口的类
class MyServiceImpl implements MyService {
    @Override
    public void doSomething() {
        System.out.println("Doing something...");
    }
}

// 自定义的 InvocationHandler
class MyInvocationHandler implements InvocationHandler {
    private final MyService target;

    public MyInvocationHandler(MyService target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("Before method call");
        Object result = method.invoke(target, args);
        System.out.println("After method call");
        return result;
    }
}

public class DynamicProxyExample {
    public static void main(String[] args) {
        // 创建目标对象
        MyService target = new MyServiceImpl();

        // 创建 InvocationHandler
        MyInvocationHandler handler = new MyInvocationHandler(target);

        // 创建代理对象
        MyService proxy = (MyService) Proxy.newProxyInstance(
            MyService.class.getClassLoader(),  // 类加载器
            new Class[]{MyService.class},     // 接口列表
            handler                           // InvocationHandler
        );

        // 通过代理对象调用方法
        proxy.doSomething();
    }
}
```

在Java中，动态生成的代理类是由JVM在运行时自动生成的，通常不会直接以源代码的形式出现。不过，我们可以使用一些工具来反编译生成的字节码文件，以查看动态生成的代理类的结构。

# 深入JVM拦截生成的代理类
## 方式1：查找生成的代理类字节码，反编译字节码
查找生成的代理类字节码,代理类的字节码文件通常位于JVM的临时目录中。你可以通过以下命令查看临时目录的位置：
```shell
echo $JAVA_IO_TMPDIR
```
或者在代码中打印临时目录路径：
```java
System.out.println(System.getProperty("java.io.tmpdir"));
```
使用 javap 工具反编译生成的代理类字节码。假设生成的代理类名为 com.sun.proxy.$Proxy0，你可以使用以下命令：
```shell
javap -p -c -s -sysinfo com.sun.proxy.$Proxy0
```
以下是反编译后的代理类的大致结构（简化版）：
```java
public final class com.sun.proxy.$Proxy0 extends java.lang.reflect.Proxy implements MyService {
    private static java.lang.reflect.Method m1;
    private static java.lang.reflect.Method m3;
    private static java.lang.reflect.Method m2;
    private static java.lang.reflect.Method m0;

    public com.sun.proxy.$Proxy0(java.lang.reflect.InvocationHandler);
      Code:
         0: aload_0
         1: aload_1
         2: invokespecial #1                  // Method java/lang/reflect/Proxy."<init>":(Ljava/lang/reflect/InvocationHandler;)V
         5: return

    public final boolean equals(java.lang.Object);
      Code:
         0: aload_0
         1: getfield      #2                  // Field h:Ljava/lang/reflect/InvocationHandler;
         4: aload_1
         5: getstatic     #3                  // Field m1:Ljava/lang/reflect/Method;
         8: iconst_1
         9: anewarray     #4                  // class java/lang/Object
        12: dup
        13: iconst_0
        14: aload_1
        15: aastore
        16: invokevirtual #5                  // Method java/lang/reflect/InvocationHandler.invoke:(Ljava/lang/Object;Ljava/lang/reflect/Method;[Ljava/lang/Object;)Ljava/lang/Object;
        19: checkcast     #6                  // class java/lang/Boolean
        22: invokevirtual #7                  // Method java/lang/Boolean.booleanValue:()Z
        25: ireturn

    public final void doSomething();
      Code:
         0: aload_0
         1: getfield      #2                  // Field h:Ljava/lang/reflect/InvocationHandler;
         4: getstatic     #8                  // Field m3:Ljava/lang/reflect/Method;
         7: iconst_0
         8: anewarray     #4                  // class java/lang/Object
        11: invokevirtual #5                  // Method java/lang/reflect/InvocationHandler.invoke:(Ljava/lang/Object;Ljava/lang/reflect/Method;[Ljava/lang/Object;)Ljava/lang/Object;
        14: pop
        15: return

    public final int hashCode();
      Code:
         0: aload_0
         1: getfield      #2                  // Field h:Ljava/lang/reflect/InvocationHandler;
         4: getstatic     #9                  // Field m2:Ljava/lang/reflect/Method;
         7: iconst_0
         8: anewarray     #4                  // class java/lang/Object
        11: invokevirtual #5                  // Method java/lang/reflect/InvocationHandler.invoke:(Ljava/lang/Object;Ljava/lang/reflect/Method;[Ljava/lang/Object;)Ljava/lang/Object;
        14: checkcast     #10                 // class java/lang/Integer
        17: invokevirtual #11                 // Method java/lang/Integer.intValue:()I
        20: ireturn

    public final java.lang.String toString();
      Code:
         0: aload_0
         1: getfield      #2                  // Field h:Ljava/lang/reflect/InvocationHandler;
         4: getstatic     #12                 // Field m0:Ljava/lang/reflect/Method;
         7: iconst_0
         8: anewarray     #4                  // class java/lang/Object
        11: invokevirtual #5                  // Method java/lang/reflect/InvocationHandler.invoke:(Ljava/lang/Object;Ljava/lang/reflect/Method;[Ljava/lang/Object;)Ljava/lang/Object;
        14: checkcast     #13                 // class java/lang/String
        17: areturn

    static {};
      Code:
         0: ldc           #14                 // class com/sun/proxy/$Proxy0
         2: ldc           #15                 // String equals
         4: iconst_1
         5: anewarray     #16                 // class java/lang/Class
         8: dup
         9: iconst_0
        10: ldc           #17                 // class java/lang/Object
        12: aastore
        13: invokevirtual #18                 // Method java/lang/Class.getMethod:(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
        16: putstatic     #3                  // Field m1:Ljava/lang/reflect/Method;
        19: ldc           #14                 // class com/sun/proxy/$Proxy0
        21: ldc           #19                 // String hashCode
        23: iconst_0
        24: anewarray     #16                 // class java/lang/Class
        27: invokevirtual #18                 // Method java/lang/Class.getMethod:(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
        30: putstatic     #9                  // Field m2:Ljava/lang/reflect/Method;
        33: ldc           #14                 // class com/sun/proxy/$Proxy0
        35: ldc           #20                 // String toString
        37: iconst_0
        38: anewarray     #16                 // class java/lang/Class
        41: invokevirtual #18                 // Method java/lang/Class.getMethod:(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
        44: putstatic     #12                 // Field m0:Ljava/lang/reflect/Method;
        47: ldc           #14                 // class com/sun/proxy/$Proxy0
        49: ldc           #21                 // String doSomething
        51: iconst_0
        52: anewarray     #16                 // class java/lang/Class
        55: invokevirtual #18                 // Method java/lang/Class.getMethod:(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
        58: putstatic     #8                  // Field m3:Ljava/lang/reflect/Method;
        61: return
}
```
解释
- 类定义： com.sun.proxy.$Proxy0 继承自 java.lang.reflect.Proxy 并实现了 MyService 接口。
- 构造函数： 构造函数 com.sun.proxy.$Proxy0(InvocationHandler) 调用了父类 Proxy 的构造函数，并传入了 InvocationHandler。
- 方法实现： 每个接口方法（如 doSomething）都有一个对应的实现，这些实现都调用了 InvocationHandler 的 invoke 方法。 equals、hashCode 和 toString 方法也是通过 InvocationHandler 的 invoke 方法来实现的。
- 静态初始化块： 静态初始化块中，代理类会获取并缓存各个方法的 Method 对象，以便在调用时使用。

通过这种方式，JVM 动态生成的代理类能够拦截并处理接口方法的调用，从而实现动态代理的功能。

## 方式2 自动反编译出代理类并持久化
由于 $Proxy0.class 是在内存中的，所以我们需要写到本地

在main方法开始处：
```java
System.getProperties().put("jdk.proxy.ProxyGenerator.saveGeneratedFiles", "true");
```
生成目录结构jdk.proxy1.$Proxy0

查看$Proxy0
```java
//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package jdk.proxy1;

import java.lang.invoke.MethodHandles;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.lang.reflect.UndeclaredThrowableException;
import org.lyflexi.proxy.dynamic_proxy_jdk_v2.service.MyService;

public final class $Proxy0 extends Proxy implements MyService {
    private static final Method m0;
    private static final Method m1;
    private static final Method m2;
    private static final Method m3;

    public $Proxy0(InvocationHandler var1) {
        super(var1);
    }

    public final int hashCode() {
        try {
            return (Integer)super.h.invoke(this, m0, (Object[])null);
        } catch (RuntimeException | Error var2) {
            throw var2;
        } catch (Throwable var3) {
            throw new UndeclaredThrowableException(var3);
        }
    }

    public final boolean equals(Object var1) {
        try {
            return (Boolean)super.h.invoke(this, m1, new Object[]{var1});
        } catch (RuntimeException | Error var2) {
            throw var2;
        } catch (Throwable var3) {
            throw new UndeclaredThrowableException(var3);
        }
    }

    public final String toString() {
        try {
            return (String)super.h.invoke(this, m2, (Object[])null);
        } catch (RuntimeException | Error var2) {
            throw var2;
        } catch (Throwable var3) {
            throw new UndeclaredThrowableException(var3);
        }
    }

    public final void doSomething() {
        try {
            super.h.invoke(this, m3, (Object[])null);
        } catch (RuntimeException | Error var2) {
            throw var2;
        } catch (Throwable var3) {
            throw new UndeclaredThrowableException(var3);
        }
    }

    static {
        try {
            m0 = Class.forName("java.lang.Object").getMethod("hashCode");
            m1 = Class.forName("java.lang.Object").getMethod("equals", Class.forName("java.lang.Object"));
            m2 = Class.forName("java.lang.Object").getMethod("toString");
            m3 = Class.forName("org.lyflexi.proxy.dynamic_proxy_jdk_v2.service.MyService").getMethod("doSomething");
        } catch (NoSuchMethodException var2) {
            throw new NoSuchMethodError(var2.getMessage());
        } catch (ClassNotFoundException var3) {
            throw new NoClassDefFoundError(var3.getMessage());
        }
    }

    private static MethodHandles.Lookup proxyClassLookup(MethodHandles.Lookup var0) throws IllegalAccessException {
        if (var0.lookupClass() == Proxy.class && var0.hasFullPrivilegeAccess()) {
            return MethodHandles.lookup();
        } else {
            throw new IllegalAccessException(var0.toString());
        }
    }
}

```
可以更加清晰的看出

- $Proxy0在构造函数处传入了用户自定义的h
- $Proxy0的doSomething方法执行了h的invoke方法

以上就是由jvm拦截生成的Proxy0对doSomething方法进行代理的底层原理，真正起作用的是$Proxy0，对MyServiceImpl.java进行了增强