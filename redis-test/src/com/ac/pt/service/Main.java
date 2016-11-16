package com.ac.pt.service;


import com.ac.pt.model.Account;
import org.apache.log4j.PropertyConfigurator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import java.math.BigDecimal;
import java.util.Random;

/**
 * Created by zhenghuasheng on 2016/5/9.
 */
public class Main {
    public static final String LOG4J_CONFIG_PATH = "/config/log4j.properties";
    private static Logger logger = LoggerFactory.getLogger(Launcher.class);
    private static String path = null;
    static {
        path= System.getProperty("user.dir");
        PropertyConfigurator.configure(path + LOG4J_CONFIG_PATH);
    }
    public static void main(String[] args) {
//        ApplicationContext context = new FileSystemXmlApplicationContext(path+"/config/spring-config.xml");
//        AccountService service = context.getBean(AccountService.class);
//
//        Account account = service.getAccountByName("zhenghuasheng");
//        System.out.println(account);
//
////        account = new Account(222,"zhenghuasheng");
////        service.updateAccount(account);
////
////        account = service.getAccountByName("zhenghuasheng");
////        System.out.println(account);
        Double totalPrice = 0.1 * 100;
        Integer totalNum = 10;

        int temp = 0;
        Random random = new Random();
        for (int i = 1;i<totalNum;i++ ){
            int price = 0;
            if (totalPrice.intValue() == totalNum) {
                price = (int) (totalPrice/totalNum);
                System.out.println(new BigDecimal(new Double(price)/100).setScale(2,BigDecimal.ROUND_HALF_UP).doubleValue());

            }else {
                price = random.nextInt(totalPrice.intValue() - totalNum - temp);
                temp = temp + price;
                System.out.println(new BigDecimal(new Double(price + 1)/100).setScale(2,BigDecimal.ROUND_HALF_UP).doubleValue());
            }


        }
        System.out.println(new BigDecimal((totalPrice-totalNum-temp + 1 )/100).setScale(2,BigDecimal.ROUND_HALF_UP).doubleValue() );
    }
}
