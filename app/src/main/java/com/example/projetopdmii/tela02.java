package com.example.projetopdmii;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class tela02 extends AppCompatActivity implements MediaPlayer.OnCompletionListener , SeekBar.OnSeekBarChangeListener, Runnable , View.OnClickListener {

    private int musica, indice_lista;

    private Toolbar toolbar;
    private MediaPlayer mediaPlayer;
    private SeekBar seekBar;
    private Handler handler;

    private CardView card1, card2, card3, card4, card5;

    private TextView musica_selecionada, musica_tocando, tempo_atual, tempo_restante;

    private ArrayList <playlist> lista;

    private ImageView imgPreview, imgNext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_tela02);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.iddrawer), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        toolbar = findViewById(R.id.toolbar);
        //atribui a toolbar o poder de actionbar
        setSupportActionBar(toolbar);
        // habilita o botão de voltar
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        seekBar = findViewById(R.id.seekBar);
        seekBar.setOnSeekBarChangeListener(this);
        // Disparando algo em paralelo
         handler = new Handler();



         musica = R.raw.forrodofarol_quincasmoreira;
         // 'raw' para pegar musica

         lista = new ArrayList<playlist>();
         // adicionando musicas na lista
         lista.add(new playlist("Forro do Farol", R.raw.forrodofarol_quincasmoreira));
         lista.add(new playlist("Boa Sorte", R.raw.boasorte));
         lista.add(new playlist("Motivação", R.raw.motivacao));
         lista.add(new playlist("Rock", R.raw.musiquinha01));
         lista.add(new playlist("Tudummm", R.raw.music2));

         card1 = findViewById(R.id.card1);
         card1.setOnClickListener(this);

         card2 = findViewById(R.id.card2);
         card2.setOnClickListener(this);

         card3 = findViewById(R.id.card3);
         card3.setOnClickListener(this);

         card4 = findViewById(R.id.card4);
         card4.setOnClickListener(this);

         card5 = findViewById(R.id.card5);
         card5.setOnClickListener(this);


         //botões de vai e volta entre as musicas

        //volta
         imgPreview = findViewById(R.id.imageView5);
         imgPreview.setOnClickListener(this);
         //vai
         imgNext = findViewById(R.id.imageView6);
         imgNext.setOnClickListener(this);

         tempo_atual = findViewById(R.id.textView);
         tempo_restante = findViewById(R.id.textView7);





    }

    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        //voltar
        if(id == android.R.id.home){
            finish();
        }
        //play
        if(id == R.id.id001){
            play();
        }
        //stop
        if(id == R.id.id003){
            stop();

        }
        //pause
        if (id == R.id.id002){
            if(mediaPlayer != null && mediaPlayer.isPlaying()){
                mediaPlayer.pause();
            }
        }
        return false;
    }
    public boolean onCreateOptionsMenu(Menu menu){
        // menu que infla na toobar os icones
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu, menu);
        return true;

    }

    @Override
    public void onCompletion(MediaPlayer mediaPlayer) {
        //proteção
        handler.removeCallbacks(this);// tira as chamadas agendadas
        mediaPlayer.release(); // libero recurso
        this.mediaPlayer = null;
        seekBar.setProgress(0); // voltar a barra no começo

        // terminou toca a proxima
        indice_lista ++;
        if (indice_lista >= lista.size()){ // se passou a lista volta para o 0
            indice_lista = 0;

        }
        //musica_selecionada.setText(lista.get(indice_lista).getNome());
        stop();
        play();
    }

    @Override // enquanto estive com o dedo na seekbar
    public void onProgressChanged(SeekBar seekBar, int i, boolean b) {

    }

    @Override// quando tocamos na seekbar
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override // quando solta
    //controle da bolinha (quando tira o dedo da seekbar)
    public void onStopTrackingTouch(SeekBar seekBar) {
        if(mediaPlayer != null){
            mediaPlayer.seekTo(seekBar.getProgress());
        }

    }

    @Override
    public void run() {
        if(mediaPlayer != null){
            int tempo_tempo_atual = mediaPlayer.getCurrentPosition();
            int duracao = mediaPlayer.getDuration();
            int tempoRestante = duracao - tempo_tempo_atual;
            tempo_atual.setText(formato_tempo(tempo_tempo_atual));
            tempo_restante.setText("-" + formato_tempo(tempoRestante));


            seekBar.setProgress(mediaPlayer.getCurrentPosition());
            handler.postDelayed(this,1000);
        }

    }

    @Override
    public void onClick(View view) {

        if(view == card1){
            indice_lista = 0;
            //musica_selecionada.setText(lista.get(indice_lista).getNome());

            musica = lista.get(indice_lista).getMusica();

        }
        if(view == card2){
            indice_lista = 1;
            //musica_selecionada.setText(lista.get(indice_lista).getNome());

            musica = lista.get(indice_lista).getMusica();

        }
        if(view == card3){
            indice_lista = 2;
            //musica_selecionada.setText(lista.get(indice_lista).getNome());

            musica = lista.get(indice_lista).getMusica();

        }
        if(view == card4){
            indice_lista = 3;
            //musica_selecionada.setText(lista.get(indice_lista).getNome());

            musica = lista.get(indice_lista).getMusica();

        }
        if(view == card5){
            indice_lista = 4;
            //musica_selecionada.setText(lista.get(indice_lista).getNome());

            musica = lista.get(indice_lista).getMusica();

        }
        if(view == imgPreview){
            //baixa o valor
            indice_lista--;
            //estourou?
            if(indice_lista < 0){
                // se sim vamos para a ultima
                indice_lista = lista.size()-1;
            }
            //musica_selecionada.setText(lista.get(indice_lista).getNome());
            stop();
            play();

        }
        if(view == imgNext){
            indice_lista ++;
            if (indice_lista >= lista.size()){
                indice_lista = 0;

            }
            //musica_selecionada.setText(lista.get(indice_lista).getNome());
            stop();
            play();


        }



    }
    public void play(){
        if(mediaPlayer == null){
            mediaPlayer = MediaPlayer.create(this,lista.get(indice_lista).getMusica());
            //musica_tocando.setText(lista.get(indice_lista).getNome());

            toolbar.setTitle(lista.get(indice_lista).getNome());
            int x = indice_lista;
            x++;
            toolbar.setSubtitle(Integer.toString(x) + " de " + Integer.toString(lista.size()) );



            mediaPlayer.setOnCompletionListener(this);
            seekBar.setMax(mediaPlayer.getDuration()); // seek bar no tamanho da musica
            handler.post(this);
            mediaPlayer.start();
        }else if (!mediaPlayer.isPlaying()){
            mediaPlayer.start();
            handler.post(this);

        }
    }
    public void stop(){
        if( mediaPlayer != null){
            mediaPlayer.stop();
            mediaPlayer.release();
            mediaPlayer = null;
        }
    }

    //converte e dá uma string com o valor
    public String formato_tempo(int tempo){
        int segundos = tempo/1000;
        int minutos = segundos/60;
        segundos = segundos%60;
        String tempo_formatado = String.format("%02d:%02d", minutos, segundos);
        return tempo_formatado;
    }
}