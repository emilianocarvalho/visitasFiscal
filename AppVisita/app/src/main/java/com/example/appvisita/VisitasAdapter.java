package com.example.appvisita;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.v4.view.LayoutInflaterCompat;
import android.support.v7.view.menu.MenuView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class VisitasAdapter extends RecyclerView.Adapter<VisitasAdapter.ViewHolderVisitas> {


        private List<visitasListar> dados;


        public VisitasAdapter(List<visitasListar> dados){

            this.dados=dados;


        }

    @NonNull
    @Override
    public ViewHolderVisitas onCreateViewHolder( ViewGroup parent, int viewType) {

        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());

        View view = layoutInflater.inflate(R.layout.linha_visitas, parent, false);


        ViewHolderVisitas holderVisitas = new ViewHolderVisitas(view);

        return holderVisitas;
    }

    @Override
    public void onBindViewHolder(@NonNull VisitasAdapter.ViewHolderVisitas holder, int position) {


            if((dados!= null) && (dados.size()>0)) {

                visitasListar v = dados.get(position);

                holder.txtCidade.setText(v.getCidade());
                holder.txtCnpj.setText(v.getCnpj());
                holder.txtEstabelecimento.setText(v.getRazao());
            }
    }

    @Override
    public int getItemCount() {
        return dados.size();
    }



    public class ViewHolderVisitas extends RecyclerView.ViewHolder{


            public TextView txtCidade;
            public TextView txtCnpj;
            public TextView txtEstabelecimento;

        public ViewHolderVisitas(View itemView) {
            super(itemView);

            txtCidade = itemView.findViewById(R.id.txt_cidade);
            txtCnpj = itemView.findViewById(R.id.txt_cnpj);
            txtEstabelecimento = itemView.findViewById(R.id.txt_razao);

        }
    }


}
