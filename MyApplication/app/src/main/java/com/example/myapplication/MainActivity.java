package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {
    //1. 값을 가져온다
    //이를 위해 전역 변수 설정
    TextInputEditText edittext_email,edittext_password;
    AppCompatButton login,facebook;
    String emailOK="123@gmail.com";
    String passwordOK="1234";

    String inputEmail="";
    String inputPassword="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        edittext_email=findViewById(R.id.edit_email);
        edittext_password=findViewById(R.id.edit_password);
        login=findViewById(R.id.button_login);
        facebook=findViewById(R.id.button_facebook);
        login.setClickable(false);
        //각 변수를 만들어주고 findViewById로 변수 연결함
        // 추가 : 가져온 값을 검사(서버 구축을 안 했기 때문에 단순 로직만 검사)
        // 123@gmail.com / 1234인 경우에만 pass
        edittext_email.addTextChangedListener(new TextWatcher() {
            @Override //글자가 바뀌기 전
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override //글자가 바뀌었을 때
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                if (charSequence!=null){
                    Log.d("SENTI",charSequence.toString());
                    inputEmail=charSequence.toString();
                    login.setClickable(validation());
                }
            }

            @Override //글자가 바뀐 후
            public void afterTextChanged(Editable editable) {

            }
        });
        edittext_password.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (charSequence!=null){
                    Log.d("SENTI",charSequence.toString());
                    inputPassword=charSequence.toString();
                    login.setClickable(validation());
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
        //2. 클릭을 감지한다
        //감지에 대하여 email과 password를 받아야하기 때문에 login에 대하여 setOnClickListener 설정
        //login.setClickable(true);//클릭이 가능하도록 여기서도 설정이 가능함
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email=edittext_email.getText().toString();
                String password=edittext_password.getText().toString();
                //값을 다른 곳으로 넘겨주기 위해 intent라는 키워드를 사용해야 함
                Intent intent=new Intent(MainActivity.this, LoginResultActivity.class);
                //첫번째 클래스에서 두번째 클래스로 가랏
                intent.putExtra("email",email);
                intent.putExtra("password",password);
                startActivity(intent);
            }
        });
        //3. 1번의 값을 다음 액티비티로 넘긴다
    }
    public boolean validation(){
        Log.d("SENTI",inputEmail+" / "+inputPassword+" / "+(inputEmail.equals(emailOK))+" / "+(inputPassword.equals(passwordOK)));
        return inputEmail.equals(emailOK) && inputPassword.equals(passwordOK);
    }
}