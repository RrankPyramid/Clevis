package hk.edu.polyu.comp.comp2021.clevis.model;

import hk.edu.polyu.comp.comp2021.clevis.Main;

import java.util.ArrayList;

/**
 * Clevis
 */
public class Clevis {

    /**
     * laucher of Clevies
     */
    public Clevis() {
    }

    /**
     * @param args Default parameters
     */
    public static void main(String[] args) {
        Main app = new Main();
        ArrayList<String> commands = app.start();
        app.writeInHtml(commands, "log.html");
        app.writeInTxt(commands, "log.txt");
    }

}
