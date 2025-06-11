package to.msn.wings.studyjava.chap08;

import java.io.Closeable;
import java.io.Flushable;
import java.io.IOException;

public abstract class Writer implements Appendable, Closeable, Flushable {

    // public void write(int c) throws IOException {
    // synchronized (lock) {
    // if (writeBuffer == null) {
    // writeBuffer = new char[WRITE_BUFFER_SIZE];
    // }
    // writeBuffer[0] = (char) c;
    // write(writeBuffer, 0, 1);
    // }
    // }

    public void write(char cbuf[]) throws IOException {
        write(cbuf, 0, cbuf.length);
    }

    // 個々の実装は派生クラスにゆだねる（抽象メソッド）
    public abstract void write(char cbuf[], int off, int len) throws IOException;
}