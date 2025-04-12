package org.lyflexi.iteratorPattern.jdkIterable;

import java.io.File;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @Author: liuyanoutsee@outlook.com
 * @Date: 2025/4/12 20:31
 * @Project: designPartens-practice
 * @Version: 1.0.0
 * @Description: 可迭代器的实现
 */
public class FileUserIterable implements Iterable<User> {

    private final File file;
    /**
     * 传入文件对象
     * @param file
     */
    public FileUserIterable(File file) {
        this.file = file;
    }


    /**
     * 注意区分可迭代的“Iterable“ vs 迭代器"Iterator"
     * @return
     */
    @Override
    public Iterator<User> iterator() {
        return new FileIter();
    }

    /**
     * 内部类：迭代器
     */
    class FileIter implements Iterator<User> {
        private List<User> users = new ArrayList<>();

        int cursor;       // index of next element to return

        public FileIter() {
            loadFile();
        }
        private void loadFile(){
            List<String> lines = new ArrayList<>();
            try {
                lines = Files.readAllLines(file.toPath());
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            for (String line : lines) {
                String userStr = line.substring(1, line.length() - 1);
                String[] split = userStr.split(",");
                User user = new User(split[0], Integer.parseInt(split[1]));
                users.add(user);
            }
        }

        @Override
        public boolean hasNext() {
            return cursor != users.size();
        }

        @Override
        public User next() {
            if (cursor>=users.size()){
                throw new IndexOutOfBoundsException("没有更多的元素了");
            }
            int i = cursor;
            cursor++;
            return users.get(i);
        }
    }
}
