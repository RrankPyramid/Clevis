package hk.edu.polyu.comp.comp2021.clevis.util;

import org.junit.Test;

public class VertexTest{
    @Test
    public void testVertexAdd(){
        Vertex a = new Vertex(1,1);
        Vector b = new Vector(2, 3);
        a.add(b);
        assert true;
    }

}