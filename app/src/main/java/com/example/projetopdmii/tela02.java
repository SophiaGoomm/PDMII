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

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class tela02 extends AppCompatActivity implements MediaPlayer.OnCompletionListener , SeekBar.OnSeekBarChangeListener, Runnable , View.OnClickListener {
    //botão temporário
    private Button b;
    private boolean flag;
    private int musica;
   //-----------------------
    private Toolbar toolbar;
    private MediaPlayer mediaPlayer;
    private SeekBar seekBar;
    private Handler handler;

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

         b = findViewById(R.id.button2);
         b.setOnClickListener(this);
         flag = false;
         musica = R.raw.forrodofarol_quincasmoreira;



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
        if(view == b){
            if(!flag){
                musica = R.raw.forrodofarol_quincasmoreira;
                flag = true;
            }else {
                musica = R.raw.musiquinha01;
                flag = false;
            }
        }

    }
}