package org.lyflexi.decorator.set;

import java.util.*;

/**
 * @author gongxuanzhangmelt@gmail.com
 *
 * This class is a decorator for the Set interface that keeps track of removed elements.该类是Set接口的装饰器，用于跟踪已删除的元素。
 *
 * 实现了Set接口的好处是自动生成常用的实现方法
 **/
public class HistorySet<E> implements Set<E> {

    List<E> removeList = new ArrayList<>();

    /**
     * 委派者，委派给用户传入的delegate来履行职责
     *
     * 这是组合模式的体现
     */
    private final Set<E> delegate;

    public HistorySet(Set<E> hashSet) {
        this.delegate = hashSet;
    }
    @Override
    public int size() {
        return delegate.size();
    }

    @Override
    public boolean isEmpty() {
        return delegate.isEmpty();
    }

    @Override
    public boolean contains(Object o) {
        return delegate.contains(o);
    }

    @Override
    public Iterator<E> iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return null;
    }

    @Override
    public boolean add(E e) {
        return delegate.add(e);
    }

    @Override
    public boolean remove(Object o) {
        if (delegate.remove(o)) {
            removeList.add((E) o);
            return true;
        }
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {

    }


    /**
     * 实现的toString方法,方便后续的打印查看
     * @return
     */
    @Override
    public String toString() {
        return delegate.toString() + " remove list : " + removeList;
    }
}
