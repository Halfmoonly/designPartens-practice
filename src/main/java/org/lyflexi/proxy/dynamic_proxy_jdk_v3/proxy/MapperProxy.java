package org.lyflexi.proxy.dynamic_proxy_jdk_v3.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 代理逻辑实现
 */

public class MapperProxy<T> implements InvocationHandler {

    private final T target;

    public MapperProxy(T target) {
        this.target = target;
    }

    /**
     *
     * @param proxy     代理类自身，链式编程的情况下会用到
     * @param method    目标方法
     * @param args      目标方法参数
     * @return          数据库执行结果
     * @throws Throwable
     */
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("proxy:"+proxy.getClass().getName());
        // TODO 一些其他的处理
        return execute(method, args);
    }

    /**
     * mapper真正的数据操作，可参考的mybatis MapperProxy中invoke方法的做法 ：
     *      final MapperMethod mapperMethod = cachedMapperMethod(method);
     *      return mapperMethod.execute(sqlSession, args);
     * @param args
     * @return      数据库执行结果
     */
    public Object execute(Method method, Object[] args) {

        try {
            //处理Object原生的方法
            if(method.getDeclaringClass().equals(Object.class)) {
                return method.invoke(this, args);
            }
            System.out.println("通过反射解析mapper接口方法上使用注解标注的sql, 并获取执行结果...");
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
        return null;
    }
}