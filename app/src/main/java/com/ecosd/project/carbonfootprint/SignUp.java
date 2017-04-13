package com.ecosd.project.carbonfootprint;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.ecosd.project.carbonfootprint.Others.UserDHelper;

import Models.UserModel;

/**
 * Created by this pc on 11-04-17.
 */

public class SignUp extends AppCompatActivity {

    EditText username,password,confpassword,emailid;
    TextView signup,signIn;
    UserDHelper db;

    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        db = new UserDHelper(this);
        username=(EditText)findViewById(R.id.username);
        password=(EditText)findViewById(R.id.password);
        confpassword=(EditText)findViewById(R.id.confirm_password);
        emailid=(EditText)findViewById(R.id.emailid);
        signup=(TextView) findViewById(R.id.signUp);
        signIn=(TextView)findViewById(R.id.SignInn);
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if((!username.getText().toString().equals(""))&&(!password.getText().toString().equals(""))&&(!confpassword.getText().toString().equals(""))&&(!emailid.getText().toString().equals("")))
                {
                    if(password.getText().toString().equals(confpassword.getText().toString())){
                        db.addContact(new UserModel(username.getText().toString(),password.getText().toString(),emailid.getText().toString()));

                    }
                }
                Log.e("Doneeeeeeeeee",db.getContactsCount()+"");
                username.setText("");
                password.setText("");
                confpassword.setText("");
                emailid.setText("");
            }
        });

        signIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SignUp.this,LoginActivity.class));
                finish();
            }
        });



    }
}
