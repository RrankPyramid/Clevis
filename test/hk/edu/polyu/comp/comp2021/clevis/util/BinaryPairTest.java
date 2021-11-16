package hk.edu.polyu.comp.comp2021.clevis.util;


import junit.framework.TestCase;
import org.junit.Before;

/**
 *
 */
public class BinaryPairTest extends TestCase {

    BinaryPair A = null;
    BinaryPair B = null;
    BinaryPair C = null;
    BinaryPair D = null;

    double v1 = 1.1;
    double v2 = 11.1;
    double v3 = 111.1;
    double v4 = 111.11;
    double v5 = 11.11;
    double v6 = 1.11;

    @Before
    public void prepare(){

        A.setX(v1);
        A.setY(v2);
        B.setX(v3);
        B.setY(v4);
        C.setX(v5);
        C.setY(v6);
        D.setX(v5);
        D.setY(v4);
    }
    public void testGetX() {
        assertEquals(1.1,A.getX());
        assertEquals(111.1,B.getX());
        assertEquals(11.11,C.getX());
        assertEquals(11.11,D.getX());
    }

    public void testGetY() {
        assertEquals(1.1,A.getY());
        assertEquals(111.1,B.getY());
        assertEquals(11.11,C.getY());
        assertEquals(11.11,D.getY());
    }
}