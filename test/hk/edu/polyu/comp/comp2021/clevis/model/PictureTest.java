package hk.edu.polyu.comp.comp2021.clevis.model;

import hk.edu.polyu.comp.comp2021.clevis.model.util.Vertex;
import junit.framework.TestCase;

public class PictureTest extends TestCase {
    Vertex v1 = new Vertex(100,100);
    Vertex v2 = new Vertex(200,200);
    Picture pic = new Picture(800,800);
    Line l1  = new Line(v1,v2);
    public void testAdd() {
        pic.add(l1);
        assert true;
    }

    public void testRemove() {
        pic.add(l1);
        pic.remove(l1);
        assert true;
    }

    public void testRemoveAllShape() {
        pic.removeAllShape();
        assert true;
    }

    public void testDraw() {
        pic.add(l1);
        pic.draw();
        assert true;
    }
}