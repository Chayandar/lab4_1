package com.example.lab4_1;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import java.util.HashMap;

public class DataActivity extends AppCompatActivity {

    private TextView usernameTextView;
    private TextView userDataTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data);

        usernameTextView = findViewById(R.id.usernameTextView);
        userDataTextView = findViewById(R.id.userDataTextView);

        // Получаем имя пользователя из предыдущей активности
        String username = getIntent().getStringExtra("username");
        // Получаем словарь с уникальной информацией для каждого пользователя
        HashMap<String, String> additionalInfoMap = (HashMap<String, String>) getIntent().getSerializableExtra("additionalInfoMap");
        // Получаем уникальную информацию для пользователя из словаря
        String additionalInfo = additionalInfoMap.get(username);
        // Формируем строку с уникальной информацией для пользователя
        String userData = "Вы - " + additionalInfo;

        usernameTextView.setText("Привет, " + username + "!");
        userDataTextView.setText(userData);
    }
}