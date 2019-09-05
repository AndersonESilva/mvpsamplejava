package com.zup.bank.Db;

import com.zup.bank.service.AsyncService;

import java.util.concurrent.ExecutionException;

public class AppDbHelper implements DbHelper {

    @Override
    public String auth(String user, String password) {
        String rtn;
        try {
            rtn = new AsyncService(0).execute(user,password).get();
            return rtn;
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public String getStatements() {
        try {

            return new AsyncService(1).execute().get();

        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
