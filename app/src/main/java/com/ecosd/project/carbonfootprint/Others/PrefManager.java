package com.ecosd.project.carbonfootprint.Others;

/**
 * Created by this pc on 12-04-17.
 */


import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

/**
 * Created by Ravi on 01/06/15.
 */
@SuppressLint("CommitPrefEdits")
public class PrefManager {
    // Shared Preferences
    SharedPreferences pref;

    // Editor for Shared preferences
    Editor editor;

    // Context
    Context _context;

    // Shared pref mode
    int PRIVATE_MODE = 0;


    // Shared pref file name
    private static final String PREF_NAME = "AndroidHive";

    // All Shared Preferences Keys
    private static final String IS_LOGIN = "IsLoggedIn";

    // Email address (make variable public to access from outside)
    public static final String KEY_EMAIL = "email";

    public static final String Event = "event";

    public static final String LOGIN = "login";


    // Constructor
    public PrefManager(Context context) {
        this._context = context;
        pref = _context.getSharedPreferences(PREF_NAME, PRIVATE_MODE);
        editor = pref.edit();


    }


    public void setLoginToken(String token) {

        editor.putString("Token", token);
        editor.commit();
    }

    public void setLName(String name) {

        editor.putString("name", name);
        editor.commit();
    }

    public void setLEmail(String email) {

        editor.putString("email", email);
        editor.commit();
    }

    public void setLanguages(String language) {

        editor.putString("language", language);
        editor.commit();
    }

    public void setAnswer(String answer) {

        editor.putString("answer", answer);
        editor.commit();
    }



    public String getLoginToken() {
        return pref.getString("Token", null);
    }

    public String getLName() {
        return pref.getString("name", null);
    }

    public String getLEmail() {
        return pref.getString("email", null);
    }

    public String getLanguages() {
        return pref.getString("language", null);
    }
    public String getAnswer() {
        return pref.getString("answer", null);
    }

}



