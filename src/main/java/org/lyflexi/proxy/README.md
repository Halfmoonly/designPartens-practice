
静态代理具有局限性，一个静态代理只能代理一种目标接口，就像代理类LawsuitInterfaceProxy只能代理ILawsuit接口，假如以后有新的接口IOther,则必须创建新的代理类OtherInterfaceProxy

动态代理可以做到1套代理逻辑，适配无限种不同的接口进行增强
- JDK的动态代理是在运行时生效，编译期无法确定具体的目标对象类型，因此可以做到1份代理逻辑，适配多种不同的目标接口（这就是mapper的实现方式），而这些接口之间没有继承关系，更加具备通用性和灵活性。
- JDK的动态代理必须实现InvocationHandler接口完成代理业务逻辑的处理；如果自定义的InvocationHandler逻辑内含有menthod.invoke(target,args)逻辑，则目标对象类型必须与目标接口类型一致
- 动态生成的代理类字节码是由JVM在运行时在内存中自动生成的，通常不会直接以源代码的形式出现。不过，我们可以使用一些工具来反编译生成的字节码文件，以查看动态生成的代理类的结构。