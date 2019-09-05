package com.zup.bank.ui.login;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.zup.bank.R;
import com.zup.bank.di.component.ActivityComponent;
import com.zup.bank.model.UserAccount;
import com.zup.bank.ui.base.BaseActivity;
import com.zup.bank.ui.home.HomeActivity;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import dagger.android.DaggerActivity;

public class LoginActivity extends BaseActivity {

    @Bind(R.id.edtUser)
    EditText edtUser;

    @Bind(R.id.edtPassword)
    EditText edtPassword;

    @Bind(R.id.text_error)
    TextView text_error;

    @Inject
    LoginMvpPresenter loginMvpPresenter;

    private UserAccount userAccount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);

        getActivityComponent().inject(this);
    }

    @OnClick(R.id.btnLogin)
    void onClickLogin(View view){
        userAccount = loginMvpPresenter.logar(edtUser.getText().toString(),edtPassword.getText().toString());

        if(userAccount.getName() == null){
            text_error.setVisibility(View.VISIBLE);
        }else{
            Intent intent = new Intent(this, HomeActivity.class);
            intent.putExtra("user", userAccount);
            startActivity(intent);
            finish();
        }
    }

}
