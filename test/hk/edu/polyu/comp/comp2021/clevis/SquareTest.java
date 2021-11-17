package hk.edu.polyu.comp.comp2021.clevis;

import hk.edu.polyu.comp.comp2021.clevis.model.Square;
import hk.edu.polyu.comp.comp2021.clevis.model.util.Vector;
import hk.edu.polyu.comp.comp2021.clevis.model.util.Vertex;
import junit.framework.TestCase;

public class SquareTest extends TestCase {

    public void testGetInfo() {
        Square s1 = new Square(new Vertex(200,200),new Vector(200,200),1);
        assertEquals("s1 is a Square",s1.getInfo("s1").get(0));
    }
}