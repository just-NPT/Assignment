package com.example.test;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText name = findViewById(R.id.Name);
        EditText mssv = findViewById(R.id.MSSV);
        EditText birth = findViewById(R.id.BirthDate);
        EditText sex = findViewById(R.id.Sex);
        EditText address = findViewById(R.id.Address);
        EditText phone = findViewById(R.id.PhoneNumber);
        EditText email = findViewById(R.id.EmailAddress);
        CheckBox thethao = findViewById(R.id.checkBox);
        CheckBox dulich = findViewById(R.id.checkBox2);
        CheckBox amnhac = findViewById(R.id.checkBox3);
        Button submit = findViewById(R.id.button);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(name.getText().toString().length() == 0 || mssv.getText().toString().length() == 0 || birth.getText().toString().length() == 0 || email.getText().toString().length() == 0) {
                    Toast toast = Toast.makeText(MainActivity.this,"Lam on dien du thong tin",Toast.LENGTH_SHORT);
                    toast.show();
                }
            }
        });
    }
}