package com.zup.bank.Db;

public interface DbHelperConnection {

    String autenticacao(String user, String password);

    String getStatements();
}
