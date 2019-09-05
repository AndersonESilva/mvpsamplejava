package com.zup.bank.ui.login;


import com.zup.bank.model.UserAccount;
import com.zup.bank.ui.base.BaseMvpPresenter;

import javax.inject.Singleton;

public interface LoginMvpPresenter extends BaseMvpPresenter {

    UserAccount logar(String user, String password);
}
