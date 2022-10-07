package com.example.listapersonalizada;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recyclerViewMeme);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 1)); //1 Coluna

        //Exemplo p/ aprender lista personalizada, na prática essas infos vêm de algum lugar
        dtoMeme meme1 = new dtoMeme();
        meme1.nome = "narigudokkkkkkkkk";
        meme1.ano = "1972";
        meme1.imagem = getResources().getDrawable(R.drawable.a);

        dtoMeme meme2 = new dtoMeme();
        meme2.nome = "BLEEEEEEEEEEEEH";
        meme2.ano = "2022";
        meme2.imagem = getResources().getDrawable(R.drawable.b);

        dtoMeme meme3 = new dtoMeme();
        meme3.nome = "Obungas";
        meme3.ano = "2001";
        meme3.imagem = getResources().getDrawable(R.drawable.c);

        dtoMeme meme4 = new dtoMeme();
        meme4.nome = "Trollface";
        meme4.ano = "2021";
        meme4.imagem = getResources().getDrawable(R.drawable.d);

        ArrayList<dtoMeme> dataSet = new ArrayList<>();
        dataSet.add(meme1);
        dataSet.add(meme2);
        dataSet.add(meme3);
        dataSet.add(meme4);

        RecyclerView.Adapter adapter = new CustomAdapter(dataSet);
        recyclerView.setAdapter(adapter);

        recyclerView.addOnItemTouchListener
                (new RecyclerItemClickListener(MainActivity.this, recyclerView, new RecyclerItemClickListener.OnItemClickListener() {
                    @Override
                    public void onItemClick(View view, int position) {
                        String nome = dataSet.get(position).nome;
                        Toast.makeText(MainActivity.this,
                                nome, Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onLongItemClick(View view, int position) {

                    }

                    @Override
                    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                    }
                }));

    }
}