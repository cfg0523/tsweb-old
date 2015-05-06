/**
 * @author hayden
 */
package com.techsen.tsweb.web;

import static com.techsen.tsweb.util.CloseUtil.close;
import static com.techsen.tsweb.util.ExceptionUtil.throwRuntimeException;
import static com.techsen.tsweb.util.Log4jUtil.getLogger;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.net.URLDecoder;
import java.util.Properties;

import org.apache.log4j.Logger;

/**
 * 读取tsweb.properties配置工具类
 */
public class AppConfig {
    private static Logger logger = getLogger(AppConfig.class);

    private static Properties props = new Properties();
    private static String PROPERTIES_FILENAME = "tsweb.properties";
    
    /**
     * 用来在运行时判断是否重新加载tsweb.properties中的配置
     */
    private static boolean reload = false;
    
    /**
     * 上一次加载tsweb.properties时的文件的修改时间
     */
    private static long lastModified = -1L;

    static {
        loadConfig();
        reload = "true".equals(props.getProperty("reload"));
        if (reload) {
            logger.info("dynamic load " + PROPERTIES_FILENAME + ": " + reload);
        }
    }

    /**
     * 加载tsweb.properties中的配置
     */
    private static void loadConfig() {
        InputStream inputStream = null;
        try {
            String filepath = URLDecoder.decode(AppConfig.class
                    .getClassLoader().getResource(PROPERTIES_FILENAME)
                    .getFile(), "utf-8");
            File file = new File(filepath);
            inputStream = new FileInputStream(filepath);
            if (file.lastModified() > lastModified) {
                props.load(inputStream);
                lastModified = file.lastModified();
                logger.info("load [" + PROPERTIES_FILENAME + "] success");
            }
        } catch (Exception e) {
            logger.fatal("load [" + PROPERTIES_FILENAME + "] failure");
            throwRuntimeException(e);
        } finally {
            close(inputStream);
        }
    }

    /**
     * 获取属性值
     */
    public static String getProperty(String key) {
        if (reload) {
            loadConfig();
        }
        props.setProperty("reload", String.valueOf(reload));
        return props.getProperty(key);
    }

    /**
     * 获取Integer值
     */
    public static Integer getInteger(String key) {
        return Integer.valueOf(getProperty(key));
    }
    
    /**
     * 获取Double值
     */
    public static Double getDouble(String key) {
        return Double.valueOf(getProperty(key));
    }
    
    /**
     * 获取Boolean值
     */
    public static Boolean getBoolean(String key) {
        return Boolean.valueOf(getProperty(key));
    }
    
    /**
     * 用来在运行时改变系统是否启用动态加载tsweb.properties功能
     */
    public static void setReaload(boolean reload) {
        AppConfig.reload = reload;
        logger.info("dynamic load " + PROPERTIES_FILENAME + ": " + reload);
    }

}
