package edu.neu.madcourse.numad21fa_nadiiaramthun;

public class ItemCard implements ItemClickListener {
    private String name;
    private String url;

    public ItemCard(String name, String url) {
        this.name = name;
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public void onItemClick(int position) {
        // TODO: open url in a browser
    }
}
