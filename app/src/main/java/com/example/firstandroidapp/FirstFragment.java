package com.example.firstandroidapp;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
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
        if (savedInstanceState!=null){
            vida1 = savedInstanceState.getInt("p1vida");
            vida2 = savedInstanceState.getInt("p2vida");
            veneno1 = savedInstanceState.getInt("veneno1");
            veneno2 = savedInstanceState.getInt("veneno2");
        }
        giro();
        return binding.getRoot();

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
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

        View.OnClickListener listener = new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                switch (view.getId()){
                    case R.id.botonabajo:
                        vida1--;
                        vida2++;
                        break;

                    case R.id.botonarriba:
                        vida1++;
                        vida2--;
                        break;
                    case R.id.p1venenomas:
                        veneno1++;
                        break;
                    case R.id.p1venenomenos:
                        veneno1--;
                        break;
                    case R.id.p2venenomas:
                        veneno2++;
                        break;
                    case R.id.p2venenomenos:
                        veneno2--;
                        break;
                    case R.id.p1vidamas:
                        vida1++;
                        break;
                    case R.id.p1vidamenos:
                        vida1--;
                        break;
                    case R.id.p2vidamas:
                        vida2++;
                        break;
                    case R.id.p2vidamenos:
                        vida2--;
                        break;

                }
                updateViews();
            }
        };
        reset();

        botonabajo.setOnClickListener(listener);
        botonarriba.setOnClickListener(listener);
        p1venenomas.setOnClickListener(listener);
        p1venenomenos.setOnClickListener(listener);
        p2venenomas.setOnClickListener(listener);
        p2venenomenos.setOnClickListener(listener);
        p1vidamas.setOnClickListener(listener);
        p1vidamenos.setOnClickListener(listener);
        p2vidamas.setOnClickListener(listener);
        p2vidamenos.setOnClickListener(listener);
        p1vida.setOnClickListener(listener);
        p2vida.setOnClickListener(listener);


        //return view;

    }

    private void giro(){
        binding.p1vida.setText(vida1+"/"+veneno1);
        binding.p2vida.setText(vida2+"/"+veneno2);
    }

    private void reset() {
        vida1=20;
        vida2=20;
        veneno1=0;
        veneno2=0;
        updateViews();
    }

    private void updateViews() {
        p1vida.setText(String.format("%d/%d",vida1,veneno1));
        p2vida.setText(String.format("%d/%d",vida2,veneno2));
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    @Override
    public void onSaveInstanceState(Bundle outState){
        outState.putInt("p1vida", vida1);
        outState.putInt("p2vida", vida2);
        outState.putInt("veneno1", veneno1);
        outState.putInt("veneno2", veneno2);
        super.onSaveInstanceState(outState);
    }

  //  @Override
   // Boton de reset incoming
}