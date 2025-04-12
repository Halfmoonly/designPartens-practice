package org.lyflexi.iteratorPattern.jdkIterable;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

/**
 * @Author: liuyanoutsee@outlook.com
 * @Date: 2025/4/12 20:35
 * @Project: designPartens-practice
 * @Version: 1.0.0
 * @Description:
 */
public class Main {
    public static void main(String[] args) {
        File file = new File("E:\\github\\designPartens-practice\\src\\main\\java\\org\\lyflexi\\iteratorPattern\\jdkIterable\\inputusers.txt");
        List<User> list = new ArrayList<>();
        //readUsers
        readUsers(file,list);
        for (User user : list) {
            System.out.println(user);
        }

        System.out.println("---------------------------------------------------------------------------------------------");

        //readUsersWithLambda
        readUsersWithLambda(file,(user -> {
            System.out.println(user);
            list.add(user);
        }));

        //readUsersWithIterable
        System.out.println("---------------------------------------------------------------------------------------------");
        FileUserIterable users = new FileUserIterable(file);
        for (User user : users) {
            System.out.println(user);
        }
    }

    /**
     * 重构前的代码
     * @param file
     */
    private static void readUsers(File file,List<User> list) {
        List<String> lines = List.of();
        // 遍历文件对象
        try {
            lines = Files.readAllLines(file.toPath(), StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (String line : lines) {
            String userStr = line.substring(1, line.length() - 1);
            String[] split = userStr.split(",");
            User user = new User(split[0], Integer.parseInt(split[1]));
            list.add(user);
        }
    }
    /**
     * 重构前的代码
     * @param file
     */
    private static void readUsersWithLambda(File file, Consumer<User> consumer) {
        List<String> lines = List.of();
        // 遍历文件对象
        try {
            lines = Files.readAllLines(file.toPath(), StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
        }
        for (String line : lines) {
            String userStr = line.substring(1, line.length() - 1);
            String[] split = userStr.split(",");
            User user = new User(split[0], Integer.parseInt(split[1]));
            consumer.accept(user);
        }
    }
}
