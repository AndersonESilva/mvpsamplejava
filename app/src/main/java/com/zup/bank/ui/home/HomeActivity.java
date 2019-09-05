package com.zup.bank.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.zup.bank.R;
import com.zup.bank.model.Statement;
import com.zup.bank.model.UserAccount;
import com.zup.bank.ui.adapter.StatementListAdapter;
import com.zup.bank.ui.base.BaseActivity;
import com.zup.bank.ui.login.LoginActivity;

import java.util.List;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

import static com.zup.bank.utils.ViewUtils.formatarConta;

public class HomeActivity extends BaseActivity {

    @Bind(R.id.text_nome)
    TextView text_nome;

    @Bind(R.id.text_conta)
    TextView text_conta;

    @Bind(R.id.text_saldo)
    TextView text_saldo;

    @Bind(R.id.recycler_)
    RecyclerView recycler_;

    @Inject
    HomeMvpPresenter homeMvpPresenter;

    private UserAccount userAccount;
    private List<Statement> statementList;
    private StatementListAdapter statementListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ButterKnife.bind(this);

        getActivityComponent().inject(this);

        userAccount = (UserAccount) getIntent().getSerializableExtra("user");

        statementList = homeMvpPresenter.getStatement();
    }

    @Override
    protected void onStart() {
        super.onStart();

        statementListAdapter = new StatementListAdapter(statementList, getBaseContext());

        recycler_.setHasFixedSize(true);
        recycler_.setLayoutManager(new LinearLayoutManager(getBaseContext()));
        recycler_.setItemAnimator(new DefaultItemAnimator());
        recycler_.setAdapter(statementListAdapter);

        text_nome.setText(userAccount.getName());
        text_conta.setText(formatarConta(userAccount.getBankAccount(), userAccount.getAgency()));
        text_saldo.setText("R$" + userAccount.getBalance());

    }

    @OnClick(R.id.img_back)
    void onClickBack(View view){

        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
        finish();
    }


}
