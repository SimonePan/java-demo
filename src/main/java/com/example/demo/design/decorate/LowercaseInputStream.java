package com.example.demo.design.decorate;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * @description: 小写格式转换输入流
 * @author: Grace.Pan
 * @create: 2020-03-17 14:36
 */
public class LowercaseInputStream extends FilterInputStream {
    /**
     * Creates a <code>FilterInputStream</code>
     * by assigning the  argument <code>in</code>
     * to the field <code>this.in</code> so as
     * to remember it for later use.
     *
     * @param in the underlying input stream, or <code>null</code> if
     *           this instance is to be created without an underlying stream.
     */
    protected LowercaseInputStream(InputStream in) {
        super(in);
    }

    @Override
    public int read() throws IOException {
        int read = super.read();
        return read == -1 ? read : Character.toLowerCase(read);
    }

    @Override
    public int read(byte[] b) throws IOException {
        return this.read(b, 0, b.length);
    }

    @Override
    public int read(byte[] b, int off, int len) throws IOException {
        int read = super.read(b, off, len);
        if (read == -1) {
            return -1;
        }
        for (int i = off; i < off + read; i++) {
            b[i] = (byte) Character.toLowerCase((char) b[i]);
        }
        return read;

    }

}
