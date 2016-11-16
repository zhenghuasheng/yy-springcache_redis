package com.ac.pt.service;

import org.apache.log4j.PropertyConfigurator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import java.io.IOException;

/**
 * Created by Administrator on 2016/1/4.
 */
public class Launcher {
    public static final String SPRING_CONFIG_PATH = "/config/spring-config.xml";
    public static final String LOG4J_CONFIG_PATH = "/config/log4j.properties";
    private static Logger logger = LoggerFactory.getLogger(Launcher.class);
    public static ApplicationContext appContext = null;

    static {
        String path = System.getProperty("user.dir");
        PropertyConfigurator.configure(path + LOG4J_CONFIG_PATH);
        logger.info("path:{}",path);
    }

    public Launcher() {
    }

    public static void main(String[] args) {
        if (start()) {
            try {
              System.in.read();
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }

        }
    }

    public static boolean start() {

        try {
            appContext = new FileSystemXmlApplicationContext(new String[]{SPRING_CONFIG_PATH});

            logger.info("<-------------SERVICE平台服务启动成功-------------->");
            return true;
        } catch (Exception e) {
            logger.error("平台Service接口服务启动失败，错误：" + e.getMessage());
            return false;
        }
    }
}
