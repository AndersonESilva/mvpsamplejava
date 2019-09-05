package com.zup.bank.ui.home;

import com.zup.bank.model.Statement;
import com.zup.bank.ui.base.BaseMvpPresenter;

import java.util.List;

public interface HomeMvpPresenter extends BaseMvpPresenter {

    List<Statement> getStatement();
}
