package com.example.projetopdmii;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;

public class SlideHolder extends ViewHolder {
    public TextView titulo;
    public ImageView imagem;

    public TextView texto;
    public SlideHolder(@NonNull View itemView) {
        super(itemView);
                 // porque eu estou em uma classe java então eu preciso de um cara para ir lá buscar
        titulo = itemView.findViewById(R.id.textView2);
        imagem = itemView.findViewById(R.id.imageView9);
        texto = itemView.findViewById(R.id.textView3);
    }
}
