package com.ion_popescu.laborator2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.ion_popescu.laborator2.user.User;

public class Profile extends AppCompatActivity {
    private TextView email;
    private TextView password;
    private Button button;
    private User user;
    private void getParameters(){
        Bundle extras= getIntent().getExtras();
        try{
            user.setMail(extras.getString("email"));
            user.setPassword(extras.getString("password"));
        }catch (NullPointerException e){
            Log.e("Profile", "getParameters: ",e);
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        email=findViewById(R.id.email_textView);
        password=findViewById(R.id.password_length_textView);
        button=findViewById(R.id.button);
        user=new User();

        getParameters();

        email.setText(user.getMail());
        password.setText(String.valueOf(user.getPassword().length()));

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}