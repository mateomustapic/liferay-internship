package com.company;

/**
 * Created by Matea Pjanic on 21/02/2017.
 */
public class Bend {
    private String bendName;
    private String image;
    private Album[] albums;

    public String getBendName() {
        return bendName;
    }

    public void setBendName(String bendName) {
        this.bendName = bendName;
    }

    public String getImage() { return image; }

    public void setImage(String image) { this.image = image; }

    public Album[] getAlbums() {
        return albums;
    }

    public void setAlbums(Album[] albums) {
        this.albums = albums;
    }
}