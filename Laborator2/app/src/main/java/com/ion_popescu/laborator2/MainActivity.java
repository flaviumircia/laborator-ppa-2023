package com.ion_popescu.laborator2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.ion_popescu.laborator2.user.User;

public class MainActivity extends AppCompatActivity {
    private EditText email;
    private EditText password;
    private Button button;
    private User user;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        email=findViewById(R.id.mail_editText);
        password=findViewById(R.id.password_editText);
        button=findViewById(R.id.sign_up_button);
        user=new User();
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                user.setMail(email.getText().toString());
                user.setPassword(password.getText().toString());

                Intent intent=new Intent(getApplicationContext(),Profile.class);

                intent.putExtra("email",user.getMail());
                intent.putExtra("password",user.getPassword());

                startActivity(intent);
            }
        });
    }
}