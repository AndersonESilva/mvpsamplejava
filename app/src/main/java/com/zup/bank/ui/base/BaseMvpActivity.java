package com.zup.bank.ui.base;

import com.zup.bank.di.component.ActivityComponent;

import javax.inject.Singleton;

@Singleton
public interface BaseMvpActivity {

    public ActivityComponent getActivityComponent();
}
