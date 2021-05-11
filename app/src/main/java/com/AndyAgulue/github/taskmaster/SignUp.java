package com.AndyAgulue.github.taskmaster;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.amplifyframework.auth.AuthUserAttributeKey;
import com.amplifyframework.auth.options.AuthSignUpOptions;
import com.amplifyframework.core.Amplify;

public class SignUp extends AppCompatActivity {

    void signupConfirmation(){
        (findViewById(R.id.signUpButton)).setOnClickListener(v->{
            String email = ((EditText) findViewById(R.id.editTextEmailAddress)).getText().toString();
            String password = ((EditText) findViewById(R.id.editTextPassword)).getText().toString();
            Amplify.Auth.signUp(
                    email,
                    password,
                    AuthSignUpOptions.builder()
                            .userAttribute(AuthUserAttributeKey.email(),email)
                            .build(),
                    r ->{
                        Intent intent = new Intent(SignUp.this,LoginConfirmation.class);
                        intent.putExtra("email", email);
                        startActivity(intent);
                    },
                    r ->{
                        Log.i("Sign up successful", "SignupConfirmation: Failed");
                    }
            );
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        signupConfirmation();
    }
}
