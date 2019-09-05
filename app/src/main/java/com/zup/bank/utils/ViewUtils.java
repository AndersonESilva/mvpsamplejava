package com.zup.bank.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public final class ViewUtils {

    public static String formatarConta(String ba, String ag){

        String aux = ba + " / " + ag.charAt(0) + ag.charAt(1)
                + "." + ag.charAt(2) + ag.charAt(3) + ag.charAt(4) + ag.charAt(5)
                + ag.charAt(6) + ag.charAt(7) + "-" + ag.charAt(8);

        return aux;
    }

    public static String formatarDataBr(String data){
        try {

            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            Date date = formatter.parse(data);
            formatter = new SimpleDateFormat("dd//MM/yyyy");

            return formatter.format(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }
}
