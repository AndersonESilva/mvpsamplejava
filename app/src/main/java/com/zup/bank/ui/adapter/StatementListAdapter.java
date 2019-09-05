package com.zup.bank.ui.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.zup.bank.R;
import com.zup.bank.model.Statement;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

import static com.zup.bank.utils.ViewUtils.formatarDataBr;

public class StatementListAdapter extends RecyclerView.Adapter<StatementListAdapter.ViewHolder> {

    private List<Statement> list;
    private LayoutInflater inflater;
    private Statement statement;

    public StatementListAdapter(List<Statement> list, Context context){
        this.list = list;
        this.inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = inflater.inflate(R.layout.list_item_statement,viewGroup,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int i) {

        statement = list.get(i);

        holder.txt_pagamento.setText(statement.getTitle());
        holder.txt_data.setText(formatarDataBr(statement.getDate()));
        holder.txt_desc.setText(statement.getDesc());
        holder.txt_valor.setText("R$"+statement.getValue());

    }

    @Override
    public int getItemCount() {
        return list != null ? list.size() : 0;
    }

    static class ViewHolder extends RecyclerView.ViewHolder{

        @Bind(R.id.txt_pagamento)
        TextView txt_pagamento;

        @Bind(R.id.txt_data)
        TextView txt_data;

        @Bind(R.id.txt_desc)
        TextView txt_desc;

        @Bind(R.id.txt_valor)
        TextView txt_valor;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
