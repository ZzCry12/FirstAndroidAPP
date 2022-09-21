package com.example.firstandroidapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.firstandroidapp.databinding.FragmentFirstBinding;

public class FirstFragment extends Fragment {

    private FragmentFirstBinding binding;
    private Button p1venenomas;
    private Button p1venenomenos;
    private Button p2venenomas;
    private Button p2venenomenos;
    private ImageButton botonarriba;
    private ImageButton botonabajo;
    private ImageButton p1vidamenos;
    private ImageButton p1vidamas;
    private ImageButton p2vidamenos;
    private ImageButton p2vidamas;
    private TextView p1vida;
    private TextView p2vida;

    private int vida1;
    private int vida2;
    private int veneno1;
    private int veneno2;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentFirstBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        p1venenomas = (Button) view.findViewById(R.id.p1venenomas);
        p1venenomenos = (Button) view.findViewById(R.id.p1venenomenos);
        p2venenomas = (Button) view.findViewById(R.id.p2venenomas);
        p2venenomenos = (Button) view.findViewById(R.id.p2venenomenos);
        botonarriba = (ImageButton) view.findViewById(R.id.botonarriba);
        botonabajo = (ImageButton) view.findViewById(R.id.botonabajo);
        p1vidamenos = (ImageButton) view.findViewById(R.id.p1vidamenos);
        p1vidamas = (ImageButton) view.findViewById(R.id.p1vidamas);
        p2vidamenos = (ImageButton) view.findViewById(R.id.p2vidamenos);
        p2vidamas = (ImageButton) view.findViewById(R.id.p2vidamas);
        p1vida = (TextView) view.findViewById(R.id.p1vida);
        p2vida = (TextView) view.findViewById(R.id.p2vida);

        botonabajo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                vida1--;
                vida2++;
                updateviews();
            }
        });
        botonarriba.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                vida1++;
                vida2--;
                updateviews();
            }
        });
        p1venenomas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                veneno1++;
                updateviews();
            }
        });


        reset();


    }

    private void reset() {
        vida1=20;
        vida2=20;
        veneno1=0;
        veneno2=0;
        updateviews();
    }

    private void updateviews() {
        p1vida.setText(String.format("%d/%d",vida1,veneno1));
        p2vida.setText(String.format("%d/%d",vida2,veneno2));
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}