package edu.neu.madcourse.numad21fa_nadiiaramthun;


public class ItemCard {
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
}
