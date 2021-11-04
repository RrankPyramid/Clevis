package hk.edu.polyu.comp.comp2021.clevis;

import hk.edu.polyu.comp.comp2021.clevis.model.Clevis;

public class Application {

    public static void main(String[] args){
        Clevis clevis = new Clevis();
        // Initialize and utilize the system
        Picture pic = new Picture(2000,2000);

        pic.draw();
    }

}
