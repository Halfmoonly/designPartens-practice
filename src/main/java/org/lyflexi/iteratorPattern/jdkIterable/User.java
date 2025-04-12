package org.lyflexi.iteratorPattern.jdkIterable;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @Author: liuyanoutsee@outlook.com
 * @Date: 2025/4/12 20:32
 * @Project: designPartens-practice
 * @Version: 1.0.0
 * @Description:
 */
@AllArgsConstructor
public class User {
    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    /**
     * 重写下toString方法，有助于打印
     * @return
     */
    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
