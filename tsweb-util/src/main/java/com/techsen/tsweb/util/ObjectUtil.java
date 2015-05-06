/**
 * @author hayden
 */
package com.techsen.tsweb.util;

import static com.techsen.tsweb.util.ExceptionUtil.throwRuntimeException;
import static com.techsen.tsweb.util.ValidUtil.isValid;

import java.lang.reflect.Field;

public class ObjectUtil {

    /**
     * 将obj对象转换成一种类似JSON的字符串
     */
    public static String toString(Object obj) {
        if (obj == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        try {
            Class<?> clazz = obj.getClass();
            sb.append(clazz.getSimpleName()).append("[");
            Field[] fields = clazz.getDeclaredFields();
            if (isValid(fields)) {
                Field field = fields[0];
                field.setAccessible(true);
                sb.append(field.getName()).append("=").append(field.get(obj));
                if (fields.length > 1) {
                    for (int i = 1; i < fields.length; i++) {
                        field = fields[i];
                        field.setAccessible(true);
                        sb.append(", ").append(field.getName()).append("=")
                                .append(field.get(obj));
                    }
                }
            }
            sb.append("]");
        } catch (Exception e) {
            throwRuntimeException(e);
        }
        return sb.toString();
    }

}
