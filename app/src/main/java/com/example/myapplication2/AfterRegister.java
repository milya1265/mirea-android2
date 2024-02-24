package com.example.myapplication2;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication2.databinding.ActivityMainRelativeBinding;
import com.example.myapplication2.databinding.ActivityRegisterBinding;

public class AfterRegister extends AppCompatActivity {
    String tag = "GINGER";

    private ActivityMainRelativeBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i(tag, "Third activity");
        binding = ActivityMainRelativeBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot()); // Установка макета
        binding.imageView.setImageResource(R.drawable.no_smoke);
    }
    public void onButtonClick(View view) {
        Log.d(tag, "Button clicked!"); // Запись в логи при клике на кнопку
    }
}
