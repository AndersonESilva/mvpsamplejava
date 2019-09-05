package com.zup.bank.ui.base;

import com.zup.bank.Db.AppDbHelper;

import javax.inject.Singleton;

@Singleton
public interface BaseMvpPresenter{

    public AppDbHelper getAppDbHelper();
}
