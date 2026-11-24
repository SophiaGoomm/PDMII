package com.example.projetopdmii;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.TextView;

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

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class Tela05_quiz extends AppCompatActivity implements View.OnClickListener {
    private DrawerLayout drawerLayout;
    private NavigationView navigationView;
    private ActionBarDrawerToggle toggle;

    private Toolbar toolbar;

    private ArrayList <Pergunta> lista_perguntas;

    private TextView pergunta, contagem, contagem_erro, contagem_acertos ;
    private RadioButton opcao1, opcao2, opcao3, opcao4;

    private int indice_lista, n_questao, n_acertos, n_erros;

    private ProgressBar progressBar;

    private Button verificar, proximo;

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

        progressBar = findViewById(R.id.progressBar);

        verificar = findViewById(R.id.button2);
        proximo = findViewById(R.id.button3);

        verificar.setOnClickListener(this);
        proximo.setOnClickListener(this);


        pergunta = findViewById(R.id.textView12);

        opcao1 = findViewById(R.id.radioButton);
        opcao2 = findViewById(R.id.radioButton4);
        opcao3 = findViewById(R.id.radioButton3);
        opcao4 = findViewById(R.id.radioButton2);

        contagem = findViewById(R.id.textView11);
        contagem_erro = findViewById(R.id.textView8);
        contagem_acertos = findViewById(R.id.textView10);


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
    public void montando_perguntas (){
        lista_perguntas = new ArrayList<Pergunta>();
        lista_perguntas.add(new Pergunta("Qual o melhor pokemon do mundo?","Zorua","Ditto","Rayquaza","MewTwo","Zorua"));
        lista_perguntas.add(new Pergunta("Quem é o melhor personagem de Naruto?","Naruto, que é o protagonista","Sasukeque, é o antagonista","Madara, vilão que usa hack","Rock Lee, personagem secundário","Rock Lee"));
        lista_perguntas.add(new Pergunta("O que fazer quando aparecer uma aranha na sua casa?","Enfrenta","Aceita a morte","Ignora","Chama o homem-aranha","Aceitar a morte"));
        lista_perguntas.add(new Pergunta("Quem a baixo não é digno de receber o nome de chocolate?","Chocolate quente","Sorvete de chocolate","Bolo de Chocolate","A fantástica Fabrica de Chocolate","Sorvete de chocolate"));
        lista_perguntas.add(new Pergunta("O que fazer em um dia livre ?","Sair com os amigos (com comida envolvida)","Sair com os amigos (sem comida envolvida)","Ficar enfiado dentro de casa","Ficar estudando","Ficar enfiado dentro de casa"));
        lista_perguntas.add(new Pergunta("Qual o meu personagem favorito de Naruto Ultimate Ninja Storm 4","Ino, uma diva","Sasuke, infelizmente","Deidara, usa hack","Shisui, mata um com um combo ","Sasuke, infelizmente"));
        lista_perguntas.add(new Pergunta("Qual o problema do studio Ghibli?","Aya e a Bruxa, filme em 3D","Todo ano o Miyasaki ameça de aposentar"," Muito tempo de espera","É perfeito demais, ai fica injusto com os outros studios","É perfeito demais, ai fica injusto com os outros studios"));
        lista_perguntas.add(new Pergunta("Qual minha pelúcia favorita?","Forfix","Mondronguinho","Pingu","Godlla","Forfix"));
        lista_perguntas.add(new Pergunta("Meu mascote é?","Um fantasma","Um pinguim","Um ovo","Um coelho","Um ovo"));
        lista_perguntas.add(new Pergunta("Você gostou do app é?","sim","claro","Tô certo","Totalmente","Tô certo"));
        Collections.shuffle(lista_perguntas);

    }

    public void carregar_peguntas(){
        montando_perguntas();
        n_questao = 0;
        indice_lista = 0;
        pergunta.setText(lista_perguntas.get(indice_lista).getPergunta());
        opcao1.setText(lista_perguntas.get(indice_lista).getOpcaoA());
        opcao2.setText(lista_perguntas.get(indice_lista).getOpcaoB());
        opcao3.setText(lista_perguntas.get(indice_lista).getOpcaoC());
        opcao4.setText(lista_perguntas.get(indice_lista).getOpcaoD());
        n_questao++;

        contagem.setText("Perguntas: "+ Integer.toString(n_questao)+" / 20");
    }

    @Override
    public void onClick(View view) {

    }
}