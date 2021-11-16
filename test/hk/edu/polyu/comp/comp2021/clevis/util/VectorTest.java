package hk.edu.polyu.comp.comp2021.clevis.util;

import junit.framework.TestCase;
import org.junit.Test;

import static hk.edu.polyu.comp.comp2021.clevis.util.GraphConstant.EPS;

public class VectorTest extends TestCase {

    Vector A = new Vector(5,5);
    Vector B = new Vector(5,-5);
    Vector C = new Vector(-5,5);

    @Test
    public void testCrossProduct() {
        assertTrue(A.crossProduct(B)<0);
        assertTrue(A.crossProduct(C)>0);
        assertEquals(0, C.crossProduct(B),EPS);
    }
}