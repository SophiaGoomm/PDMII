package com.example.projetopdmii;

import android.os.Bundle;
import android.view.View;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.viewpager2.widget.ViewPager2;

import java.util.ArrayList;

public class Tela03 extends AppCompatActivity {

    private ViewPager2 viewPager;
    private ArrayList<Slide> lista_de_slides;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_tela03);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        viewPager = findViewById(R.id.viewpager);
        lista_de_slides = new ArrayList<>();
        lista_de_slides.add(new Slide("Zorua Hisui", R.drawable.zorua, "Meu pokemon favorito"));
        lista_de_slides.add(new Slide("Mimikyu", R.drawable.mimikyu, "Zé coitado ;("));
        lista_de_slides.add(new Slide("Elektross", R.drawable.pepexinho, "Pepexinho é feinho, mas fortinho"));
        lista_de_slides.add(new Slide("Poltergeist", R.drawable.original, "Ele é original de fábrica"));
        lista_de_slides.add(new Slide("Porygon", R.drawable.orygon, "Um porygon, Nilce"));

        SlideAdapter adapter = new SlideAdapter(lista_de_slides);
        viewPager.setAdapter(adapter);


    }

}