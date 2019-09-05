package com.zup.bank.di.component;

import com.zup.bank.di.module.ActivityModule;
import com.zup.bank.ui.home.HomeActivity;
import com.zup.bank.ui.login.LoginActivity;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = ActivityModule.class)
public interface ActivityComponent {

    void inject(LoginActivity activity);

    void inject(HomeActivity activity);
}
