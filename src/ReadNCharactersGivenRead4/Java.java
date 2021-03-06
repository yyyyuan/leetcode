/* The read4 API is defined in the parent class Reader4.
      int read4(char[] buf); */

public class Solution extends Reader4 {
    /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     */
    public int read(char[] buf, int n) {
       char[] buffer = new char[4];
       int readBytes = 0;
       while (readBytes < n) {
           int currReadBytes = read4(buffer);

           int length = Math.min(n-readBytes, currReadBytes);
           for (int i=0; i<length; i++) {
               buf[readBytes++] = buffer[i];
           }
           if (length < 4) return Math.min(readBytes, n);
       }
       
       return readBytes;
    }
}
