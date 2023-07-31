package net.enjoy.springboot.registrationlogin.catapp;

public class Meme {
    private String text;
    private String memeUrl;

    public Meme() {
    }

    public Meme(String text, String memeUrl) {
        this.text = text;
        this.memeUrl = memeUrl;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getMemeUrl() {
        return memeUrl;
    }

    public void setMemeUrl(String memeUrl) {
        this.memeUrl = memeUrl;
    }
}
