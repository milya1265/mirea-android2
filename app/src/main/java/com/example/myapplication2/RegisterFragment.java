package com.example.myapplication2;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.myapplication2.databinding.FragmentRegisterBinding;

public class RegisterFragment extends Fragment {
    public String TAG = "GINGER";
    public FragmentRegisterBinding binding;
    public static RegisterFragment newInstance() {
        return new RegisterFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = FragmentRegisterBinding.inflate(getLayoutInflater(), container, false);


        binding.loginEditText.setHint("Enter login");

        Log.i(TAG, "starting second fragment");

        getParentFragmentManager().setFragmentResultListener("toReg",
                this, (requestKey, result) -> {
                    Log.d(TAG, "принимаем текст от фрагмента логина");
                    String login = result.getString(getString(R.string.request_key));
                    if (login.equals("")){
                        Log.e(TAG, "login is empty");
                    } else {
                        Log.i(TAG, login);
                    }
                    binding.loginEditText.setText(login); // Устанавливаем текст
                });

        binding.registerButton.setOnClickListener(view -> {
            if (binding.passwordEditText.getText().toString().equals(binding.passwordRepeatEditText.getText().toString())) {
                Bundle result = new Bundle();
                String resultValue = binding.loginEditText.getText().toString();
                result.putString(getString(R.string.request_key), resultValue);
                getParentFragmentManager().setFragmentResult("fromReg", result);

                getParentFragmentManager().beginTransaction()
                        .replace(R.id.first_container, new FragmentMain())
                        .addToBackStack(null)  // Добавляем транзакцию в стек возврата
                        .commit();
            } else {
                Toast.makeText(requireContext(), "Пароли не совпадают", Toast.LENGTH_SHORT).show();
            }
        });

        return binding.getRoot();
    }

}