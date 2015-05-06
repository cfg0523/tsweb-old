/**
 * @author hayden
 */
package com.techsen.tsweb.util;

import static com.techsen.tsweb.util.ExceptionUtil.throwRuntimeException;

import java.io.Closeable;
import java.io.IOException;

/**
 * 关闭资源的工具类
 */
public class CloseUtil {
    
    /**
     * 关闭资源
     */
    public static void close(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e) {
                throwRuntimeException(e);
            }
        }
    }
}
