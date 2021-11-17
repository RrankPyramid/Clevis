package hk.edu.polyu.comp.comp2021.clevis;

import hk.edu.polyu.comp.comp2021.clevis.model.Circle;
import hk.edu.polyu.comp.comp2021.clevis.model.Group;
import hk.edu.polyu.comp.comp2021.clevis.model.Line;
import hk.edu.polyu.comp.comp2021.clevis.model.Rectangle;
import hk.edu.polyu.comp.comp2021.clevis.model.util.Vector;
import hk.edu.polyu.comp.comp2021.clevis.model.util.Vertex;
import junit.framework.TestCase;

import static hk.edu.polyu.comp.comp2021.clevis.model.util.GraphConstant.EPS;

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
        assertFalse(g1.containPoint(new Vertex(50,100)));
    }

    public void testMove() {
        Line l1 = new Line(v1,v2,z1);
        g1.add_Shape("l1",l1);
        g1.move(50,50);
        assert true;
    }

    public void testGetTopLeft() {
        Line l1 = new Line(v1,v2,z1);
        g1.add_Shape("l1",l1);
        assertEquals(0,g1.getTopLeft().getX(),EPS);
        assertEquals(0,g1.getTopLeft().getY(),EPS);
    }

    public void testGetBottomRight() {
        Line l1 = new Line(v1,v2,z1);
        g1.add_Shape("l1",l1);
        assertEquals(100,g1.getBottomRight().getX(),EPS);
        assertEquals(100,g1.getBottomRight().getY(),EPS);
    }

    public void testIntersectLine() {
        Line l1 = new Line(v1,v2,z1);
        Line l2 = new Line(new Vertex(0,100),new Vertex(100,0),z1);
        Line l3 = new Line(new Vertex(200,100),new Vertex(100,200),z1);
        g1.add_Shape("l1",l1);
        assertTrue(g1.intersect(l2));
        assertFalse(g1.intersect(l3));
    }

    public void testTestIntersect() {
        Line l1 = new Line(v1,v2,z1);
        Circle c1 = new Circle(v1,30,z1);
        Circle c2 = new Circle(v1,500,z1);
        g1.add_Shape("l1",l1);
        assertFalse(g1.intersect(c2));
        assertTrue(g1.intersect(c1));
    }

    public void testTestIntersect1() {
        Line l1 = new Line(v1,v2,z1);
        Rectangle r2 = new Rectangle(new Vertex(0,0),new Vector(50,50),z1);
        Rectangle r3 = new Rectangle(new Vertex(300,300),new Vector(50,50),z1);
        g1.add_Shape("l1",l1);
        assertTrue(g1.intersect(r2));
        assertFalse(g1.intersect(r3));
    }

    public void testTestIntersect2() {
        Line l1 = new Line(v1,v2,z1);
        Rectangle r2 = new Rectangle(new Vertex(0,0),new Vector(50,50),z1);
        Rectangle r3 = new Rectangle(new Vertex(300,300),new Vector(50,50),z1);
        g1.add_Shape("l1",l1);
        g2.add_Shape("r3",r3);
        assertFalse(g1.intersect(g2));
        g2.add_Shape("r2",r2);
        assertTrue(g1.intersect(g2));

    }

    public void testGetInfo() {
        Line l1 = new Line(v1,v2,z1);
        Rectangle r2 = new Rectangle(new Vertex(0,0),new Vector(50,50),z1);
        Rectangle r3 = new Rectangle(new Vertex(300,300),new Vector(50,50),z1);
        g1.add_Shape("l1",l1);
        assertEquals("g1 is a group",g1.getInfo("g1").get(0));
    }

    public void testGetList() {
    }

    public void testSetList() {
    }
}