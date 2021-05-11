package com.AndyAgulue.github.taskmaster;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.widget.Button;
import android.widget.TextView;

public class SettingsPage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings_page);

        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor preferencesEditor = preferences.edit();


        findViewById(R.id.saveUsername).setOnClickListener(v -> {
            String username2 = ((TextView)findViewById(R.id.editTextUsername)).getText().toString();

            preferencesEditor.putString("username", username2);

            preferencesEditor.apply();

            Intent intent = new Intent(SettingsPage.this, MainActivity.class);
            SettingsPage.this.startActivity(intent);
            startActivity(intent);
        });

        Button signOutButton = findViewById(R.id.settingsButton);
        signOutButton.setOnClickListener(view -> {
            Intent intent = new Intent(SettingsPage.this, MainActivity.class);
            startActivity(intent);
        });
    }
}