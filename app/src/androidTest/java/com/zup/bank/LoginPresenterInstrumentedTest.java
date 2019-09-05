package com.zup.bank;

import android.support.test.runner.AndroidJUnit4;

import com.zup.bank.Db.AppDbHelper;
import com.zup.bank.model.UserAccount;
import com.zup.bank.ui.login.LoginPresenter;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
public class LoginPresenterInstrumentedTest {

    @Test
    public void logarValido(){

        LoginPresenter presenter = new LoginPresenter(new AppDbHelper());
        UserAccount account = presenter.logar("user_test","Test@1");

        Assert.assertNotNull(account);
    }

    @Test
    public void logarInvalido(){

        LoginPresenter presenter = new LoginPresenter(new AppDbHelper());
        UserAccount account = presenter.logar("AAA","123");

        Assert.assertNull(account);
    }
}
