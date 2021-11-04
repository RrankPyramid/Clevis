package hk.edu.polyu.comp.comp2021.clevis;

import hk.edu.polyu.comp.comp2021.clevis.model.Clevis;
import hk.edu.polyu.comp.comp2021.clevis.util.Vertex;

public class Application {

    public static void main(String[] args){
        Clevis clevis = new Clevis();
        // Initialize and utilize the system
        Picture pic = new Picture(600,600);
       Circle c1 = new Circle(new Vertex(100,100),50);
       c1.move(100,100);
//       Rectangle r1 = new Rectangle(0, 0, 100, 100);
//        Line l1 = new Line(0,205,400,205);
//        Circle c2 = new Circle(200,200,100);
        pic.add(c1);
//        pic.add(r1);
//        pic.add(l1);
//        pic.add(c2);
        pic.draw();
    }

}
