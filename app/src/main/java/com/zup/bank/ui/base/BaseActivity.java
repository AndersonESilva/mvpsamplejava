package com.zup.bank.ui.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.zup.bank.di.component.ActivityComponent;
import com.zup.bank.di.component.DaggerActivityComponent;
import com.zup.bank.di.module.ActivityModule;

public abstract class BaseActivity extends AppCompatActivity implements BaseMvpActivity{

    private ActivityComponent activityComponent;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        activityComponent = DaggerActivityComponent
                            .builder()
                            .activityModule(new ActivityModule(this))
                            .build();

    }

    @Override
    public ActivityComponent getActivityComponent() {
        return activityComponent;
    }

}
