package com.zup.bank;

import android.support.test.runner.AndroidJUnit4;

import com.zup.bank.Db.AppDbHelper;
import com.zup.bank.model.Statement;
import com.zup.bank.ui.home.HomePresenter;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.List;

@RunWith(AndroidJUnit4.class)
public class HomePresenterInstrumentedTest {

    @Test
    public void qntdeItensEmLista(){

        HomePresenter presenter = new HomePresenter(new AppDbHelper());

        List<Statement> list = presenter.getStatement();

        Assert.assertEquals(list.size(),9);
    }
}
