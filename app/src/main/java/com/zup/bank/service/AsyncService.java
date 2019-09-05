package com.zup.bank.service;

import android.os.AsyncTask;

import com.zup.bank.Db.DbConnection;

public class AsyncService extends AsyncTask<String, Void, String> {

    private int opcao;

    public AsyncService(int opcao){
        this.opcao = opcao;
    }

    @Override
    protected String doInBackground(String... strings) {

        switch (opcao){
            case 0:{
                String result = new DbConnection().autenticacao(strings[0],strings[1]);
                return result;
            }
            case 1:{
                String result = new DbConnection().getStatements();
                return result;
            }
        }

        return null;
    }
}
