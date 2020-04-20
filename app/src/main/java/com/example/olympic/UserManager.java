package com.example.olympic;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;

public class UserManager {
    private final String KEY_PREFS = "prefs_user";
    private final String KEY_USERNAME = "username";
    private final String KEY_PASSWORD = "password";
    private final String KEY_CARD_NUMBER = "card_number";

    private SharedPreferences var_Prefs;
    private SharedPreferences.Editor var_Editer;

    public UserManager(Context context){
        var_Prefs = context.getSharedPreferences(KEY_PREFS, Context.MODE_PRIVATE);
        var_Editer = var_Prefs.edit();
    }


    public boolean checkLoginValidate(String username,String password){
        String real_username = var_Prefs.getString(KEY_USERNAME,"");
        String real_password = var_Prefs.getString(KEY_PASSWORD,"");

        boolean input_empty = TextUtils.isEmpty(username) || TextUtils.isEmpty(password);
        if((!input_empty) && username.equals(real_username) && password.equals(real_password)){
            return true;
        }
        return false;
    }

    public boolean registerUser(String username,String password,String card_number){
        if(TextUtils.isEmpty(username) || TextUtils.isEmpty(password)){
            return false;
        }

        var_Editer.putString(KEY_USERNAME,username);
        var_Editer.putString(KEY_PASSWORD,password);
        var_Editer.putString(KEY_CARD_NUMBER,card_number);
        return var_Editer.commit();
    }
    public String getCardNumber(){
        String realCardNumber = var_Prefs.getString(KEY_CARD_NUMBER,"");
        return realCardNumber;
    }
}
