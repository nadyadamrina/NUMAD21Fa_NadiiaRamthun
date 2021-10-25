package edu.neu.madcourse.numad21fa_nadiiaramthun;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.LinkedHashMap;
import java.util.List;

public class UserRviewAdapter extends RecyclerView.Adapter<UserRviewHolder> {
    private final List<LinkedHashMap<String, String>> usersList;
    private ItemClickListener listener;

    public UserRviewAdapter(List<LinkedHashMap<String, String>> itemCardList) {
        this.usersList = itemCardList;
    }

    public void setListener(ItemClickListener listener) {
        this.listener = listener;
    }

    @NonNull
    @Override
    public UserRviewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.user, parent, false);
        return new UserRviewHolder(view, listener);
    }

    @Override
    public void onBindViewHolder(@NonNull UserRviewHolder holder, int position) {
        LinkedHashMap<String, String> currentItem = usersList.get(position);
        holder.getName().setText(currentItem.get("name"));
        holder.getEmail().setText(currentItem.get("email"));
    }

    @Override
    public int getItemCount() {
        return usersList.size();
    }
}
