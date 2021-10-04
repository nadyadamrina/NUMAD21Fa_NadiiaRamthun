package edu.neu.madcourse.numad21fa_nadiiaramthun;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RviewAdapter extends RecyclerView.Adapter<RviewHolder>{
    private final List<ItemCard> itemCardList;
    private ItemClickListener listener;

    public RviewAdapter(List<ItemCard> itemCardList) {
        this.itemCardList = itemCardList;
    }

    public void setOnItemClickListener(ItemClickListener listener) {
        this.listener = listener;
    }

    @NonNull
    @Override
    public RviewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_card, parent, false);
        return new RviewHolder(view, listener);
    }

    @Override
    public void onBindViewHolder(@NonNull RviewHolder holder, int position) {
        ItemCard currentItem = itemCardList.get(position);
        holder.getNameView().setText(currentItem.getName());
        holder.getUrlView().setText(currentItem.getUrl());
    }

    @Override
    public int getItemCount() {
        return itemCardList.size();
    }
}
