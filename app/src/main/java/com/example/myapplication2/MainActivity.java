package com.example.myapplication2;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapplication2.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    String tag = "GINGER";
    private ActivityMainBinding binding; // Объект для доступа к представлениям

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        Log.i(tag, "starting main activity");
        Bundle arguments = getIntent().getExtras();
        if (arguments != null) {
            String login = arguments.getString("login");
            // Устанавливаем текст в EditText с помощью ViewBinding
            binding.loginEditText.setText(login); // Устанавливаем текст
        } else {
            Log.e(tag, "No login information received");
        }
        Button loginButton = findViewById(R.id.login_button);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(tag, "Click button login");
                if ((binding.loginEditText.getText().toString().equals("pipi")) &&
                        (binding.passwordEditText.getText().toString().equals("pupu"))){
                    Toast.makeText(getApplicationContext(), "you'r logged in", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(MainActivity.this, AfterRegister.class);
                    startActivity(intent);
                }
                binding.loginEditText.setText("");
                binding.passwordEditText.setText("");
            }
        });
        TextView register = findViewById(R.id.register_text);
        binding.registerText.setText(R.string.register);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d(tag, "Click text register");
                EditText editText = findViewById(R.id.login_edit_text);
                String login = editText.getText().toString();
                Intent intent = new Intent(MainActivity.this, RegisterActivity.class);
                intent.putExtra("login", login);
                launcher.launch(intent);
            }
        });
    }
    private final ActivityResultLauncher<Intent> launcher = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    Intent data = result.getData();
                    if (data == null) return;
                    binding.loginEditText.setText(data.getStringExtra("result_key"));
                }
            }
    );
}