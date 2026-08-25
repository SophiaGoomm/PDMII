package com.example.projetopdmii;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
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

    private TextView musica_selecionada, musica_tocando;

    private ArrayList <playlist> lista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_tela02);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
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
         handler = new Handler();



         musica = R.raw.forrodofarol_quincasmoreira;

         lista = new ArrayList<playlist>();
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

         musica_selecionada = findViewById(R.id.textView3);
         musica_tocando = findViewById(R.id.textView5);




    }

    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        //voltar
        if(id == android.R.id.home){
            finish();
        }
        //play
        if(id == R.id.id001){
            if(mediaPlayer == null){
                mediaPlayer = MediaPlayer.create(this, musica);
                musica_tocando.setText(lista.get(indice_lista).getNome());
                mediaPlayer.setOnCompletionListener(this);
                seekBar.setMax(mediaPlayer.getDuration());
                handler.post(this);
                mediaPlayer.start();
            }else if (!mediaPlayer.isPlaying()){
                mediaPlayer.start();

            }
        }
        //stop
        if(id == R.id.id003){
            if( mediaPlayer != null){
                mediaPlayer.stop();
                mediaPlayer.release();
                mediaPlayer = null;
            }

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
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu, menu);
        return true;

    }

    @Override
    public void onCompletion(MediaPlayer mediaPlayer) {
        mediaPlayer.release();
        mediaPlayer = null;
        seekBar.setProgress(0);
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int i, boolean b) {

    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {

    }

    @Override
    //controle da bolinha
    public void onStopTrackingTouch(SeekBar seekBar) {
        if(mediaPlayer != null){
            mediaPlayer.seekTo(seekBar.getProgress());
        }

    }

    @Override
    public void run() {
        if(mediaPlayer != null){
            seekBar.setProgress(mediaPlayer.getCurrentPosition());
            handler.postDelayed(this,1000);
        }

    }

    @Override
    public void onClick(View view) {

        if(view == card1){
            indice_lista = 0;
            musica_selecionada.setText(lista.get(indice_lista).getNome());

            musica = lista.get(indice_lista).getMusica();

        }
        if(view == card2){
            indice_lista = 1;
            musica_selecionada.setText(lista.get(indice_lista).getNome());

            musica = lista.get(indice_lista).getMusica();

        }
        if(view == card3){
            indice_lista = 2;
            musica_selecionada.setText(lista.get(indice_lista).getNome());

            musica = lista.get(indice_lista).getMusica();

        }
        if(view == card4){
            indice_lista = 3;
            musica_selecionada.setText(lista.get(indice_lista).getNome());

            musica = lista.get(indice_lista).getMusica();

        }
        if(view == card5){
            indice_lista = 4;
            musica_selecionada.setText(lista.get(indice_lista).getNome());

            musica = lista.get(indice_lista).getMusica();

        }


    }
}