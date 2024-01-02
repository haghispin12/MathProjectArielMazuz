package com.example.mathprojectarielmazuz;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity2 extends AppCompatActivity {

     EditText userName;
     Button next;
     Intent intent;


    public EditText getUserName() {
        return userName;
    }

    public void setUserName(EditText userName) {
        this.userName = userName;
    }

    public Button getNext() {
        return next;
    }

    public void setNext(Button next) {
        this.next = next;
    }

    @Override
    public Intent getIntent() {
        return intent;
    }

    @Override
    public void setIntent(Intent intent) {
        this.intent = intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login2);


        userName = findViewById(R.id.userName);

        next = findViewById(R.id.next);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String enteredText = userName.getText().toString();

                Intent intent = new Intent(LoginActivity2.this, MainActivity.class);
                intent.putExtra("name", enteredText);
                startActivity(intent);
                finish();

            }
        });




    }




}