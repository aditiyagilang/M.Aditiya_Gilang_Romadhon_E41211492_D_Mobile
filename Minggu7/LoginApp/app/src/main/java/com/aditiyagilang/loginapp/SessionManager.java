package com.aditiyagilang.loginapp;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import java.util.HashMap;

public class SessionManager {

    private Context _context;
    private SharedPreferences sharedPreferences;

    private SharedPreferences.Editor editor;

    public static final String ISLOGIN = "islogin" ;
    public static final String PASSWORD = "token";
    public static final String USERNAME = "username";

    public SessionManager(Context context){
        this._context = context;
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context);
        editor = sharedPreferences.edit();
    }

    public void createLoginSession(String username, String password){
        editor.putBoolean(ISLOGIN, true);
        editor.putString(USERNAME, username);
        editor.putString(PASSWORD, password);
        editor.apply();
    }

    public HashMap<String, String> getUserDetail(){
        HashMap<String,String> user = new HashMap<>();
        user.put(PASSWORD, sharedPreferences.getString(PASSWORD,null));
        user.put(USERNAME, sharedPreferences.getString(USERNAME, null));
        return user;
    }

    public void logoutSession(){
        editor.clear();
        editor.commit();
    }

    public boolean isLogin(){
        return sharedPreferences.getBoolean(ISLOGIN, false);
    }
}
