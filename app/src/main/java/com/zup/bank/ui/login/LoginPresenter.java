package com.zup.bank.ui.login;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.zup.bank.Db.AppDbHelper;
import com.zup.bank.model.UserAccount;
import com.zup.bank.ui.base.BasePresenter;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import javax.inject.Inject;

public class LoginPresenter extends BasePresenter implements LoginMvpPresenter {

    @Inject
    public LoginPresenter(AppDbHelper appDbHelper) {
        super(appDbHelper);
    }

    @Override
    public UserAccount logar(String user, String password) {
        try {

            ObjectMapper objectMapper = new ObjectMapper();

            String response = getAppDbHelper().auth(user,password);
            JSONObject jsonObject = new JSONObject(response);
            String jr = jsonObject.get("userAccount").toString();

            return objectMapper.readValue(jr, UserAccount.class);

        } catch (JSONException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }
}
