package com.example.ricardo.cardeview.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.ricardo.cardeview.R;
import com.example.ricardo.cardeview.adapter.PostagemAdapter;
import com.example.ricardo.cardeview.model.Postagem;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerPostagem;
    private List<Postagem> postagens = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerPostagem = findViewById(R.id.recyclerPostagem);

        //Define layout
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);

        recyclerPostagem.setLayoutManager(layoutManager);


        // Definir Adapter
        this.prepararPostagem();

        PostagemAdapter adapter = new PostagemAdapter(postagens);
        recyclerPostagem.setAdapter(adapter);

    }

    public void prepararPostagem(){

        Postagem p = new Postagem("Ricardo de Novellis","#tbt Viagem Legal",R.drawable.imagem1);
        this.postagens.add(p);

        p = new Postagem("Hotel JH","Viagem, Aproveite nossos descontos",R.drawable.imagem2);
        this.postagens.add(p);

        p = new Postagem("Maria Luiza","#Paris",R.drawable.imagem3);
        this.postagens.add(p);

        p = new Postagem("Marcos Paulo","Que foto linda",R.drawable.imagem4);
        this.postagens.add(p);

    }
}
