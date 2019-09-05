package com.zup.bank.ui.home;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonParser;
import com.zup.bank.Db.AppDbHelper;
import com.zup.bank.model.Statement;
import com.zup.bank.ui.base.BasePresenter;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

public class HomePresenter extends BasePresenter implements HomeMvpPresenter {

    @Inject
    public HomePresenter(AppDbHelper appDbHelper) {
        super(appDbHelper);
    }

    @Override
    public List<Statement> getStatement() {
        try {
            List<Statement> list = new ArrayList<>();
            Gson gson = new Gson();


            String response = getAppDbHelper().getStatements();
            JSONObject jsonObject = new JSONObject(response);

            JsonParser parser = new JsonParser();
            JsonArray jsonArray = parser.parse(jsonObject.getString("statementList")).getAsJsonArray();

            for(int i = 0; i < jsonArray.size(); i++){
                list.add(gson.fromJson(jsonArray.get(i), Statement.class));
            }

            return list;

        }catch (Exception e){
            e.printStackTrace();
        }

        return null;
    }
}
