package com.example.todolist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity() {
    companion object {
        const val TAG="MainActivity"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.v("TAG","Hello World")//아무거나 찍을때 사용. 중요한 정보들을 출력하는 용도는 아님
        Log.d("Tag","Hello World")//debug를 위한
        Log.i("Tag","Hello World")//중요한 정보를 알려주기 위해 사용
        Log.w("Tag","Hello World")//warning. 불안한 일들에 대해서
        Log.e("Tag","Hello World")//error. 에러가 나는 상황에 대하여 log
        //아래로 갈수록 레벨이 깊어짐. 자기 자신을 포함한 그 이상의 로그를 출력한다.
        //태그에 대한 편의성 증대를 위해 timber 라이브러리를 사용하도록 함
    }
}