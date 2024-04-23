package com.example.myapplication2;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.myapplication2.databinding.FragmentAuthBinding;

import java.util.HashMap;
import java.util.Map;

public class FragmentAuth extends Fragment {

    String LIFECYCLE_TAG = "lifecycle";
    String TAG = "GINGER";
    private FragmentAuthBinding binding;

    private Map<String, String> Users = new HashMap<String, String>();

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = FragmentAuthBinding.inflate(inflater, container, false);

        Users.put("pipi","pupu");

        Log.i(TAG, "starting main fragment");
        getParentFragmentManager().setFragmentResultListener("fromReg",
                this, (requestKey, result) -> {
                    Log.d(TAG, "принимаем текст от фрагмента регистрации");
                    String resultLogin = result.getString(getString(R.string.request_login));
                    String resultPassword = result.getString(getString(R.string.request_password));
                    binding.loginEditText.setText(resultLogin);

                    Users.put(resultLogin, resultPassword);
                });

        binding.registerText.setOnClickListener(v -> {
            Log.v(TAG, "отдаем текст фрагменту регистрации");
            RegisterFragment registerFragment = new RegisterFragment();

            Bundle result = new Bundle();
            String resultValue = binding.loginEditText.getText().toString();
            result.putString(getString(R.string.request_login), resultValue);
            getParentFragmentManager().setFragmentResult("toReg", result);

            getParentFragmentManager().beginTransaction()
                    .replace(R.id.first_container, registerFragment)
                    .commit();
        });


        binding.loginButton.setOnClickListener(v -> {
            String password = Users.get(binding.loginEditText.getText().toString());
            String logintext = binding.loginEditText.getText().toString();
            String passwordtext = binding.passwordEditText.getText().toString();
            if (password == null) {
                return;
            }
            if (password.equals(passwordtext)) {

                KitsPage afterRegFragment = new KitsPage();
                getParentFragmentManager().beginTransaction()
                        .replace(R.id.first_container, afterRegFragment)
                        .commit();
            }
        });


        return binding.getRoot();
    }


}