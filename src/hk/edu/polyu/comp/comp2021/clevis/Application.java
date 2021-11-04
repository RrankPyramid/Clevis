package hk.edu.polyu.comp.comp2021.clevis;

import hk.edu.polyu.comp.comp2021.clevis.model.Clevis;
import hk.edu.polyu.comp.comp2021.clevis.util.Vector;
import hk.edu.polyu.comp.comp2021.clevis.util.Vertex;

public class Application {

    public static void main(String[] args){
        Clevis clevis = new Clevis();
        // Initialize and utilize the system
        Picture pic = new Picture(600,600);
        Rectangle r1 = new Rectangle(new Vertex(20,20),new Vector(100,200));
        r1.move(10,20);
//        Circle c2 = new Circle(200,200,100);
        pic.add(r1);
//        pic.add(l1);
//        pic.add(c2);
        pic.draw();

    }

}
