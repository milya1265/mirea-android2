package com.example.myapplication2.models;

public class AcidModel {
    String Name;
    String ShortName;
    int image;

    public AcidModel(String name, String shortName, int image) {
        Name = name;
        ShortName = shortName;
        this.image = image;
    }

    public String getName() {
        return Name;
    }

    public String getShortName() {
        return ShortName;
    }

    public int getImage() {
        return image;
    }
}
