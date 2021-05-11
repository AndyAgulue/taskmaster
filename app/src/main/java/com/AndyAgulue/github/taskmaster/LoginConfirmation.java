package com.AndyAgulue.github.taskmaster;

import android.content.Intent;
import android.os.Bundle;

import com.amplifyframework.core.Amplify;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.AndyAgulue.github.taskmaster.databinding.ActivityLoginConfirmationBinding;

public class LoginConfirmation extends AppCompatActivity {

   public static String TAG = "LoginConfirmation";
    void confirmLoggedIn(String email){
        Amplify.Auth.confirmSignUp(
                email,
                ((TextView) findViewById(R.id.editTextConfirmationCode))
                .getText().toString(),
                r-> {
                    startActivity(new Intent(LoginConfirmation.this, MainActivity.class));
                },
                r -> {
                    Toast.makeText(getApplicationContext(), "Invalid Code", Toast.LENGTH_LONG).show();
                }
        );
    }

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_confirmation);
        String email = getIntent().getStringExtra("email");
        findViewById(R.id.validatetAccountButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { confirmLoggedIn(email);

            }
        });
    }
}