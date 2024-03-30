package com.example.myapplication2;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapplication2.databinding.FragmentMainBinding;
import com.example.myapplication2.databinding.FragmentRegisterBinding;

public class FragmentMain extends Fragment {

    String LIFECYCLE_TAG = "lifecycle";
    String TAG = "GINGER";
    private FragmentMainBinding binding;
    public static FragmentMain newInstance() {
        return new FragmentMain();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = FragmentMainBinding.inflate(inflater, container, false);

        Log.i(TAG, "starting main fragment");
        getParentFragmentManager().setFragmentResultListener("fromReg",
                this, (requestKey, result) -> {
                    Log.d(TAG, "принимаем текст от фрагмента регистрации");
                    String resultString = result.getString(getString(R.string.request_key));
                    binding.loginEditText.setText(resultString);
                });

        binding.registerText.setOnClickListener(v -> {
            Log.v(TAG, "отдаем текст фрагменту регистрации");
            RegisterFragment registerFragment = new RegisterFragment();

            Bundle result = new Bundle();
            String resultValue = binding.loginEditText.getText().toString();
            result.putString(getString(R.string.request_key), resultValue);
            getParentFragmentManager().setFragmentResult("toReg", result);

            getParentFragmentManager().beginTransaction()
                    .replace(R.id.first_container, new RegisterFragment())
                    .addToBackStack(null)  // Добавляем транзакцию в стек возврата
                    .commit();
        });

        Log.i(LIFECYCLE_TAG, "onCreateView");
        Toast.makeText(requireContext(), "onCreateView", Toast.LENGTH_SHORT).show();

        return binding.getRoot();
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Log.i(LIFECYCLE_TAG, "onViewCreated");
        Toast.makeText(requireContext(), "onViewCreated", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onViewStateRestored(@Nullable Bundle savedInstanceState) {
        super.onViewStateRestored(savedInstanceState);

        Log.i(LIFECYCLE_TAG, "onViewStateRestored");
        Toast.makeText(requireContext(), "onViewStateRestored", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onStart() {
        super.onStart();

        Log.i(LIFECYCLE_TAG, "onStart");
        Toast.makeText(requireContext(), "onStart", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onResume() {
        super.onResume();

        Log.i(LIFECYCLE_TAG, "onResume");
        Toast.makeText(requireContext(), "onResume", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onPause() {
        super.onPause();

        Log.i(LIFECYCLE_TAG, "onPause");
        Toast.makeText(requireContext(), "onPause", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onStop() {
        super.onStop();

        Log.i(LIFECYCLE_TAG, "onStop");
        Toast.makeText(requireContext(), "onStop", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);

        Log.i(LIFECYCLE_TAG, "onSaveInstanceState");
        Toast.makeText(requireContext(), "onSaveInstanceState", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onDestroyView() {
        Log.i(LIFECYCLE_TAG, "onDestroyView");
        Toast.makeText(requireContext(), "onDestroyView", Toast.LENGTH_SHORT).show();
        super.onDestroyView();
    }

    @Override
    public void onDestroy() {
        Log.i(LIFECYCLE_TAG, "onDestroy");
        Toast.makeText(requireContext(), "onDestroy", Toast.LENGTH_SHORT).show();
        super.onDestroy();
    }

}