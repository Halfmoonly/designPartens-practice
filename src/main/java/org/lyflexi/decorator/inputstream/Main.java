package org.lyflexi.decorator.inputstream;

import java.io.*;
import java.time.Instant;

/**
 * @Author: liuyanoutsee@outlook.com
 * @Date: 2025/4/13 0:12
 * @Project: designPartens-practice
 * @Version: 1.0.0
 * @Description:
 */
public class Main {
    /**
     * readFileTryCatch用时:1479毫秒
     * readFileTryWithResource用时:1441毫秒
     * optimizeDecorateByBuffer用时:8毫秒
     * @param args
     */
    public static void main(String[] args) {
        // 1. 创建一个文件对象
//        File file = new File("E:\\github\\designPartens-practice\\src\\main\\java\\org\\lyflexi\\decorator\\inputstream\\Halfmoonly.pdf");
        //直接写文件名，需要将文件放在根目录下
        File file = new File("Halfmoonly.pdf");
        readFileTryCatch(file);
        readFileTryWithResource(file);
        optimizeDecorateByBuffer(file);
        checkBufferedVsByteInput(file);
    }

    /**
     * 通过字节流来读取文件，计算耗时
     * <p>
     * try-catch 写法：
     * 手动管理资源：需要显式地创建和关闭资源（如 FileInputStream）。
     * 如果忘记关闭资源，可能会导致资源泄漏（如文件句柄未释放）。
     * 代码较为冗长，容易出错。
     *
     * @param file
     */
    private static void readFileTryCatch(File file) {
        FileInputStream fileInputStream = null;
        try {
            fileInputStream = new FileInputStream(file);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        long start = Instant.now().toEpochMilli();
        while (true) {
            try {
                //返回1个字节，大小是0~255，因为一个字节是8个11111111
                int read = fileInputStream.read();
                if (read == -1) {
                    break;
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("用时:" + (Instant.now().toEpochMilli() - start) + "毫秒");
    }

    /**
     * 通过字节流来读取文件，计算耗时
     * <p>
     * 自动管理资源：try-with-resources 会在 try 块执行完毕后自动关闭实现了 AutoCloseable 接口的资源（如 FileInputStream）。
     * 更简洁、安全：不需要显式调用 close() 方法，减少了资源泄漏的风险。
     * 推荐使用：这是 Java 7 引入的特性，现代 Java 开发中更常用。
     *
     * @param file
     */
    private static void readFileTryWithResource(File file) {
        long start = Instant.now().toEpochMilli();

        try (FileInputStream fileInputStream = new FileInputStream(file)) {
            while (true) {

                int read = fileInputStream.read();
                if (read == -1) {
                    break;
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        System.out.println("用时:" + (Instant.now().toEpochMilli() - start) + "毫秒");
    }

    /**
     * 通过装饰者模式来读取文件，提升性能
     *
     * @param file
     */
    private static void optimizeDecorateByBuffer(File file) {
        long start = Instant.now().toEpochMilli();

        try (InputStream bufferedFileInputStream = new BufferedFileInputStream(new FileInputStream(file))) {
            while (true) {

                int read = bufferedFileInputStream.read();
                if (read == -1) {
                    break;
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        System.out.println("用时:" + (Instant.now().toEpochMilli() - start) + "毫秒");
    }

    /**
     * 验证BufferedFileInputStream读到的数据，和原来比较笨的FileInputStream读取到的数据，有没有存在内容上的误差
     *
     * 如果该方法没有抛出异常，则证明二者读取数据内容无误
     * @param file
     */
    private static void checkBufferedVsByteInput(File file) {
        long start = Instant.now().toEpochMilli();

        try (InputStream bufferedFileInputStream = new BufferedFileInputStream(new FileInputStream(file))
        ; InputStream fileInputStream = new FileInputStream(file)) {
            while (true) {

                int read4Buffer = bufferedFileInputStream.read();
                int read4Byte = fileInputStream.read();
                if (read4Buffer !=read4Byte) {
                    throw new RuntimeException("二者读取数据存在内容上的误差");
                }
                if (read4Buffer == -1) {
                    break;
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        System.out.println("用时:" + (Instant.now().toEpochMilli() - start) + "毫秒");
    }
}
