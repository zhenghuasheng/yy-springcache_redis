package com.ac.pt.service;

import com.ac.pt.model.Account;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhenghuasheng on 2016/5/26.
 */
public class SynThread extends Thread {

    private List<Account> list = new ArrayList();

    public List getList() {
        return list;
    }

    public void setList(List list) {
        this.list = list;
    }

    public SynThread(List<Account> list) {
        this.list = list;
    }

    public boolean addToList(Account account){
        list.add(account);
        return true;
    }

    @Override
    public void run() {
        for (Account account : list){
            System.out.println(account);
        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
