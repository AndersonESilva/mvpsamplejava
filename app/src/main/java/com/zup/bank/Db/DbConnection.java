package com.zup.bank.Db;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

import javax.inject.Singleton;

@Singleton
public class DbConnection implements DbHelperConnection {

    private HttpClient httpClient;
    private HttpPost httppost;
    private ArrayList<NameValuePair> postParameters;
    private String url;
    private String[] resposta;
    private HttpResponse response;
    private HttpGet httpGet;

    public DbConnection(){

    }

    @Override
    public String autenticacao(String user, String password) {

        try {

            url = "https://bank-app-test.herokuapp.com/api/login";

            httpClient = new DefaultHttpClient();
            httppost = new HttpPost(url);

            httppost.setHeader("Content-Type", "application/x-www-form-urlencoded");

            postParameters = new ArrayList<NameValuePair>();
            postParameters.add(new BasicNameValuePair("user", ""+user));
            postParameters.add(new BasicNameValuePair("password", ""+password));

            resposta = new String[2];

            httppost.setEntity(new UrlEncodedFormEntity(postParameters, "UTF-8"));

            response = httpClient.execute(httppost);

            if (response.getEntity() != null) {
                resposta[0] = String.valueOf(response.getStatusLine().getStatusCode());
                resposta[1] = getStringFromInputStream(response.getEntity().getContent());
            }

            return resposta[1];

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public String getStatements() {

        try {

            url = "https://bank-app-test.herokuapp.com/api/statements/1";

            httpClient = new DefaultHttpClient();
            httpGet = new HttpGet(url);
            resposta = new String[2];

            httpGet.addHeader("Content-Type","application/x-www-form-urlencoded");

            response = httpClient.execute(httpGet);
            if (response.getEntity() != null) {
                resposta[0] = getStringFromInputStream(response.getEntity().getContent());
            }

            return resposta[0];


        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }


    private static String getStringFromInputStream(InputStream stream) throws IOException {
        int n = 0;
        char[] buffer = new char[1024 * 4];
        InputStreamReader reader = new InputStreamReader(stream, "UTF8");
        StringWriter writer = new StringWriter();
        while (-1 != (n = reader.read(buffer)))
            writer.write(buffer, 0, n);
        return writer.toString();
    }
}
