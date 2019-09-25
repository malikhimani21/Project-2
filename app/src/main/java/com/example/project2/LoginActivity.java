package com.example.project2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    EditText username, password;
    Button login;
    int attempt = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getSupportActionBar().hide();
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_login);

        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);
        login = (Button) findViewById(R.id.login);

        LayoutInflater layoutInflater = getLayoutInflater();
        View view = layoutInflater.inflate(R.layout.toast_layout, (ViewGroup) findViewById(R.id.toast_layout));

        Toast toast = new Toast(getApplicationContext());
        toast.setDuration(Toast.LENGTH_LONG);
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.setView(view);
        toast.show();

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String USER = username.getText().toString();
                String PASS = password.getText().toString();

                if (TextUtils.isEmpty(USER) || TextUtils.isEmpty(PASS)) {
                    Toast.makeText(getApplicationContext(), "Enter value first", Toast.LENGTH_LONG).show();
                } else {
                    if (USER.equals("malik") && PASS.equals("1")) {
                        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                        intent.putExtra("key1", USER);
                        intent.putExtra("key2", PASS);
                        startActivity(intent);
                    } else {
                        Toast.makeText(getApplicationContext(), "Invalid username or password", Toast.LENGTH_LONG).show();
                        attempt--;
                        Toast.makeText(getApplicationContext(), "Attempt left " + String.valueOf(attempt), Toast.LENGTH_LONG).show();
                        if (attempt == 0) {
                            login.setEnabled(false);
                            login.setVisibility(View.INVISIBLE);
                            Toast.makeText(getApplicationContext(), "Button is disabled, You have to login again...", Toast.LENGTH_LONG).show();
                        }

                    }
                }


            }
        });
    }

    @Override
    protected void onPause() {
        super.onPause();
        finish();
    }
}
