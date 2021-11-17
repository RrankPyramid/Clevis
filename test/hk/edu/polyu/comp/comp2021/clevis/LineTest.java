package hk.edu.polyu.comp.comp2021.clevis;

import hk.edu.polyu.comp.comp2021.clevis.model.Line;
import hk.edu.polyu.comp.comp2021.clevis.model.util.Vertex;
import junit.framework.TestCase;
import org.junit.Test;

import static hk.edu.polyu.comp.comp2021.clevis.model.util.GraphConstant.EPS;

public class LineTest extends TestCase {
    Vertex v1 = new Vertex(100,100);
    @Test
    public void testDistanceTo() {
        Line l1 = new Line(new Vertex(50,100),new Vertex(50,200));
        assertEquals(50, l1.distanceTo(v1),EPS );
    }
}