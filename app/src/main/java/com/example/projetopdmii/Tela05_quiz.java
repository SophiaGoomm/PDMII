package com.example.projetopdmii;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;

public class Tela05_quiz extends AppCompatActivity {
    private DrawerLayout drawerLayout;
    private NavigationView navigationView;
    private ActionBarDrawerToggle toggle;

    private Toolbar toolbar;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_tela05_quiz);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.id_tela05), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        toolbar= findViewById(R.id.toolbar5);
        //atribui a toolbar o poder de actionbar
        setSupportActionBar(toolbar);
        // habilita o botão de voltar
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);



        navigationView = findViewById(R.id.id_navigatin_tela05);
        drawerLayout = findViewById(R.id.iddrawer);
        toggle = new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.open,R.string.close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                if(menuItem.getItemId() == R.id.id_home){
                    startActivity(new Intent(Tela05_quiz.this, TelaHome.class));
                    return true;

                }
                if(menuItem.getItemId() == R.id.id_tela02){ //musica
                    drawerLayout.closeDrawers();
                    startActivity(new Intent(Tela05_quiz.this, tela02.class));
                    return true;

                }
                if(menuItem.getItemId() == R.id.id_tela03){ //slides pokemon
                    drawerLayout.closeDrawers();
                    startActivity(new Intent(Tela05_quiz.this, Tela03.class));
                    return true;

                }
                if(menuItem.getItemId() == R.id.id_quiz){ //quiz
                    drawerLayout.closeDrawers();
                    return true;

                }
                if(menuItem.getItemId() == R.id.id_sobre){ //sobre
                    drawerLayout.closeDrawers();
                    startActivity(new Intent(Tela05_quiz.this, Tela04.class));
                    return true;

                }

                return false;
            }
        });
    }
}