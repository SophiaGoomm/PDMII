package com.example.projetopdmii;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class SlideAdapter extends RecyclerView.Adapter<SlideHolder> {

    private ArrayList <Slide> lista_slides;
    public SlideAdapter ( ArrayList<Slide> lista_slides){
        this.lista_slides = lista_slides;
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

    }

    @Override
    public int getItemCount() {
        return  lista_slides.size();
    }
}
