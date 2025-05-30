package to.msn.wings.studyjava.chap01;

import java.io.IOException;
import java.io.Reader;

/**
 * Reads text from a character-input stream,
 * 
 * @see FileReader
 * @author Mark Reinhold
 * @since 1.1
 */

public class BufferedReader extends Reader {
    /**
     * Creates a buffering character-input stream that
     * 
     * @param in A Reader
     * @param sz Input-buffer size
     * @exception IllegalArgumentException If {@code sz <= 0}
     */


    public BufferedReader(Reader in, int sz) {

    }

    @Override
    public void close() throws IOException {

    }

    @Override
    public int read(char[] cbuf, int off, int len) throws IOException {
        return 0;
    }

    /**
     * Reads a single character.
     * 
     * @return The character read,...
     * @exception IOException if an I/O error occurs
     */

    public int read() throws IOException {
        return 0;
    }

}
