package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import com.google.android.material.textfield.TextInputEditText;

public class LoginResultActivity extends AppCompatActivity {
    //이 또한 사용을 위한 전역변수 설정
    TextView textview_get;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textview_get=findViewById(R.id.textview_get);//뷰에서 연결할 텍스트 지정
        Intent intent = getIntent();

        Bundle bundle=intent.getExtras();//extras들을 모두 가져와서 하나씩 꺼내는 방식으로 진행
        String email=bundle.getString("email");
        String password=bundle.getString("password");

        textview_get.setText(email+" / "+password);
    }
}