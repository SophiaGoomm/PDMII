package com.example.projetopdmii;

public class playlist {
    public  playlist(String nome, int musica){
        this.nome = nome;
        this.musica = musica;
    }
    private String nome;
    private int musica;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getMusica() {
        return musica;
    }

    public void setMusica(int musica) {
        this.musica = musica;
    }
}
