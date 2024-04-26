package com.example.fassignment;

public class DogDetail {
        public String name;
        public int energy;
        public static String image;
        public int playfulness;

        public int drooling;

        public DogDetail(String name, int energy, String image,
                          int playfulness, int drooling) {

            this.name = name;
            this.energy = energy;
            this.image = image;
            this.playfulness = playfulness;
            this.drooling=drooling;
        }


        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getEnergy() {
            return energy;

        }
    public void setEnergy(int energy) {
        this.name = name;
    }

    public static String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
    public int getPlayfulness() {
        return playfulness;
    }

    public void setPlayfulness(int playfulness) {
        this.playfulness = playfulness;
    }
    public int getBarking() {
        return drooling;
    }

    public int setBarking(int barking) {
        return barking;
    }
    public static void someMethod() {
        System.out.println(image); // Now this is valid
    }
    }
