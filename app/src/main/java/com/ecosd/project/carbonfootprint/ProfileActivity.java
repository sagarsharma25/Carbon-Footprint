package com.ecosd.project.carbonfootprint;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.ecosd.project.carbonfootprint.Others.PrefManager;

/**
 * Created by this pc on 11-04-17.
 */

public class ProfileActivity extends AppCompatActivity {


    TextView logout,challange;
    PrefManager prefManager;
    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        prefManager=new PrefManager(getApplicationContext());
        logout=(TextView)findViewById(R.id.Logout);
        challange=(TextView)findViewById(R.id.challange);
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                prefManager.setLoginToken(null);
                startActivity(new Intent(ProfileActivity.this,MainActivity.class));
                finish();
            }
        });

        challange.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ProfileActivity.this,ChallangeActivity.class));
                finish();
            }
        });
    }
}
