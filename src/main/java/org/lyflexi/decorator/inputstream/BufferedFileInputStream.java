package org.lyflexi.decorator.inputstream;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author gongxuanzhangmelt@gmail.com
 **/
public class BufferedFileInputStream extends InputStream {

    /**
     * 缓存大小 8192个字节
     */
    private final byte[] buffer = new byte[8192];

    /**
     * 读取缓存的指针
     */
    private int position = -1;

    /**
     * 可读取的缓存容量，为什么不直接用buffer.length呢？
     *
     * 因为有可能某次读取给buffer的字节数小于8192
     */
    private int capacity = -1;

    private final FileInputStream fileInputStream;

    public BufferedFileInputStream(FileInputStream fileInputStream) {
        this.fileInputStream = fileInputStream;
    }

    /**
     * 先将文件读取到缓存中
     *
     * 以后从缓存中依次读取每个字节，减少与IO的交互次数，提升读取性能
     * @return
     * @throws IOException
     */
    @Override
    public int read() throws IOException {
        if (buffCanRead()) {
            return readFromBuffer();
        }
        refreshBuffer();
        if (!buffCanRead()) {
            return -1;
        }
        return readFromBuffer();
    }

    /**
     * 每次从缓存中读取一个字节
     *
     * 但要注意byte类型是有符号的，所以这里要和0xFF进行与运算去掉可能的符号位，0X代表16进制 8个11111111，正好一个字节
     * @return
     */
    private int readFromBuffer() {
        return buffer[position++] & 0xFF;
    }

    /**
     * 一次性读取8192个字节到缓存中
     * @throws IOException
     */
    private void refreshBuffer() throws IOException {
        capacity = this.fileInputStream.read(buffer);
        position = 0;
    }


    /**
     * 判断当前缓存buffer是否可以读取
     * @return
     */
    private boolean buffCanRead() {
        if (capacity == -1) {
            return false;
        }
        if (position == capacity) {
            return false;
        }
        return true;
    }

    @Override
    public void close() throws IOException {
        this.fileInputStream.close();
    }
}
