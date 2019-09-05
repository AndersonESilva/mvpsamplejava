package com.zup.bank.di.module;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;

import com.zup.bank.Db.AppDbHelper;
import com.zup.bank.di.ActivityContext;
import com.zup.bank.ui.home.HomeMvpPresenter;
import com.zup.bank.ui.home.HomePresenter;
import com.zup.bank.ui.login.LoginMvpPresenter;
import com.zup.bank.ui.login.LoginPresenter;

import javax.inject.Inject;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class ActivityModule {

    private AppCompatActivity activity;

    public ActivityModule(AppCompatActivity activity){
        this.activity = activity;
    }

    @Provides
    @ActivityContext
    Context provideContext() {
        return activity;
    }

    @Provides
    @Singleton
    LoginMvpPresenter provideLoginMvpPresenter(LoginPresenter presenter){
        return presenter;
    }

    @Provides
    @Singleton
    HomeMvpPresenter provideHomeMvpPresenter(HomePresenter presenter){
        return presenter;
    }

    @Provides
    AppDbHelper provideAppDbHelper(){
        return new AppDbHelper();
    }

}
