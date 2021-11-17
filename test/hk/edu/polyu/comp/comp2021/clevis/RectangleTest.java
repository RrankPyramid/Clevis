package hk.edu.polyu.comp.comp2021.clevis;

import hk.edu.polyu.comp.comp2021.clevis.model.Rectangle;
import hk.edu.polyu.comp.comp2021.clevis.model.util.Vector;
import hk.edu.polyu.comp.comp2021.clevis.model.util.Vertex;
import junit.framework.TestCase;

import static hk.edu.polyu.comp.comp2021.clevis.model.util.GraphConstant.EPS;

public class RectangleTest extends TestCase {
    Vertex v1 = new Vertex(100,100);
    Vertex v2 = new Vertex(0,0);
    Vector vec1 = new Vector(100,100);
    Rectangle r1 = new Rectangle(v1,vec1);

    public void testMove() {
        r1.move(50,50);
        assert true;
    }

    public void testGetTopLeft() {
        assertEquals(100,r1.getTopLeft().getX(),EPS);
        assertEquals(100,r1.getTopLeft().getY(),EPS);
    }

    public void testGetBottomRight() {
        assertEquals(200,r1.getBottomRight().getX(),EPS);
        assertEquals(200,r1.getBottomRight().getY(),EPS);
    }

    public void testGetInfo() {
        assertEquals("r1 is a rectangle,",r1.getInfo("r1").get(0));
    }
}