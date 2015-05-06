/**
 * @author hayden
 */
package com.techsen.tsweb.util;

/**
 * 异常工具类
 */
public class ExceptionUtil {
    /**
     * 抛出RuntimeException
     */
    public static void throwRuntimeException(Exception e) throws RuntimeException {
        if (e instanceof RuntimeException) {
            throw (RuntimeException) e;
        } else {
            throw new RuntimeException(e.getMessage(), e);
        }
    }
}
