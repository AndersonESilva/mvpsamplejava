package com.zup.bank.di.module;

import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.DefaultHttpClient;

import dagger.Module;
import dagger.Provides;

@Module
public class DbModule {

    @Provides
    public HttpClient provideHttpClient(){
        return new DefaultHttpClient();
    }

}
