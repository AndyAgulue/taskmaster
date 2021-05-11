package com.AndyAgulue.github.taskmaster;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.amplifyframework.core.Amplify;

public class SignIn extends AppCompatActivity {
    Handler handler;

    void loginCognito(){
        findViewById(R.id.signInButton).setOnClickListener(v->{
            String email = ((EditText)findViewById(R.id.editTextEmailAddress)).getText().toString();
            String password = ((EditText)findViewById(R.id.editTextPassword)).getText().toString();
            Amplify.Auth.signIn(
                    email,
                    password,
                    r ->{
                        handler.sendEmptyMessage(1);
                        Intent intent = new Intent(SignIn.this,MainActivity.class);
                        intent.putExtra("email", email);
                        startActivity(intent);
                    },
                    r -> handler.sendEmptyMessage(2)
            );
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        handler = new Handler(getMainLooper()){
            @Override
            public void handleMessage(@NonNull Message msg) {
                super.handleMessage(msg);
                String message = msg.what == 1 ? "Welcome" : (msg.what == 2 ? "oops! Try Again" : "Error");
                Toast.makeText(getApplicationContext(),message, Toast.LENGTH_LONG).show();
            }
        };

        loginCognito();
    }
}
