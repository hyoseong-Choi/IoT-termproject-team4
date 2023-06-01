package com.example.userapp;


import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    EditText editText;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView startButton = findViewById(R.id.main_enter_btn);
        editText = findViewById(R.id.main_location_et);

        // 안내 시작 버튼을 클릭하면
        startButton.setOnClickListener(view -> {
            String destination = editText.getText().toString();

            if(!destination.isEmpty()) {
                // 네비게이션 화면으로 넘어감
                Intent intent = new Intent(getApplicationContext(), ResultActivity.class);
                intent.putExtra("destination", destination);

                startActivity(intent);
            }
        });
    }

    @Override
    public void onResume() {
        super.onResume();

        editText.setText("");
    }
}