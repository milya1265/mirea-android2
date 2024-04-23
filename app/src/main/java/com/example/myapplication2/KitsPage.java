package com.example.myapplication2;

import android.content.Context;
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
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

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


        // Вместо ArrayAdapter используйте свой собственный адаптер, например, BaseAdapter или ArrayAdapter с кастомным макетом
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this.getContext(), R.layout.list_kit_raw, catNames) {
            @NonNull
            @Override
            public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
                View view = convertView;
                if (view == null) {
                    LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                    view = inflater.inflate(R.layout.list_kit_raw, null);
                }

                // Получаем ссылки на ImageView и TextView в макете элемента списка
                ImageView imageView = view.findViewById(R.id.KitImage);
                TextView textView = view.findViewById(R.id.KitName);

                // Устанавливаем текст из списка
                textView.setText(catNames.get(position));
                imageView.setImageResource(R.drawable.cat_svgrepo_com);


                // Устанавливаем изображение для каждого элемента списка (здесь вы можете использовать какой-то механизм, чтобы определить, какое изображение устанавливать для каждого элемента)
                // Пример: imageView.setImageResource(R.drawable.cat_image);
                // Здесь cat_image - это имя вашего ресурса изображения
                // Вы можете использовать какой-то другой механизм для определения изображения в зависимости от позиции элемента списка

                return view;
            }
        };

        listView.setAdapter(adapter);

// используем адаптер данных
//        ArrayAdapter<String> adapter = new ArrayAdapter<>(this.getContext(), android.R.layout.simple_list_item_1, catNames);

        listView.setAdapter(adapter);

        return binding.getRoot();
    }


}