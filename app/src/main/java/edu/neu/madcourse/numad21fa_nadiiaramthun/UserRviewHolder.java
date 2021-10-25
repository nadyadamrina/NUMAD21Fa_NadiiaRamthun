package edu.neu.madcourse.numad21fa_nadiiaramthun;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class UserRviewHolder extends RecyclerView.ViewHolder {
    private TextView name;
    private TextView email;

    public UserRviewHolder(@NonNull View itemView, final ItemClickListener listener) {
        super(itemView);
        this.name = itemView.findViewById(R.id.txtUserName);
        this.email = itemView.findViewById(R.id.txtEmail);

        itemView.setOnClickListener(getOnClickListener(listener));
    }

    @NonNull
    private View.OnClickListener getOnClickListener(ItemClickListener listener) {
        return v -> {
            if (listener != null) {
                int position = getLayoutPosition();
                if (position != RecyclerView.NO_POSITION) {
                    listener.onItemClick(position);
                }
            }
        };
    }

    public TextView getName() {
        return name;
    }

    public TextView getEmail() {
        return email;
    }
}
