package com.example.projetopdmii;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class SlideAdapter extends RecyclerView.Adapter<SlideHolder> {

    private ArrayList <Slide> lista_slides;
    private TextView texto;
    public SlideAdapter ( ArrayList<Slide> lista_slides){
        this.lista_slides = lista_slides;
    }
    public SlideAdapter ( ArrayList<Slide> lista_slides, TextView texto){
        this.lista_slides = lista_slides;
        this.texto = texto;
    }


    @NonNull
    @Override
    public SlideHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout, parent, false);
        return new SlideHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SlideHolder holder, int position) {
        holder.titulo.setText(lista_slides.get(position).getNome());
        holder.imagem.setImageResource(lista_slides.get(position).getImagem());

        //texto.setText(lista_slides.get(position).getTexto());

    }

    @Override
    public int getItemCount() {
        return  lista_slides.size();
    }
}
