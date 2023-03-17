package com.example.quan_ly_kho;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

public class Man_Hinh_Login_Activity extends AppCompatActivity {
 private EditText edName, edPassWord;
 private Button btnDangNhap;
 private CheckBox checkBox;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_man_hinh_login);
        edName = findViewById(R.id.edName);
        edPassWord = findViewById(R.id.edPass);
        checkBox = findViewById(R.id.checkbox);
        btnDangNhap = findViewById(R.id.DangNhap);
        btnDangNhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Man_Hinh_Login_Activity.this,MainActivity.class);
                startActivity(intent);
            }
        });

    }
}