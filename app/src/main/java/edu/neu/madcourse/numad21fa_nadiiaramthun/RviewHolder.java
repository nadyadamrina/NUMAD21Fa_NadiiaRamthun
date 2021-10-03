package edu.neu.madcourse.numad21fa_nadiiaramthun;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class RviewHolder extends RecyclerView.ViewHolder {

    private final TextView name;
    private final TextView url;

    public RviewHolder(@NonNull View itemView, final ItemClickListener listener) {
        super(itemView);
        name = itemView.findViewById(R.id.txtName);
        url = itemView.findViewById(R.id.txtLink);

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

    public TextView getUrl() {
        return url;
    }

}
