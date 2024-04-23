package com.example.myapplication2;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.renderscript.ScriptGroup;
import android.service.voice.VoiceInteractionSession;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.example.myapplication2.Adapters.Acid_RVA;
import com.example.myapplication2.databinding.FragmentAcidPageBinding;
import com.example.myapplication2.models.AcidModel;
import com.google.android.material.bottomnavigation.BottomNavigationMenuView;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.internal.NavigationMenu;
import com.google.android.material.navigation.NavigationBarView;

import java.util.ArrayList;


public class AcidPage extends Fragment {

    ArrayList<AcidModel> acidModels = new ArrayList<>();
    int[] acidImages = {R.drawable.acid_arginine, R.drawable.acid_aspartic, R.drawable.acid_glutamic,
            R.drawable.acid_glycine, R.drawable.acid_histidine, R.drawable.acid_isoleucine,
            R.drawable.acid_lysine, R.drawable.acid_methionine, R.drawable.acid_threonine,
            R.drawable.acid_tryptophan};
    FragmentAcidPageBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        MainActivity activity = (MainActivity) getActivity();
        BottomNavigationView menuFragment =  activity.findViewById(R.id.bottom_navigation);
        if (menuFragment != null) {
            menuFragment.setVisibility(View.VISIBLE);
        }


        binding = FragmentAcidPageBinding.inflate(inflater, container, false);
        RecyclerView recyclerView = binding.acidRecycler;
        setAcidModels();

        Acid_RVA adapter = new Acid_RVA(acidModels);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this.getContext()));


        return binding.getRoot();
    }


    public void setAcidModels() {
        String[] acidNames = getResources().getStringArray(R.array.acid_full_names);
        String[] acidShortName = getResources().getStringArray(R.array.acid_short_names);

        for (int j = 0; j < 20; j++) {
            for (int i = 0; i < acidNames.length; i++) {
                acidModels.add(new AcidModel(acidNames[i], acidShortName[i], acidImages[i]));
            }
        }
    }
}