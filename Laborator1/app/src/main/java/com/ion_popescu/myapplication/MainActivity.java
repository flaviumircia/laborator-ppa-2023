package com.ion_popescu.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.ion_popescu.myapplication.animals.Animal;
import com.ion_popescu.myapplication.animals.Dog;

public class MainActivity extends AppCompatActivity {

    private TextView name_textview;
    private EditText name_edittext;
    private Button send_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name_edittext=findViewById(R.id.name_edittext);
        name_textview=findViewById(R.id.name_textview);
        send_button=findViewById(R.id.button);

        send_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Animal dog=new Dog();
                dog.setName(name_edittext.getText().toString());
                name_textview.setText(dog.getName());
            }
        });

    }
}