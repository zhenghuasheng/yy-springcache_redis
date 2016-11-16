package com.ac.pt.service;

/**
 * Created by Administrator on 2016/1/4.
 */

import com.ac.pt.model.Account;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;

public class AccountService {

    private static Account account = new Account();

    @Cacheable(value="commonCache")// 使用了一个缓存名叫 accountCache
    public Account getAccountByName(String userName) {
        // 方法内部实现不考虑缓存逻辑，直接实现业务
        System.out.println("real query account."+userName);
        return getFromDB(userName);
    }



    @CachePut(value="commonCache")// 更新accountCache 缓存 ,key="#account.getCacheKey()"
    public Account updateAccount(Account account) {
        return updateDB(account);
    }

    @CacheEvict(value="commonCache")// 清空accountCache 缓存
    public void updateAccount1(Account account) {
        updateDB(account);
    }


    private Account updateDB(Account a){
        System.out.println("update accout .....");
        account = a;
        return a;
    }


    private Account getFromDB(String acctName) {
        System.out.println("real querying db..."+acctName);
        account.setName(acctName);
        account.setId(1);
        return account;
    }
}
