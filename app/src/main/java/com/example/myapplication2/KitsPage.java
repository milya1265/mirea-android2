package com.example.myapplication2;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.myapplication2.databinding.FragmentKitsBinding;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

import java.util.ArrayList;

public class KitsPage extends Fragment {

    private String TAG = "GINGER";
    private FragmentKitsBinding binding;
    private NavigationBarView navigationBarView;

    public static KitsPage newInstance() {
        return new KitsPage();
    }


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = FragmentKitsBinding.inflate(inflater, container, false);

        MainActivity activity = (MainActivity) getActivity();
        BottomNavigationView menuFragment =  activity.findViewById(R.id.bottom_navigation);
        if (menuFragment != null) {
            menuFragment.setVisibility(View.VISIBLE);
        }

        Log.i(TAG, "kits fragment");

        ListView listView = binding.listView;

// определяем строковый массив
        ArrayList<String> catNames = new ArrayList<String>();


        String[] list = new String[]{"Рыжик", "Барсик", "Мурзик", "Мурка", "Васька",
                "Томасина", "Кристина", "Пушок", "Дымка", "Кузя",
                "Китти", "Масяня", "Симба" };
        for (int i = 0; i < 15; i++) {
            for (int j = 0; j < list.length; j++){
               catNames.add(list[j]);

            }
        }

/*        BottomNavigationView bottomNavigationView = binding.bottomNavigation;
        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.item_1:
                        // Respond to navigation item 1 click
                        return true;
                    case R.id.item_2:
                        // Respond to navigation item 2 click
                        return true;
                    default:
                        return false;
                }
            }
        });*/
// используем адаптер данных
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this.getContext(), android.R.layout.simple_list_item_1, catNames);

        listView.setAdapter(adapter);

        return binding.getRoot();
    }


}