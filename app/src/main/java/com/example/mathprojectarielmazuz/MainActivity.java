package com.example.mathprojectarielmazuz;

import android.content.Intent;
import android.os.Bundle;
//import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

public class MainActivity extends AppCompatActivity {

    private void showCheck (String s){
        Toast.makeText(getApplicationContext(), s, Toast.LENGTH_LONG).show();
    }

     Button rate;
     Button etgar;
     Button upto20;
     Button luachKefel;
     TextView num1;
     TextView xmlX;
     TextView num2;
     EditText answer;
     Button check;
     Button save;
     Button SAU;
     TextView name;
     TextView XMLscore;
     MainViewModel mainViewModel;
     int state = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rate = findViewById(R.id.rate);
        rate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        name = findViewById(R.id.name);
        String receivedText = getIntent().getStringExtra("name");
            // Display the received text
        name.setText(receivedText);

        XMLscore = findViewById(R.id.XMLscore);


        mainViewModel = new ViewModelProvider(this).get(MainViewModel.class);

        mainViewModel.vScore.observe(this, new Observer<Integer>() {
            @Override
            public void onChanged(Integer integer) {
                XMLscore.setText(integer+"");
            }
        });
        etgar = findViewById(R.id.etgar);
        etgar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mainViewModel.vEtgar();
                state = 3;
                answer.setText("");

//

            }
        });

        upto20 = findViewById(R.id.upto20);
        upto20.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              mainViewModel.vUp20();
              state = 2;
              answer.setText("");

            }
        });

        luachKefel = findViewById(R.id.luachKefel);
        luachKefel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               mainViewModel.vluachKefel();
               state = 1;
               answer.setText("");

            }
        });

        num1 = findViewById(R.id.num1);
        num2 = findViewById(R.id.num2);
        xmlX = findViewById(R.id.xmlX);
        answer = findViewById(R.id.answer);
        



      mainViewModel.vNum1.observe(this, new Observer<Integer>() {
          @Override
          public void onChanged(Integer integer) {
              num1.setText(integer+"");
          }
      });


       mainViewModel.vNum2.observe(this, new Observer<Integer>() {
           @Override
           public void onChanged(Integer integer) {
               num2.setText(integer+"");
           }
       });

        check = findViewById(R.id.check);
        check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String str = answer.getText().toString();

                boolean bool = mainViewModel.vCheck(str,state);
                if (bool)
                    showCheck("Very good");
                else
                    showCheck("This is mistake, try again");
                answer.setText("");
                num2.setText("");
                num1.setText("");



/*
                int sum1 = mainViewModel.vNum1.getValue();
                int sum2 = mainViewModel.vNum2.getValue();
                String Ans = sum1*sum2+"";

                boolean bool =*/
            }
        });
        
        save = findViewById(R.id.save);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                
            }
        });
        
        SAU = findViewById(R.id.SAU);
        SAU.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                
            }
        });




    }
}