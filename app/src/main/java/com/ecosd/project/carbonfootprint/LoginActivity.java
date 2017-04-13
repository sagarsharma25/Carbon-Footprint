package com.ecosd.project.carbonfootprint;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.ecosd.project.carbonfootprint.Others.PrefManager;
import com.ecosd.project.carbonfootprint.Others.UserDHelper;

import Models.UserModel;

/**
 * Created by this pc on 11-04-17.
 */

public class LoginActivity extends AppCompatActivity{

    EditText username,password;
    TextView signin,signup;
    UserDHelper db;
    PrefManager pref;
    UserModel us;


    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        db=new UserDHelper(this);
        pref=new PrefManager(getApplicationContext());
        username=(EditText)findViewById(R.id.username);
        password=(EditText)findViewById(R.id.password);
        signin=(TextView)findViewById(R.id.signIn);
        signup=(TextView)findViewById(R.id.SignUpp);
        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!username.getText().toString().equals("")&&!password.getText().toString().equals(""))
                {
                    us=db.getContact(password.getText().toString());
                }
                    if(us!=null)
                    {
                        pref.setLoginToken("1");
                        pref.setLName(username.getText().toString().substring(0,1).toUpperCase()+username.getText().toString().substring(1));
                        pref.setLEmail(us.getEmailid());
                    }
                    else
                    {
                        pref.setLoginToken("");
                        Toast.makeText(getApplicationContext(),"Login Failed",Toast.LENGTH_LONG).show();
                    }

                startActivity(new Intent(LoginActivity.this,MainActivity.class));
                finish();
            }
        });

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LoginActivity.this,SignUp.class));
                finish();
            }
        });

    }
}
