package com.zup.bank.ui.base;

import com.zup.bank.Db.AppDbHelper;

import javax.inject.Inject;

public class BasePresenter implements BaseMvpPresenter{

    private final AppDbHelper appDbHelper;

    @Inject
    public BasePresenter(AppDbHelper appDbHelper){
        this.appDbHelper = appDbHelper;
    }


    @Override
    public AppDbHelper getAppDbHelper(){
        return this.appDbHelper;
    }
}
