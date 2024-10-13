package org.lyflexi.proxy.dynamic_proxy_jdk_v3.proxy;

import java.lang.reflect.Proxy;

/**
 * mapper层接口的代理工厂，负责所有mapper层接口代理实例的生成
 * @param <T> 代理接口的类型，eg：UserMapper.cass
 */
public class MapperProxyFactory<T> {

    private final Class<T> mapperInterface;

    public MapperProxyFactory(Class<T> mapperInterface) {
        this.mapperInterface = mapperInterface;
    }

    /**
     * 支持指定接口的任意实现类
     *
     * 动态代理意味着返回的代理对象T，只有在运行时才最终确定
     * @param mapperProxy
     * @return
     */
    public T newInstance(MapperProxy<T> mapperProxy) {
        return (T) Proxy.newProxyInstance(this.mapperInterface.getClassLoader(), new Class[] {this.mapperInterface}, mapperProxy);
    }
}
