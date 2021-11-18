package hk.edu.polyu.comp.comp2021.clevis;

import hk.edu.polyu.comp.comp2021.clevis.model.Circle;
import hk.edu.polyu.comp.comp2021.clevis.model.Group;
import hk.edu.polyu.comp.comp2021.clevis.model.Line;
import hk.edu.polyu.comp.comp2021.clevis.model.Rectangle;
import hk.edu.polyu.comp.comp2021.clevis.model.util.Vector;
import hk.edu.polyu.comp.comp2021.clevis.model.util.Vertex;
import junit.framework.TestCase;

import java.util.ArrayList;

import static hk.edu.polyu.comp.comp2021.clevis.model.util.GraphConstant.EPS;

public class CircleTest extends TestCase {

    Vertex c1 = new Vertex(100, 100);
    Vertex c2 = new Vertex(200, 100);
    Vertex c3 = new Vertex(100, 300);

    int z1 = 1;
    int z2 = 2;
    int z3 = 3;

    Circle A = new Circle(c1, 100, z1);
    Circle B = new Circle(c2, 50, z2);
    Circle C = new Circle(c3, 100, z3);

    Rectangle rec = new Rectangle(new Vertex(200, 0), new Vector(100, 200), z1);
    Line line = new Line(c1, c2, z2);
    Line line2 = new Line(new Vertex(0, 50), new Vertex(200, 50), z2);
    Group group = new Group(z3);

    public void testGroupCounter() {
        A.setGroupCounter(6);
        assertEquals(6, A.getGroupCounter());
    }

    public void testGetzOrder() {
        assertEquals(1, A.getzOrder());
        assertEquals(2, B.getzOrder());
        B.setzOrder(5);
        assertEquals(5, B.getzOrder());
        assertEquals(3, C.getzOrder());
    }

    public void testGetCenter() {
        assertEquals(100, A.getCenter().getX(), EPS);
        assertEquals(100, A.getCenter().getY(), EPS);
        assertEquals(200, B.getCenter().getX(), EPS);
        assertEquals(100, B.getCenter().getY(), EPS);
        B.setCenter(new Vertex(123, 234));
        assertEquals(123, B.getCenter().getX(), EPS);
        assertEquals(234, B.getCenter().getY(), EPS);
        B.setCenter(c2);
    }


    public void testGetRadius() {
        assertEquals(100, C.getRadius(), EPS);
        C.setRadius(99);
        assertEquals(99, C.getRadius(), EPS);
        C.setRadius(100);
    }


    public void testContainPoint() {
        assertTrue(A.containPoint(c2));
        assertFalse(B.containPoint(c3));
    }

    public void testMove() {
        A.move(100, 0);
        assertEquals(200, A.getCenter().getX(), EPS);
        assertEquals(100, A.getCenter().getY(), EPS);
        A.move(-100, 0);
    }

    public void testGetTopLeft() {
        assertEquals(0, A.getTopLeft().getX(), EPS);
        assertEquals(0, A.getTopLeft().getY(), EPS);
    }

    public void testGetBottomRight() {
        assertEquals(200, A.getBottomRight().getX(), EPS);
        assertEquals(200, A.getBottomRight().getY(), EPS);
    }

    public void testIntersect() {
        assertTrue(A.intersect(B));
        assertFalse(C.intersect(B));
        assertTrue(A.intersect(line));
        group.add_Shape("recTest", rec);
        group.add_Shape("lineTest", line);
        assertTrue(A.intersect(group));
    }

    public void testIntersectRec() {
        assertTrue(A.intersect(rec));
    }

    public void testIntersectGrp() {
        group.add_Shape("recTest", rec);
        group.add_Shape("lineTest", line);
        assertTrue(A.intersect(group));
    }

    public void testTestIntersect() {
        Line l1 = new Line(new Vertex(100,100),new Vertex(100,150));
        Line l3 = new Line(new Vertex(100,100),new Vertex(300,300));
        Line l4 = new Line(new Vertex(300,300),new Vertex(100,100));
        Line l2 = new Line(new Vertex(0,300),new Vertex(300,300));
        assertTrue(A.intersect(line));
        assertTrue(A.intersect(line2));
        assertFalse(A.intersect(l1));
        assertFalse(A.intersect(l2));
        assertTrue(A.intersect(l3));
        assertTrue(A.intersect(l4));
    }

    public void testGetInfo() {
        ArrayList<String> info = A.getInfo("test");
        assertTrue(info.get(0).equals("test is a circle"));
    }
}