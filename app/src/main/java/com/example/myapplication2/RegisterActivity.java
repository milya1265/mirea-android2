package com.example.myapplication2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication2.databinding.ActivityRegisterBinding;

import java.time.Instant;

public class RegisterActivity extends AppCompatActivity {
    String tag = "GINGER";

    private ActivityRegisterBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityRegisterBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot()); // Установка макета

        Bundle arguments = getIntent().getExtras();
        if (arguments != null) {
            String login = arguments.getString("login");
            // Устанавливаем текст в EditText с помощью ViewBinding
            binding.loginEditText.setText(login); // Устанавливаем текст
        } else {
            Log.e(tag, "No login information received");
        }

        binding.loginEditText.setHint("Enter login");

        Log.i(tag, "starting second activity");


        binding.registerText.setOnClickListener(view -> {
            Intent result = new Intent();
            String resultValue = binding.loginEditText.getText().toString();
            result.putExtra("result_key", resultValue);
            setResult(Activity.RESULT_OK, result);
            finish();
        });


    }
}
