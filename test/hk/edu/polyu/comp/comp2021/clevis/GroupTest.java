package hk.edu.polyu.comp.comp2021.clevis;

import hk.edu.polyu.comp.comp2021.clevis.util.Vertex;
import junit.framework.TestCase;
import org.junit.Before;

public class GroupTest extends TestCase {

    int z1 = 1;
    int z2 = 2;
    int z3 = 3;

    Vertex v1 = new Vertex(0, 0);
    Vertex v2 = new Vertex(100, 100);


    Group g1 = new Group(z1);
    Group g2 = new Group(z2);


    public void testTestGetName() {
        Line l1 = new Line(v1,v2,z1);
        Line l2 = new Line(v1,v2,z2);

        g1.add_Shape("l1",l1);
        g1.add_Shape("l2",l2);
        assertEquals("l1",g1.getName()[1]);
        assertEquals("l2",g1.getName()[0]);
    }

    public void testGetGroupCounter() {
        assertEquals(0,g1.getGroupCounter());
    }

    public void testSetGroupCounter() {
    }

    public void testGetzOrder() {
        assertEquals(1,g1.getzOrder());
    }

    public void testSetzOrder() {
    }

    public void testAdd_Shape() {
    }

    public void testTestGetName1() {
    }

    public void testPrintInfo() {
    }

    public void testContainPoint() {
        Line l1 = new Line(v1,v2,z1);
        g1.add_Shape("l1",l1);

        assertTrue(g1.containPoint(new Vertex(50,50)));
        assertTrue(g1.containPoint(new Vertex(50,100)));
    }

    public void testMove() {
    }

    public void testGetTopLeft() {
    }

    public void testGetBottomRight() {
    }

    public void testIntersect() {
    }

    public void testTestIntersect() {
    }

    public void testTestIntersect1() {
    }

    public void testTestIntersect2() {
    }

    public void testGetInfo() {
    }

    public void testGetList() {
    }

    public void testSetList() {
    }
}