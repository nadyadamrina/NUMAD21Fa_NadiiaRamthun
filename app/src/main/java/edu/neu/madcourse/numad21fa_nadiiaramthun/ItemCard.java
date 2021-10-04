package edu.neu.madcourse.numad21fa_nadiiaramthun;

import android.content.Intent;
import android.net.Uri;

public class ItemCard implements ItemClickListener {
    private final String name;
    private final String url;

    public ItemCard(String name, String url) {
        this.name = name;
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public String getUrl() {
        return url;
    }

    @Override
    public void onItemClick(int position) {

    }
}
