package com.example.projetopdmii;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
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
import androidx.viewpager2.widget.ViewPager2;

import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;

public class Tela03 extends AppCompatActivity implements View.OnClickListener, MediaPlayer.OnCompletionListener{

    private ViewPager2 viewPager;
    private ArrayList<Slide> lista_de_slides;

    private MediaPlayer mediaPlayer;

    private Button voltar;

    private TextView texto;
    
    private Toolbar toolbar;

    private int musica;

    private Boolean flag;

    private ImageView icone;

    private DrawerLayout drawerLayout;

    private NavigationView navigationView;

    private ActionBarDrawerToggle toggle;



    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_tela03);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.iddrawer), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

         toolbar= findViewById(R.id.toolbar2);
        //atribui a toolbar o poder de actionbar
        setSupportActionBar(toolbar);
        // habilita o botão de voltar
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        texto = findViewById(R.id.textView3);

        viewPager = findViewById(R.id.viewpager);
        lista_de_slides = new ArrayList<>();
        lista_de_slides.add(new Slide("Zorua Hisui", R.drawable.zorua, "Meu pokemon favorito \n\n \"Uma alma que partiu, retornada à vida em Hisui. Ele retira poder do ressentimento, que sobe como energia no topo de sua cabeça e assume a forma de inimigos. Dessa forma, Zorua desafoga sua malícia persistente.\"\n\n História: Os Zorua originais migraram para Hisui após serem expulsos por humanos devido às suas ilusões, mas não resistiram ao clima rigoroso e morreram. Suas almas renasceram tomadas por rancor e malícia.\n\n Habilidade: Ao contrário do Zorua comum, ele usa sua pelagem longa para manifestar imagens fantasmagóricas e imitar a aparência de pessoas ou Pokémon solitários para assustá-los.\n\nTipagem: Normal e Fantasma."));
        lista_de_slides.add(new Slide("Mimikyu", R.drawable.mimikyu, "Zé coitado \n\n \"Uma criatura solitária que esconde sua verdadeira aparência sob um pano velho para parecer um Pikachu. Ele retira poder do desejo de ser amado, mas se alguém tentar olhar o que há por baixo do disfarce, é atingido por uma doença misteriosa e terrível. Dessa forma, Mimikyu protege seu segredo e sua própria vida.\n\n\"História: Os Mimikyu vivem em locais escuros e isolados porque o sol enfraquece sua saúde. Eles criaram o disfarce inspirados na popularidade do Pikachu há cerca de 20 anos, acreditando que vestir-se como ele seria a única maneira de fazer amizade com os humanos e outros Pokémon.\n\nHabilidade: Ao contrário de outros Pokémon fantasmagóricos, ele usa seu pano artesanal para absorver o impacto de um ataque inimigo por completo, revelando sua cabeça caída após o disfarce ser quebrado pelo oponente.\n\nTipagem: Fantasma e Fada."));
        lista_de_slides.add(new Slide("Elektross", R.drawable.pepexinho, "Pepexinho é feinho, mas fortinho \n\n \"Um predador voraz que emerge das profundezas do oceano usando a força de seus braços. Ele retira poder de sua imensa energia elétrica, gerada em seu próprio corpo e liberada através de suas presas. Dessa forma, Eelektross domina seus oponentes antes mesmo que eles possam esboçar qualquer reação.\n\n\"História: Habitando os mares mais profundos, os Eelektross são conhecidos por subir deliberadamente até as praias e terra firme para caçar. Com uma força surpreendente em seus braços, eles surpreendem as presas na costa e, num piscar de olhos, as arrastam violentamente de volta para o oceano para que não tenham escapatória.\n\nHabilidade: Graças à sua flutuação magnética e agilidade, ele se fixa firmemente nos adversários com sua boca em forma de ventosa. Ao cravar seus dentes elétricos diretamente na presa, ele descarrega uma voltagem avassaladora que paralisa o alvo instantaneamente.\n\nTipagem: Elétrico."));
        lista_de_slides.add(new Slide("Poltergeist", R.drawable.original, "Ele é original de fábrica \n\n \"Uma assombração refinada que habita o interior de um bule de chá antigo de altíssimo valor. Ele retira poder do chá preto que compõe seu corpo, cuja essência possui um aroma e sabor deliciosos, mas que esconde um perigo congelante. Dessa forma, Polteageist pune os gulosos imprudentes, servindo-lhes uma dose fatal de calafrios e dores estomacais.\n\n\"História: Diferente da grande maioria de sua espécie, que vive em bules falsificados e réplicas baratas, a Forma Autêntica do Polteageist habita exclusivamente uma obra de arte genuína e de época. Escondido sob a base do recipiente, existe um selo real de autenticidade que atesta o seu valor astronômico. Ele se multiplica ao se infiltrar sorrateiramente em restos de chá deixados sem atenção em hotéis e cafeterias, transformando o líquido instantaneamente em um novo espectro.\n\nHabilidade: Ao ser atacado, sua casca de porcelana legítima se rompe, diminuindo suas defesas mas aumentando drasticamente sua velocidade de reação. Quando provocado ou enfurecido, ele dispara jatos de chá diretamente na boca do oponente. Aqueles que o treinador conquista a confiança recebem a rara permissão de degustar pequenos goles de seu corpo, embora o consumo excessivo seja fatal.\n\nTipagem: Fantasma."));
        lista_de_slides.add(new Slide("Porygon Z", R.drawable.orygon, "Um porygon, Nilce \n\n\"Um software de inteligência artificial que foi corrompido após uma atualização de sistema experimental e não autorizada. Ele retira poder de sua programação instável, que faz seu corpo virtual sofrer falhas constantes e se mover de maneira totalmente errática. Dessa forma, Porygon-Z manifesta habilidades caóticas que desafiam a lógica e superam suas limitações originais.\n\n\"História: Cientistas modificaram o Porygon2 com um software de atualização clandestino, criado na tentativa de dar a ele a capacidade de viajar e operar em dimensões alienígenas. O experimento falhou gravemente; o programa estava repleto de erros e vírus, fazendo com que o Pokémon começasse a exibir comportamentos bizarros e espasmos incontroláveis, impossibilitando qualquer viagem dimensional estável.\n\nHabilidade: Ao contrário de suas versões anteriores, sua capacidade de processamento foi sobrecarregada de forma destrutiva. Ao entrar em combate, ele converte dados virtuais na potência máxima de seus ataques especiais, disparando feixes de energia massivos enquanto gira a própria cabeça em 360 graus por causa de seus bugs operacionais.\n\nTipagem: Normal."));

        SlideAdapter adapter = new SlideAdapter(lista_de_slides, texto);
        viewPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                texto.setText(lista_de_slides.get(position).getTexto());
            }
        });
        viewPager.setAdapter(adapter);

        voltar = findViewById(R.id.button);
        voltar.setOnClickListener(this);


        //texto_img.setText("Meu pokemon favorito \n\n \"Uma alma que partiu, retornada à vida em Hisui. Ele retira poder do ressentimento, que sobe como energia no topo de sua cabeça e assume a forma de inimigos. Dessa forma, Zorua desaboga sua malícia persistente.\"\n História: Os Zorua originais migraram para Hisui após serem expulsos por humanos devido às suas ilusões, mas não resistiram ao clima rigoroso e morreram. Suas almas renasceram tomadas por rancor e malícia.\n Habilidade: Ao contrário do Zorua comum, ele usa sua pelagem longa para manifestar imagens fantasmagóricas e imitar a aparência de pessoas ou Pokémon solitários para assustá-los.\nTipagem: Normal e Fantasma.");

        musica = R.raw.accumulatown;

        flag = true;

        icone = findViewById(R.id.imageView10);
        icone.setOnClickListener(this);

        drawerLayout = findViewById(R.id.iddrawer);
        navigationView = findViewById(R.id.navigationView);
        toggle = new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.open,R.string.close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                if(menuItem.getItemId() == R.id.id_home){
                    startActivity(new Intent(Tela03.this, TelaHome.class));
                    return true;

                }
                if(menuItem.getItemId() == R.id.id_tela02){ //musica
                    drawerLayout.closeDrawers();
                    startActivity(new Intent(Tela03.this, tela02.class));
                    return true;


                }
                if(menuItem.getItemId() == R.id.id_tela03){ //slides pokemon
                    drawerLayout.closeDrawers();
                    return false;


                }
                if(menuItem.getItemId() == R.id.id_quiz){ //quiz
                    drawerLayout.closeDrawers();
                    startActivity(new Intent(Tela03.this, Tela05_quiz.class));
                    return false;

                }
                if(menuItem.getItemId() == R.id.id_sobre){ //sobre
                    drawerLayout.closeDrawers();
                    startActivity(new Intent(Tela03.this, Tela04.class));
                    return true;

                }
                return false;
            }
        });





    }


    @Override
    public void onClick(View view) {
        if(view == voltar){
            startActivity(new Intent(this,MainActivity.class));

        }


        if(view == icone){

            if(flag){
                flag = false;
                icone.setImageResource(R.drawable.music_off_48px);
                play();

                //item.setVisible(false);
            }else{
                flag = true;
                icone.setImageResource(R.drawable.music_note_48px);
                stop();
            }

        }
    }




    public void play(){
        //if(mediaPlayer == null){
            Log.d("##","sim estou aqui");
            mediaPlayer = MediaPlayer.create(this, musica);

            mediaPlayer.setOnCompletionListener(this);

            mediaPlayer.start();
        //}
    }

    public void stop(){
        if( mediaPlayer != null){
            mediaPlayer.stop();
            mediaPlayer.release();
            mediaPlayer = null;
        }

    }

    @Override
    public void onCompletion(MediaPlayer mediaPlayer) {

    }
}