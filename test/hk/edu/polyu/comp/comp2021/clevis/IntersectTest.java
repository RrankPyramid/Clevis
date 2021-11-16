package hk.edu.polyu.comp.comp2021.clevis;

import hk.edu.polyu.comp.comp2021.clevis.util.Vertex;
import junit.framework.TestCase;

public class IntersectTest extends TestCase {

    Vertex p1 = new Vertex(200, 200);
    Vertex p2 = new Vertex(200, 300);
    Vertex p3 = new Vertex(300, 200);
    Vertex p4 = new Vertex(300, 300);

    int z1 = 1;
    int z2 = 2;
    int z3 = 3;
    int z4 = 4;

    Line l1 = new Line(p1, p2, z1);
    Line l2 = new Line(p3, p4, z2);
    Circle c1 = new Circle(p1, 50, z3);
    Circle c2 = new Circle(p4, 200, z4);

    public void testLineIntersect() {
        assertFalse(l1.intersect(l2));
    }
    public void testCircleIntersect() {
        assertFalse(c1.intersect(c2));
    }
}
