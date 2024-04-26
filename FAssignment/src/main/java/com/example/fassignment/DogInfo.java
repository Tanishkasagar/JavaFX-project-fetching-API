package com.example.fassignment;

public class DogInfo {
    public final String name;
    public final int energy;
    public final String image;
    public final int playfulness;

    public final int grooming;

    public DogInfo(String name, int energy, String image, int playfulness, int grooming) {
        this.name = name;
        this.energy =energy;
        this.image=image;
        this.playfulness=playfulness;
        this.grooming=grooming;
    }

    public String getName() {
        return name;
    }

    public int getEnergy() {
        return energy;
    }


    public String getImage() {
        return image;
    }

    public int getPlayfulness(){
        return playfulness;
    }

    public int getGrooming(){
        return grooming;
    }

}