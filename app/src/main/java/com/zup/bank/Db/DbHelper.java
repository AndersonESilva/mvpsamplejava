package com.zup.bank.Db;


public interface DbHelper {

    String auth(String user, String password);

    String getStatements();
}
