package hk.edu.polyu.comp.comp2021.clevis.util;

import hk.edu.polyu.comp.comp2021.clevis.model.util.Vector;
import hk.edu.polyu.comp.comp2021.clevis.model.util.Vertex;
import org.junit.Test;

import static hk.edu.polyu.comp.comp2021.clevis.model.util.GraphConstant.EPS;
import static org.junit.Assert.assertEquals;

public class VertexTest {
    Vertex A = new Vertex(5, 6);
    Vertex B = new Vertex(7, 8);
    Vector C = new Vector(9, 10);


    @Test
    public void testVertexAdd() {
        Vertex test = A.add(C);
        assertEquals(14, test.getX(), EPS);
        assertEquals(16, test.getY(), EPS);

    }

    @Test
    public void vectorToTest() {
        Vector test = B.vectorTo(A);
        assertEquals(-2, test.getX(), EPS);
        assertEquals(-2, test.getY(), EPS);
    }

    @Test
    public void distanceToTest() {
        assertEquals(2.82842712, A.distanceTo(B), EPS);
    }
}