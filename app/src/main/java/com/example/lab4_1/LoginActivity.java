package com.example.lab4_1;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import java.util.HashMap;

public class LoginActivity extends AppCompatActivity {

    private String[] usernames = {"Chayan", "Balzhina", "Geser", "Sasha", "Igor"};
    private String[] passwords = {"chayan1234", "balzhina1234", "geser1234", "sasha1234", "igor1234"};

    private HashMap<String, String> additionalInfoMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        additionalInfoMap = new HashMap<>();
        additionalInfoMap.put("Chayan", "ЧЕЧИК");
        additionalInfoMap.put("Balzhina", "АЛЬТУШКА");
        additionalInfoMap.put("Geser", "СКУФ");
        additionalInfoMap.put("Sasha", "МАСИК");
        additionalInfoMap.put("Igor", "ШТРИХ");

        EditText usernameEditText = findViewById(R.id.usernameEditText);
        EditText passwordEditText = findViewById(R.id.passwordEditText);
        Button loginButton = findViewById(R.id.loginButton);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String enteredUsername = usernameEditText.getText().toString();
                String enteredPassword = passwordEditText.getText().toString();

                boolean isAuthenticated = false;
                // Проверяем правильность введенного логина и пароля
                for (int i = 0; i < usernames.length; i++) {
                    if (enteredUsername.equals(usernames[i]) && enteredPassword.equals(passwords[i])) {
                        isAuthenticated = true;
                        break;
                    }
                }

                if (isAuthenticated) {
                    // Создаем Intent для перехода к DataActivity
                    Intent intent = new Intent(LoginActivity.this, DataActivity.class);
                    // Передаем имя пользователя в DataActivity
                    intent.putExtra("username", enteredUsername);
                    // Передаем словарь с уникальной информацией для каждого пользователя в DataActivity
                    intent.putExtra("additionalInfoMap", additionalInfoMap);
                    startActivity(intent);
                } else {
                    Toast.makeText(LoginActivity.this, "Неверный логин или пароль", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
