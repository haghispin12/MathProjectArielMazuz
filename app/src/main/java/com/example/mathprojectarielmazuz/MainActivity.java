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

    private Button etgar;
    private Button upto20;
    private Button luachKefel;
    private TextView num1;
    private TextView xmlX;
    private TextView num2;
    private EditText answer;
    private Button check;
    private Button save;
    private Button SAU;
    private Exercise exercise;
    private MainViewModel mainViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String userName= getIntent().getStringExtra("name");
        //String userName = getIntent().getStringExtra("","error");

        exercise = new Exercise();
        mainViewModel = new ViewModelProvider(this).get(MainViewModel.class);

        etgar = findViewById(R.id.etgar);
        etgar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mainViewModel.vEtgar();
                answer.setText("");
//                exercise.random3();
//                num1.setText(exercise.getNum1()+"");
//                num2.setText(exercise.getNum2()+"");

            }
        });

        upto20 = findViewById(R.id.upto20);
        upto20.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
              mainViewModel.vUp20();
              answer.setText("");
              //  exercise.random2();
              //  num1.setText(exercise.getNum1()+"");
              //  num2.setText(exercise.getNum2()+"");
            }
        });

        luachKefel = findViewById(R.id.luachKefel);
        luachKefel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               mainViewModel.vluachKefel();
               answer.setText("");
                // exercise.random1();
               // num1.setText(exercise.getNum1()+"");
               // num2.setText(exercise.getNum2()+"");
            }
        });

        num1 = findViewById(R.id.num1);
        num2 = findViewById(R.id.num2);
        xmlX = findViewById(R.id.xmlX);
        answer = findViewById(R.id.answer);
        
        check = findViewById(R.id.check);


      mainViewModel.vNum1.observe(this, new Observer<Integer>() {
          @Override
          public void onChanged(Integer integer) {

          }
      });


       mainViewModel.vNum2.observe(this, new Observer<Integer>() {
           @Override
           public void onChanged(Integer integer) {

           }
       });




        check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean bool = exercise.isGoodAnswer(answer.getText().toString());
                if (bool)
                    showCheck("Very good");
                else
                    showCheck("This is mistake, try again");
                answer.setText("");
                num2.setText("");
                num1.setText("");

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