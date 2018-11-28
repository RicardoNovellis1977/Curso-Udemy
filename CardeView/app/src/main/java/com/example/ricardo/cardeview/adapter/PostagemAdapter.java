package com.example.ricardo.cardeview.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.ricardo.cardeview.R;
import com.example.ricardo.cardeview.model.Postagem;

import java.util.List;

public class PostagemAdapter extends RecyclerView.Adapter<PostagemAdapter.MyViewHolder> {

    private List<Postagem> postagens;

    public PostagemAdapter(List<Postagem> p) {
        this.postagens = p;
    }

    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemLIsta = LayoutInflater.from(parent.getContext()).
                inflate(R.layout.postagem_detalhe, parent, false);

        return new MyViewHolder(itemLIsta);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        Postagem postagem = postagens.get(position);

        holder.txtnome.setText(postagem.getNome());
        holder.txtpostagem.setText(postagem.getPostagem());
        holder.imgimagem.setImageResource(postagem.getImagem());


    }

    @Override
    public int getItemCount() {
        return postagens.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{

        private TextView txtnome;
        private TextView txtpostagem;
        private ImageView imgimagem;

        public MyViewHolder(View itemView) {
            super(itemView);
            txtnome = itemView.findViewById(R.id.txtNome);
            txtpostagem = itemView.findViewById(R.id.txtPostagem);
            imgimagem =itemView.findViewById(R.id.imgPostagem);
        }
    }
}
